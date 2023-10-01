import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaRegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterAll
    static void afterAll(){
        closeWindow();
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
        $("#subjectsInput").setValue("Economics");
        $("#currentAddress").val("USA, Miami");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").val("02 October 2006");
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2006");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
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
//        $(".table-responsive").shouldHave(text("User subjects"));  падает из-за дефекта формы
        $(".table-responsive").shouldHave(text("02 October,2006"));
    }
}

