package com.tomasz.tests;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.selenide.LogType.BROWSER;
import static java.util.logging.Level.ALL;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tomasz.pages.MainPage;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
  protected final MainPage mainPage = new MainPage();

  @BeforeSuite
  public static void setupAllureReports() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
        .screenshots(true)
        .savePageSource(false)
        .enableLogs(BROWSER, ALL));
    Configuration.baseUrl = "https://practice.automationbro.com";
    Configuration.headless = true;
    Configuration.driverManagerEnabled = true;
    Configuration.holdBrowserOpen = false;
    Configuration.reopenBrowserOnFail = true;
  }

  @BeforeMethod
  @Step("Opening the browser")
  public void openBrowser() {
    open("/");
  }
}
