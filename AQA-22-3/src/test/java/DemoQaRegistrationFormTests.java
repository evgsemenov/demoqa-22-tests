import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobject.DemoQaRegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DemoQaRegistrationFormTests {
    DemoQaRegistrationPage qaObject = new DemoQaRegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");

    }

//    @BeforeEach
//    void beforeEach() {
//        qaObject.clearForm();
//    }

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
        qaObject.successSubmitWindow.shouldHave(text("USA, Miami"));
        qaObject.successSubmitWindow.shouldHave(text("screenshot_22-1.png"));
//        qaObject.successSubmitWindow.shouldHave(text("User subjects"));
//        qaObject.successSubmitWindow.shouldHave(text("28 Oct 2006"));
    }

    @Test
    @Description("Тест без использования pageObject")
    void shouldSuccessFillTheFormWithoutPageObjectTest(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").val("John");
        $("#lastName").val("Doe");
        $("#userEmail").val("example@domen.org");
        $("#userNumber").val("9998887766");
        $("#subjectsInput").val("User Subjects");
        $("#currentAddress").val("USA, Miami");
        $("#dateOfBirthInput").val("28 Oct 2006");
        $("#uploadPicture").uploadFromClasspath("screenshot_22-1.png");;
        $(byText("Male")).click();
        $(byText("Female")).click();
        $(byText("Other")).click();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name John Doe"));
        $(".table-responsive").shouldHave(text("Mobile 9998887766"));
        $(".table-responsive").shouldHave(text("Hobbies Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("USA, Miami"));
        $(".table-responsive").shouldHave(text("screenshot_22-1.png"));
//        $(".table-responsive").shouldHave(text("User subjects"));
//        $(".table-responsive").shouldHave(text("28 Oct 2006"));
    }
}

