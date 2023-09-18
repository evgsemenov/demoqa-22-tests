package UITests;

import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobject.DemoQaObject;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {
    DemoQaObject qaObject = new DemoQaObject();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
        Configuration.pageLoadStrategy = "eager";
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
        qaObject.fillform("John", "Doe", "example@domen.com",
                "9998887766", "28 Oct 2006");
    }
}