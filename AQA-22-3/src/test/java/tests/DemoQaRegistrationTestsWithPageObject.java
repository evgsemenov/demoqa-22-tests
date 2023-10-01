package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobject.RegistrationPage;

public class DemoQaRegistrationTestsWithPageObject {
    RegistrationPage registrationPage = new RegistrationPage();
//    String  firstName,
//            lastName,
//            userEmail,
//            userPhone,
//            userAddress,
//            userSubjects;

    @BeforeEach
    void openPage(){
        registrationPage.openPage();
    }

    @Test
    void successfulMaleRegistrationTest(){
        registrationPage.fillRegistrationForm("Johh", "Doe", "9998887766",
                "example@gmail.com", "USA, Miami", "Math");
        registrationPage.clickGenderMaleRadio();
        registrationPage.setCalendarDate("14", "November", "1998");
        registrationPage.clickMusicCheckbox();
        registrationPage.uploadPicture("screenshot_22-1.png");
        registrationPage.clickSubmitButton();
        registrationPage
//
//                .checkResult("Student Email", "example@gmail.com")
                .checkResult("Mobile", "9998887766")
                .checkResult("Hobbies", "Music")
                .checkResult("Gender", "Male")
                .checkResult("Address", "USA, Miami")
                .checkResult("Date of Birth", "14 November,1992")
                .checkResult("Picture", "screenshot_22-1.png");
    }
}
