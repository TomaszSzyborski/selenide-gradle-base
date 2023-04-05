package com.tomasz.tests;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.tomasz.listeners.ScreenshotOnFailureListener;
import com.tomasz.pages.MainPage;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ScreenshotOnFailureListener.class})
public abstract class BaseTest {
  protected final MainPage mainPage = new MainPage();

  @BeforeSuite
  public static void selenideConfiguration() {
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
