package com.example.colornote.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TextNoteEditorPage extends BasePage {

    private final By titleField = By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_title");
    private final By bodyField  = By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note");
    private final By doneButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/done");

    private final By moreMenu   = By.id("com.socialnmobile.dictapps.notepad.color.note:id/menu_more");
    private final By deleteMenuText = By.xpath("//*[@text='Delete']");

    public TextNoteEditorPage(AndroidDriver driver) {
        super(driver);
    }

    public TextNoteEditorPage enterTitle(String title) {
        driver.findElement(titleField).clear();
        driver.findElement(titleField).sendKeys(title);
        return this;
    }

    public TextNoteEditorPage enterBody(String body) {
        driver.findElement(bodyField).clear();
        driver.findElement(bodyField).sendKeys(body);
        return this;
    }

    public HomePage save() {
        driver.findElement(doneButton).click();
        return new HomePage(driver);
    }

    public TextNoteEditorPage editBodyAppend(String extra) {
        driver.findElement(bodyField).sendKeys(extra);
        return this;
    }

    public HomePage deleteNote() {
        driver.findElement(moreMenu).click();
        driver.findElement(deleteMenuText).click();
        tapText("OK"); // Confirm dialog
        return new HomePage(driver);
    }
}
