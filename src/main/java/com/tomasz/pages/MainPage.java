package com.tomasz.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class MainPage {

  private final SelenideElement logo = $(".custom-logo-link");

  @Step("Checking if user is at home page")
  public void isAt() {
    logo.shouldBe(visible);
  }
}
