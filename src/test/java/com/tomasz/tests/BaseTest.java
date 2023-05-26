package com.tomasz.tests;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.google.inject.Inject;
import com.tomasz.core.Config;
import com.tomasz.listeners.ScreenshotOnFailureListener;
import com.tomasz.pages.MainPage;
import com.tomasz.rest.actions.AdministrativePurge;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({ScreenshotOnFailureListener.class})
public abstract class BaseTest {
  // TODO abstract classes or interfaces for tests?
  // interfaces would segregate API from UI tests, and merge them if required
  protected final MainPage mainPage = new MainPage();

  @AfterClass(description = "Purging the data after each test")
  public void purgeData() {
    AdministrativePurge.perform();
  }

  @BeforeSuite
  public static void selenideConfiguration() {
    Configuration.baseUrl = Config.getProperties().getProperty("FrontEndUrl");
    Configuration.headless = Boolean.parseBoolean(System.getProperty("headless"));
    Configuration.browserSize = "1920x1200";
    Configuration.browserPosition = "0x0";
    Configuration.driverManagerEnabled = true;
    Configuration.holdBrowserOpen = false;
    Configuration.reopenBrowserOnFail = false;
    Configuration.timeout = Duration.ofSeconds(10).toMillis();
  }

  @BeforeMethod(description = "Opening the Browser")
  public void openBrowser() {
    open("/");
  }
}
