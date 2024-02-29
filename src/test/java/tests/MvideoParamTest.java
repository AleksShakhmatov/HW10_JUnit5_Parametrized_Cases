package tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
public class DnsParamTest {
    @ValueSource(strings = {
            "Delonghi", "Beko"
    })
    @ParameterizedTest
    void searchResultHeaderText(String brand) {
        open("https://www.dns-shop.ru");
        $(".presearch__input").setValue(brand).pressEnter();
        $$(".category-tile").shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}
