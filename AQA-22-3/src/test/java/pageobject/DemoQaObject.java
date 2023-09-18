package pageobject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.DELETE;

public class DemoQaObject {
    SelenideElement firstName = $("[id='firstName']" );
    SelenideElement lastName = $("[id='lastName']" );
    SelenideElement userEmail = $("[id='userEmail']" );
    SelenideElement userPhone = $("[id='userNumber']" );
    //    SelenideElement subjects = $("[id='subjectsContainer']" );
    //  SelenideElement address = $("[id='currentAddress']" );
    SelenideElement dateOfBirth = $("[id='dateOfBirthInput']" );
    SelenideElement genderMale = $("[id='gender-radio-1']" );
    SelenideElement genderFemale = $("[id='gender-radio-2']" );
    SelenideElement genderOther = $("[id='gender-radio-3']" );
    SelenideElement hobbie1 = $("[id='hobbies-checkbox-1']" );
    SelenideElement hobbie2 = $("[id='hobbies-checkbox-2']" );
    SelenideElement hobbie3 = $("[id='hobbies-checkbox-3']" );
    SelenideElement state = $("[id='state']" );
    SelenideElement submittedHeader = $("[id='example-modal-sizes-title-lg']" );
    SelenideElement submitButton = $("[id='submit']" );

    public void fillform(String firstNameValue, String lastNameValue, String emailValue,
                         String userPhoneValue, String dateOfBirthValue) {
        firstName.val(firstNameValue);
        lastName.val(lastNameValue);
        userEmail.val(emailValue);
        userPhone.val(userPhoneValue);
//        subjects.val("Subjects");
        //      address.val("USA, Miami");
        dateOfBirth.val(dateOfBirthValue);
        genderFemale.click();
        genderMale.click();
        genderOther.click();
        hobbie1.click();
        hobbie2.click();
        hobbie3.click();
        submitButton.click();
    }
    public void clearForm() {
        firstName.sendKeys(CONTROL + "A", DELETE);
        lastName.sendKeys(CONTROL + "A", DELETE);
        userEmail.sendKeys(CONTROL + "A", DELETE);
        userPhone.sendKeys(CONTROL + "A", DELETE);
        dateOfBirth.sendKeys(CONTROL + "A", DELETE);
        //address.sendKeys(CONTROL + "A", DELETE);
    }
}

