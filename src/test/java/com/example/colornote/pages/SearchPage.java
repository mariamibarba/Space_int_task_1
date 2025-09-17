package com.example.colornote.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    private final By searchSrcText = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"android:id/search_src_text\")");

    private final By resultTitle = By.id("com.socialnmobile.dictapps.notepad.color.note:id/title");

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    public SearchPage typeQuery(String text) {
        driver.findElement(searchSrcText).sendKeys(text);
        return this;
    }

    public boolean hasResultWithTitle(String title) {
        return driver.findElements(resultTitle)
                .stream().anyMatch(e -> title.equalsIgnoreCase(e.getText()));
    }
}
