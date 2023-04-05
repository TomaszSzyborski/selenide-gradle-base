package com.tomasz.tests;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class SampleSelenideTest extends BaseTest {


  @Test
  @Step("is at 1")
  public void test() {
    mainPage.isAt();
  }

  @Test
  @Step("is at 1")
  public void test2() {
    mainPage.isAt();
  }

  @Test
  @Step("is at 1")
  public void test3() {
    mainPage.isAt();
  }

  @Test
  @Step("is at 1")
  public void test4() {
    $(".custom-logo-link").should(disappear);
  }
}
