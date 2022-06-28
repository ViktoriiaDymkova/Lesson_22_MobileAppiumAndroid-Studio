
package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MyTest extends TestBase {

    //@Tag("android")
    @Test
    void searchTest() {
        String value = "Italy";

        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(value);
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(CollectionCondition.sizeGreaterThan(0)));
        $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(text(value));
        $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                .shouldHave(Condition.text("Country in Southern Europe"));
        $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description")).shouldNotHave(text("USA"));
    }

    @Test
    void searchNegativeTest() {
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("__________________");
        });

        step("Verify no results displayed", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/results_text"))
                        .shouldHave(text("No results"))
        );
    }
}