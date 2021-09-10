package my.com.docs;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        // заполнение полей формы
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Aleksey");
        $("#userEmail").setValue("alex@alex.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1231231231");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2005");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        //$("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/1.jpg"));
        $("#currentAddress").setValue("Qa guru street 7");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        // проверка заполнения полей формы
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Aleksey"), text("alex@alex.com"), text("28 July,2005"));
        $(".table-responsive").shouldHave(text("1231231231"), text("Math"), text("Reading"));
        $(".table-responsive").shouldHave(text("1.jpg"), text("Qa guru street 7"), text("NCR Delhi"));
        $("#closeLargeModal").click();

    }

}