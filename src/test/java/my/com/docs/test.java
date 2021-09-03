package my.com.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

class Tests {
    @BeforeAll
    static void beforeAll () {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {


        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("AlexAlex");
        $("#userEmail").setValue("alex@qaguru.com");
        $("label.custom-control-label").shouldHave(text("Male")).click();
        $("#userNumber").setValue("89112566558");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2000");
        //$(".react-datepicker__day.react-datepicker__day--014").click();
        //$(".react-datepicker.react-datepicker__month.react-datepicker__week").click();
        //$("[aria-label=\"Choose Tuesday, June 28th, 2005\"]").click();
        // $x("//*[@aria-label=\"Choose Tuesday, June 28th, 2005\"]").click();
        $x("//*[contains(@aria-label, \"June 28th, 2000\")]").click();
       // $(".react-datepicker__day--001").click(); этот код тоже выбирает число


        $(".subjects-auto-complete__input #subjectsInput").setValue("Math").pressEnter();
        $("label.custom-control-label").shouldHave(text("Music")).click();
       // $("#uploadPicture").click();
       // $("#submit").click();

    }
}
