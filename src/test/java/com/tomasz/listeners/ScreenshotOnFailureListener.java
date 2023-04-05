package com.tomasz.listeners;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.OutputType.BYTES;

import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import java.io.ByteArrayInputStream;
import java.util.UUID;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ScreenshotOnFailureListener extends AllureTestNg implements LogEventListener {
  @Override
  public void onTestFailure(final ITestResult result) {
    byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(BYTES);
    Allure.addAttachment(
        UUID.randomUUID().toString(),
        new ByteArrayInputStream(screenshot));
  }

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    super.onTestFailedWithTimeout(result);
  }


  @Override
  public void afterEvent(LogEvent currentLog) {

  }

  @Override
  public void beforeEvent(LogEvent currentLog) {

  }

  @Override
  public void onConfigurationSuccess(ITestResult tr, ITestNGMethod tm) {
    super.onConfigurationSuccess(tr, tm);
  }

  @Override
  public void onConfigurationFailure(ITestResult tr, ITestNGMethod tm) {
    super.onConfigurationFailure(tr, tm);
  }

  @Override
  public void onConfigurationSkip(ITestResult tr, ITestNGMethod tm) {
    super.onConfigurationSkip(tr, tm);
  }

  @Override
  public void beforeConfiguration(ITestResult tr) {
    super.beforeConfiguration(tr);
  }

  @Override
  public void beforeConfiguration(ITestResult tr, ITestNGMethod tm) {
    super.beforeConfiguration(tr, tm);
  }

  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult,
      ITestContext context) {
    super.beforeInvocation(method, testResult, context);
  }

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    super.afterInvocation(method, testResult, context);
    if (!testResult.isSuccess()) {
      byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(BYTES);
      Allure.addAttachment(
          UUID.randomUUID().toString(),
          new ByteArrayInputStream(screenshot));
    }
  }
}
