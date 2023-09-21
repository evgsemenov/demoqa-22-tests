import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobject.DemoQaRegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaRegistrationFormTests {
    DemoQaRegistrationPage qaObject = new DemoQaRegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");

    }

    @BeforeEach
    void beforeEach() {
        qaObject.clearForm();
    }
    @AfterAll
    static void afterAll(){
        closeWindow();
    }

    @Test
    @Description("Успешное заполнение формы")
    void shouldSuccessFillTheFormTest() {
        qaObject.fillForm("John", "Doe", "example@domen.com", "9998887766",
                "28 Oct 2006", "User subjects", "USA, Miami");
        qaObject.successSubmitWindowHeader.shouldHave(text("Thanks for submitting the form"));
        qaObject.successSubmitWindow.shouldHave(text("Student Name John Doe"));
        qaObject.successSubmitWindow.shouldHave(text("Mobile 9998887766"));
        qaObject.successSubmitWindow.shouldHave(text("Hobbies Sports, Reading, Music"));
        qaObject.successSubmitWindow.shouldHave(text("screenshot_22-1.png"));
//        qaObject.successSubmitWindow.shouldHave(text("User subjects"));
//        qaObject.successSubmitWindow.shouldHave(text("USA, Miami"));
//        qaObject.successSubmitWindow.shouldHave(text("28 Oct 2006"));
    }
}