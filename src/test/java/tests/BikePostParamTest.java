package tests;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class BikePostSearchTest {




    @ValueSource(strings = {
            "Honda", "Yamaha", "Kawasaki", "Suzuki"
    })
    @ParameterizedTest
    void successFindInfoForModel(String moto) {
        open("https://moto-magazine.ru");
        $(".srch-input").setValue(moto).pressEnter();
        $$(".search-page").shouldBe(CollectionCondition.sizeGreaterThan(0));

    }

    @CsvFileSource(resources = "/test_data/searchResultsShouldContainExpectedUrl.csv")
    @ParameterizedTest
    void searchResulModelText(String moto) {
        open("https://moto-magazine.ru");
        $(".srch-input").setValue(moto).pressEnter();
        $(".search-page")
                .shouldHave(Condition.text(moto));
    }

    @CsvSource(value = {
            "DeLonghi , https://www.mvideo.ru/brand/delonghi-64?categoryId=4",
            "Beko , https://www.mvideo.ru/brand/beko-863?categoryId=50"
    })
    @ParameterizedTest
    void searchResultHeaderText(String brand, String link) {
        open(" https://www.mvideo.ru/");
        $(".input__container").setValue(brand).pressEnter();
        $(".c-category-list")
                .shouldHave(text(link));
}}


