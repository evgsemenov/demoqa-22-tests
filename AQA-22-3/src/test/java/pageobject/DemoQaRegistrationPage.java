package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SetValueOptions;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.Keys.DELETE;

public class DemoQaRegistrationPage {
    SelenideElement firstName = $("#firstName");
    SelenideElement lastName = $("#lastName");
    SelenideElement userEmail = $("#userEmail");
    SelenideElement userPhone = $("#userNumber");
    SelenideElement subjects = $("#subjectsInput");
    SelenideElement address = $("#currentAddress");
    SelenideElement dateOfBirthField = $("#dateOfBirthInput");
    SelenideElement uploadButton = $("#uploadPicture");
    SelenideElement genderMale = $(byText("Male"));
    SelenideElement genderFemale = $(byText("Female"));
    SelenideElement genderOther = $(byText("Other"));
    SelenideElement hobbie1 = $(byText("Sports"));
    SelenideElement hobbie2 = $(byText("Reading"));
    SelenideElement hobbie3 = $(byText("Music"));
    SelenideElement state = $("#state");
    private SelenideElement submitButton = $("#submit");
    public SelenideElement successSubmitWindowHeader = $("#example-modal-sizes-title-lg");
    public SelenideElement successSubmitWindow = $(".table-responsive");

    public void fillForm(String firstNameValue, String lastNameValue, String emailValue,
                         String userPhoneValue, String dateOfBirthValue, String subjectsValue, String addressValue) {
        firstName.val(firstNameValue);
        lastName.val(lastNameValue);
        userEmail.val(emailValue);
        userPhone.val(userPhoneValue);
        subjects.val(subjectsValue);
        address.val(addressValue);
        genderFemale.click();
        genderMale.click();
        genderOther.click();
        hobbie1.click();
        hobbie2.click();
        hobbie3.click();
        uploadButton.uploadFromClasspath("screenshot_22-1.png");
        dateOfBirthField.val(dateOfBirthValue);
        submitButton.click();
        successSubmitWindowHeader.shouldHave(Condition.text("Thanks for submitting the form"));
    }
    public void clearForm() {
        firstName.sendKeys(DELETE);
        lastName.sendKeys(DELETE);
        userEmail.sendKeys(DELETE);
        userPhone.sendKeys(DELETE);
        dateOfBirthField.sendKeys(DELETE);
        address.sendKeys(DELETE);
//        subjects.sendKeys(DELETE);
    }
}

