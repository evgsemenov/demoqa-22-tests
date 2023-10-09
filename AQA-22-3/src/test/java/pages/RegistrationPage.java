package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
                    genderRadio = $("#genterWrapper"),
                    hobbiesCheckbox = $("#hobbiesWrapper"),
                    state = $("#state"),
                    city = $("#city"),
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
        genderRadio.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickHobbiesCheckbox(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadButton.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setUserState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserCity(String value) {
        city.click();
        city.$(byText(value)).click();
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

    public RegistrationPage removeJsCode() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage openPage() {
        open("automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        removeJsCode();
        return this;
    }

    public RegistrationPage setCalendarDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        calendar.setDate(year, month, day);
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        successfulRegistrationPage.shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(key + " " + value));
        return this;
    }
}
