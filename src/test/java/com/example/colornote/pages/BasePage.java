package com.example.colornote.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected AndroidDriver driver;

    protected BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    protected WebElement byText(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + text + "\")"));
    }

    protected WebElement byId(String id) {
        return driver.findElement(By.id(id));
    }

    protected void tapText(String text) {
        byText(text).click();
    }

    protected boolean existsByText(String text) {
        return driver.findElements(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + text + "\")")).size() > 0;
    }
}
