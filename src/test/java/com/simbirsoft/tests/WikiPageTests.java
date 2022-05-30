package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiPageTests {
    private String urlSite = "https://github.com/selenide/selenide";
    private String junit5Text = "3. Using JUnit5 extend test class:";
    private String wikiNameLocator = "#wiki-tab";
    private String softAssertionLocator = ".markdown-body [href='/selenide/selenide/wiki/SoftAssertions']";
    private String junit5Locator = ".markdown-body h4:nth-child(18)";

    @BeforeEach
    public void helperDriver() {
        System.setProperty("selenide.browser", "Firefox");
        Configuration.startMaximized = true;
        open(urlSite);
    }

    @Test
    public void followToTextSoftAssertions_TextSoftAssertionsIsBe() {
        $(wikiNameLocator).click();
        $(softAssertionLocator).shouldBe((and("Clickable", visible, enabled)));
    }

    @Test
    public void followToJunit5Text_TextJunit5IsBe() {
        $(wikiNameLocator).click();
        $(softAssertionLocator).click();
        $(junit5Locator).shouldHave(text(junit5Text));
    }
}
