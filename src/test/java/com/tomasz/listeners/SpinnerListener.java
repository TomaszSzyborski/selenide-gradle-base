package com.tomasz.listeners;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SpinnerListener implements WebDriverListener {

    private final SelenideElement spinner = $("#spinner");
    /**
     * Used when Selenide Configuration jsClick and fastSetValue is set to false (default behaviour)
     * listener triggers before click and waits until spinner is not visible
     */
    @Override
    public void beforeClick(WebElement element) {
        spinner.shouldNotBe(visible, Duration.ofSeconds(60));
    }

    /**
     * Used when Selenide Configuration jsClick and fastSetValue is set to true
     * listener triggers before any JS script is triggered and waits until spinner is not visible
     */
    @Override
    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
        spinner.shouldNotBe(visible);
    }

    /**
     * Used whenever submit event is triggered
     */
    @Override
    public void beforeSubmit(WebElement element) {
        spinner.shouldNotBe(visible);
    }
}
