package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class RegistrationPage {

    SelenideElement titleLabel = $(".practice-form-wrapper"),
                    firstName = $("#firstName"),
                    lastName = $("#lastName"),
                    userEmail = $("#userEmail"),
                    userNumber = $("#userNumber"),
                    userSubject = $("#subjectsInput"),
                    userAddress = $("#currentAddress"),
                    uploadButton = $("#uploadPicture"),
                    genderMaleRadio = $(byText("Male")),
                    genderFemaleRadio = $(byText("Female")),
                    genderOtherRadio = $(byText("Other")),
                    sportsCheckbox = $(byText("Sports")),
                    readingCheckbox = $(byText("Reading")),
                    musicCheckbox = $(byText("Music")),
                    submitButton = $("#submit");

    public RegistrationPage setFirstName(String value) {
        firstName.val(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.val(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.val(value);
        return this;
    }

    public RegistrationPage setUserAddress(String value) {
        userAddress.val(value);
        return this;
    }

    public RegistrationPage setUserPhoneNumber(String value) {
        userNumber.val(value);
        return this;
    }

    public RegistrationPage setUserSubject(String value) {
        userSubject.val(value);
        return this;
    }

    public RegistrationPage clickGenderMaleRadio() {
        genderMaleRadio.click();
        return this;
    }

    public RegistrationPage clickGenderFemaleRadio() {
        genderFemaleRadio.click();
        return this;
    }

    public RegistrationPage clickGenderOtherRadio() {
        genderOtherRadio.click();
        return this;
    }

    public RegistrationPage clickSportsCheckbox() {
        sportsCheckbox.click();
        return this;
    }

    public RegistrationPage clickReadingCheckbox() {
        readingCheckbox.click();
        return this;
    }

    public RegistrationPage clickMusicCheckbox() {
        musicCheckbox.click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadButton.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public void fillRegistrationForm(String firstName, String lastName, String userPhone, String userEmail,
                                     String userAddress, String userSubject){
        setFirstName(firstName);
        setLastName(lastName);
        setUserPhoneNumber(userPhone);
        setUserAddress(userAddress);
        setUserEmail(userEmail);
        setUserSubject(userSubject);
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
}
