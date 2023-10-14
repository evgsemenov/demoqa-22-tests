package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {
    SelenideElement successfulRegistrationPage = $("#example-modal-sizes-title-lg"),
                    tableResponsive = $(".table-responsive");

    public CheckResultComponent checkResult(String key, String value) {
        successfulRegistrationPage.shouldHave(text("Thanks for submitting the form"));
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(key + " " + value));
        return this;
    }
}
