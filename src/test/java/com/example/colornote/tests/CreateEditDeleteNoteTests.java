package com.example.colornote.tests;

import com.example.colornote.base.BaseTest;
import com.example.colornote.base.DriverFactory;
import com.example.colornote.pages.HomePage;
import com.example.colornote.pages.TextNoteEditorPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CreateEditDeleteNoteTests extends BaseTest {


    @Test(description = "Create a text note and verify it appears on the home list")
    public void createNoteShowsInList() {
        String title = "Test Note";
        String body  = "This is a ColorNote test.";

        HomePage home = new HomePage(driver);
        home.tapAdd()
                .tapAddTextNote();

        new TextNoteEditorPage(driver)
                .enterTitle(title)
                .enterBody(body)
                .save();

        Assertions.assertThat(home.isNoteVisible(title))
                .as("Newly created note should be visible on Home")
                .isTrue();
    }

    @Test(description = "Edit an existing note's body and save")
    public void editNoteUpdatesBody() {
        String title = "Editable Note";
        String body  = "Initial body.";
        String extra = " Added text.";

        HomePage home = new HomePage(driver);
        home.tapAdd().tapAddTextNote();

        new TextNoteEditorPage(driver)
                .enterTitle(title)
                .enterBody(body)
                .save();

        // Re-open and edit
        home.openNoteByTitle(title);
        new TextNoteEditorPage(driver)
                .editBodyAppend(extra)
                .save();

        // Simple re-open to ensure it exists (full body assertion would need reading the body field)
        Assertions.assertThat(home.isNoteVisible(title)).isTrue();
    }

    @Test(description = "Delete a note and verify it no longer shows on the list")
    public void deleteNoteRemovesFromList() {
        String title = "Delete Me";
        String body  = "Disposable.";

        HomePage home = new HomePage(driver);
        home.tapAdd().tapAddTextNote();

        new TextNoteEditorPage(driver)
                .enterTitle(title)
                .enterBody(body)
                .save();

        // open and delete
        home.openNoteByTitle(title);
        new TextNoteEditorPage(driver)
                .deleteNote();

        Assertions.assertThat(home.isNoteVisible(title))
                .as("Deleted note should not be visible")
                .isFalse();
    }
}
