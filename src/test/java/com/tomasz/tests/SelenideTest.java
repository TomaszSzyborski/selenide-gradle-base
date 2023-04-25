package com.tomasz.tests;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.tomasz.core.Config;
import com.tomasz.listeners.ScreenshotOnFailureListener;
import com.tomasz.pages.MainPage;
import com.tomasz.rest.actions.AdministrativePurge;
import org.testng.annotations.*;

@Listeners({ScreenshotOnFailureListener.class})
interface SelenideTest {
  MainPage mainPage = new MainPage();

  @AfterClass(description = "Purging the data after each test")
  default void purgeData() {
    AdministrativePurge.perform();
  }

  @BeforeSuite
  default void selenideConfiguration() {
    Configuration.baseUrl = Config.getProperties().getProperty("FrontEndUrl");
    Configuration.headless = true;
    Configuration.driverManagerEnabled = true;
    Configuration.holdBrowserOpen = false;
    Configuration.reopenBrowserOnFail = false;
  }

  @BeforeMethod(description = "Opening the Browser")
  default void openBrowser() {
    open();
  }
}
