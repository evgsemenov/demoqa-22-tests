package pageobject;

import com.codeborne.selenide.SelenideElement;
import pageobject.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement titleLabel = $(".practice-form-wrapper"),
                    firstName = $("#firstName"),
                    lastName = $("#lastName"),
                    userEmail = $("#userEmail"),
                    userNumber = $("#userNumber"),
                    userSubject = $("#subjectsInput"),
                    userAddress = $("#currentAddress"),
                    uploadButton = $("#uploadPicture"),
                    genderMaleRadio = $("#genterWrapper"),
                    genderFemaleRadio = $(byText("Female")),
                    genderOtherRadio = $(byText("Other")),
                    sportsCheckbox = $("#hobbiesWrapper"),
                    readingCheckbox = $(byText("Reading")),
                    musicCheckbox = $(byText("Music")),
                    submitButton = $("#submit"),
                    successfulRegistrationPage = $("#example-modal-sizes-title-lg");

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
        userSubject.val(value).pressEnter();
        return this;
    }

    public RegistrationPage clickGenderRadio(String value) {
        genderMaleRadio.$(byText(value)).click();
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

    public RegistrationPage clickHobbiesCheckbox(String value) {
        sportsCheckbox.$(byText(value)).click();
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
        open("https://demoqa.com/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setCalendarDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        successfulRegistrationPage.shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(key + " " + value));
        return this;
    }
}
