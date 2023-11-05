package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.RegistrationPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.impl.Cleanup.of;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();

//    @BeforeEach
//    void openPage(){
//    registrationPage.openPage();
//}

    @BeforeEach
    void  addAllureListener(){
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
}

    @BeforeAll
    static void beforeAll() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));


//        Configuration.baseUrl = "https://demoqa.com/";

    }



    @AfterEach
    void addAttachments() {
        pages.components.AttachmentsComponent.screenshotAs("Last screenshot");
        pages.components.AttachmentsComponent.pageSource();
        pages.components.AttachmentsComponent.browserConsoleLogs();
        pages.components.AttachmentsComponent.addVideo();
    }

    @AfterAll
    static void afterAll(){
        closeWindow();
    }
}

