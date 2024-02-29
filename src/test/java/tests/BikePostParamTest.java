package tests;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Selenide.*;



public class BikePostParamTest {

    @BeforeAll
    static void beforeAll() {
        open("https://moto-magazine.ru");
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = {
            "Honda", "Yamaha", "Kawasaki", "Suzuki"
    })
    @ParameterizedTest
    void FindCountResultsForModel(String moto) {
        $(".srch-input").setValue(moto).pressEnter();
        $$(".search-page").shouldBe(CollectionCondition.sizeGreaterThan(0));

    }

    @CsvFileSource(resources = "/test_data/searchResultsShouldContainExpectedUrl.csv")
    @ParameterizedTest
    void searchResultsForModelWithTestData(String moto) {
        $(".srch-input").setValue(moto).pressEnter();
        $(".search-page")
                .shouldHave(Condition.text(moto));
    }

    @CsvSource(value = {
            "Indian, Indian",
            "Triumph, Triumph"
    })
    @ParameterizedTest
    void searchResultsForModelWithoutTestData(String moto) {
        $(".srch-input").setValue(moto).pressEnter();
        $(".search-page")
                .shouldHave(Condition.text(moto));
    }

}


