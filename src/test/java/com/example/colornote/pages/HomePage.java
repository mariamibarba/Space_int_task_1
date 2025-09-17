package com.example.colornote.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By addButton = By.id("    private final By addButton = By.xpath(\"//android.view.ViewGroup[@resource-id=\\\"notes.notepad.checklist.calendar.todolist:id/fabMenu\\\"]/android.widget.ImageView\"); // or fab id; adjust if needed\n"); // or fab id; adjust if needed
    private final By listItemTitle = By.id("com.socialnmobile.dictapps.notepad.color.note:id/title");   // note title in list
    private final By searchButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/search");   // toolbar search

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public HomePage tapAdd() {
        driver.findElement(addButton).click();
        return this;
    }

    public HomePage tapAddTextNote() {
        tapText("Text");
        return this;
    }

    public boolean isNoteVisible(String title) {
        return driver.findElements(listItemTitle)
                .stream()
                .anyMatch(e -> title.equalsIgnoreCase(e.getText()));
    }

    public SearchPage openSearch() {
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    public HomePage openNoteByTitle(String title) {
        driver.findElements(listItemTitle)
                .stream()
                .filter(e -> title.equalsIgnoreCase(e.getText()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Note not found: " + title))
                .click();
        return this;
    }
}
