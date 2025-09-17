package com.example.colornote.tests;

import com.example.colornote.base.BaseTest;
import com.example.colornote.pages.HomePage;
import com.example.colornote.pages.SearchPage;
import com.example.colornote.pages.TextNoteEditorPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test(description = "Create a note and find it using Search")
    public void search_findsCreatedNote() {
        String title = "Findable Note";
        String body  = "Search me!";

        HomePage home = new HomePage(driver);
        home.tapAdd().tapAddTextNote();

        new TextNoteEditorPage(driver)
                .enterTitle(title)
                .enterBody(body)
                .save();

        SearchPage search = home.openSearch();
        search.typeQuery("Findable");

        Assertions.assertThat(search.hasResultWithTitle(title))
                .as("Search results should include the note title")
                .isTrue();
    }
}
