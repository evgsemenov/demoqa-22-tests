package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobject.RegistrationPage;
import utils.GenerateTestData;

import java.util.Locale;

public class DemoQaRegistrationTestsWithPageObject extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    GenerateTestData generateTestData = new GenerateTestData();
    Faker faker = new Faker(new Locale("en-GB"), new RandomService());
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userPhone = faker.numerify("##########");
    String userAddress = faker.address().streetAddress();
    String userSubject = generateTestData.getRandomUserSubjects();
    String gender = generateTestData.getRandomGender();
    String hobbie = generateTestData.getRandomHobbie();
    String picture= generateTestData.getRandomPicture();

    @BeforeEach
    void openPage(){
        registrationPage.openPage();
    }

    @Test
    void successfulRegistrationTest(){
        registrationPage.fillRegistrationForm(firstName,lastName, userPhone, userEmail, userAddress, userSubject);
        registrationPage.clickGenderRadio(gender);
        registrationPage.setCalendarDate("14", "November", "1998");
        registrationPage.clickHobbiesCheckbox(hobbie);
        registrationPage.uploadPicture(picture);
        registrationPage.clickSubmitButton();
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Mobile", userPhone)
                .checkResult("Hobbies", hobbie)
                .checkResult("Gender", gender)
                .checkResult("Address", userAddress)
                .checkResult("Date of Birth", "14 November,1998")
                .checkResult("Picture", picture);
    }
}
