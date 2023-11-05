package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultComponent;
import utils.GenerateTestData;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;

public class DemoQaRegistrationTestsWithPageObject extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    GenerateTestData generateTestData = new GenerateTestData();
    CheckResultComponent checkResultComponent = new CheckResultComponent();
    Faker faker = new Faker(new Locale("en-GB"), new RandomService());

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userPhone = faker.numerify("##########");
    String userAddress = faker.address().streetAddress();
    String userSubject = generateTestData.getRandomUserSubjects();
    String gender = generateTestData.getRandomGender();
    String hobby = generateTestData.getRandomHobbie();
    String picture= generateTestData.getRandomPicture();
    String calendarDay = generateTestData.getRandomCalendarDay();
    String calendarMonth = generateTestData.getRandomMonth();
    String calendarYear = generateTestData.getRandomYear();
    String userState = generateTestData.getRandomState();
    String userCity = generateTestData.getRandomCity();

    @Test
    void successfulRegistrationTest(){
        open("https://demoqa.com/automation-practice-form");
        registrationPage.fillRegistrationForm(firstName,lastName, userPhone, userEmail, userAddress, userSubject);
        registrationPage.clickGenderRadio(gender);
        registrationPage.setCalendarDate(calendarDay, calendarMonth,calendarYear);
        registrationPage.clickHobbiesCheckbox(hobby);
        registrationPage.uploadPicture(picture);
        registrationPage.setUserState("Haryana");
        registrationPage.setUserCity("Panipat");
        registrationPage.clickSubmitButton();
        checkResultComponent.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Mobile", userPhone)
                .checkResult("Hobbies", hobby)
                .checkResult("Gender", gender)
                .checkResult("Address", userAddress)
                .checkResult("Date of Birth", calendarDay + " " +  calendarMonth  + "," + calendarYear)
                .checkResult("Picture", picture)
                .checkResult("State and City", "Haryana Panipat");
    }
}
