package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
public class MvideoParamTest {

    @BeforeAll
    static void beforeAll() {
        open("https://www.mvideo.ru/");
        Configuration.browserSize = "1920x1080";
    }
    @ValueSource(strings = {
            "Delonghi", "Beko"
    })
    @ParameterizedTest
    void FindCountResults(String brand) {
        $(".input__container").setValue(brand).pressEnter();
        $$("li.c-category-list__item").shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
    @CsvSource(value = {
            "Delonghi, Каталог бренда DeLonghi",
            "Beko, Каталог бренда Beko"
    })
    @ParameterizedTest
    void searchResultHeaderText(String brand, String headerText) {
        $(".input__container").setValue(brand).pressEnter();
        $("h1").shouldHave(text(headerText));
    }
}
