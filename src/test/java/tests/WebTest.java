/*
package tests;
import com.codeborne.selenide.Configuration;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.components.Language;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


 public class WebTest {
    @BeforeAll
    static void beforeAll() {
        open("https://aliexpress.ru/");
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 6000;
    }

    @EnumSource(Language.class)
    @ParameterizedTest
    void selenideSiteShouldDisplayCorrectText(Language language) {
        $(".ShipToHeaderItem_SnowTooltip__wrapper__y68ab").click();
        $$(".ShipToHeaderItem_SnowTooltip__contentWrap__y68ab").find(text(language.name())).click();
        $(".snow-container_SnowContainer__container__rkv8lv").shouldHave(text(language.description));
    }
        //@BeforeAll
        //static void beforeAll() {
            //open("https://aliexpress.ru/");
            //Configuration.browserSize = "1920x1080";
            //Configuration.pageLoadStrategy = "eager";
            //executeJavaScript("$('#fixedban').remove()");
            //executeJavaScript("$('footer').remove()");
       // }
       // @EnumSource(Language.class)
        //@ParameterizedTest
        //void AliSiteShouldDisplayCorrectText(@NotNull Language language) {
            //$("div.ShipToHeaderItem_ShipToHeaderItem__element__1ot1v").click();
            //$("ul.ShipToHeaderItem_List__wrapper__1ixqb").find(text(language.name())).click();
            //$(".Diamonds_Diamond__item__1p4wo").shouldHave(text(language.description));
            // $("span.red-ali-kit_Typography__base__16fy3h").shouldHave(text("Одна цена"));

            //$(".footer_lang").find(String.valueOf(text(language.name()))).click();
            //$(".VkIdForm__header").shouldHave(text(language.description));
        }
*/
