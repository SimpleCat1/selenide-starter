package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropPageTests {
    private String urlSite = "https://the-internet.herokuapp.com/drag_and_drop";
    private String aNameBlock = "#column-a";
    private String bNameBlock = "#column-b";
    private String aBlockAfterDragAndDrop = "#column-a header";
    private String aBlockAfterDragAndDropText = "B";
    private String bBlcokAfterDragAndDrop = "#column-b header";
    /* private String bBlcokAfterDragAndDrop = "#column-b header:contains('A')"; Почему-то не работает,
    хотя в консоли браузера работает...
    */
    //1
    //2
    //3
    private String bBlcokAfterDragAndDropText = "A";

    @BeforeEach
    public void helperDriver() {
        System.setProperty("selenide.browser", "Firefox");
        Configuration.startMaximized = true;
    }

    @Test
    public void DragAndDropAToB_BIsInAnotherPlace() {
        open(urlSite);
        $(aNameBlock).dragAndDropTo($(bNameBlock));
        $(aBlockAfterDragAndDrop).shouldHave(text(aBlockAfterDragAndDropText));
        $(bBlcokAfterDragAndDrop).shouldHave(text(bBlcokAfterDragAndDropText));
    }
}
