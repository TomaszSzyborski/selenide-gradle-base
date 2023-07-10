package com.tomasz.tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.tomasz.core.PropertySupplier.getEnvironmentConfigurationData;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.tomasz.listeners.ScreenshotOnFailureListener;
import com.tomasz.listeners.SpinnerListener;
import com.tomasz.pages.MainPage;
import com.tomasz.rest.actions.AdministrativePurge;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ScreenshotOnFailureListener.class})
public abstract class BaseTest {
  // TODO abstract classes or interfaces for tests?
  // interfaces would segregate API from UI tests, and merge them if required
  protected final MainPage mainPage = new MainPage();

//  @AfterClass(description = "Purging the data after each test")
//  public void purgeData() {
//    AdministrativePurge.perform();
//  }

  @BeforeSuite
  public static void selenideConfiguration() {
    Configuration.baseUrl = getEnvironmentConfigurationData().getFrontEndUrl();
    Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
    Configuration.browserSize = "1920x1200";
    Configuration.browserPosition = "0x0";
    Configuration.driverManagerEnabled = true;
    Configuration.holdBrowserOpen = false;
    Configuration.reopenBrowserOnFail = false;
    Configuration.timeout = Duration.ofSeconds(10).toMillis();
  }

  @BeforeMethod(description = "Opening the Browser")
  public void openBrowser() {
    WebDriverListener listener = new SpinnerListener();
    WebDriverRunner.addListener(listener);
    WebDriver original = WebDriverRunner.getAndCheckWebDriver();
    WebDriverRunner.setWebDriver(
            new EventFiringDecorator<>(listener)
                    .decorate(original)
    );

    open("/");
    webdriver().object().manage().window().maximize();
  }
}
