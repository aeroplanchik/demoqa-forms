package my.com.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        // $(".react-datepicker.react-datepicker__month.react-datepicker__week").click();
        $(".react-datepicker__day--001").click();

        //================================================================================
        //$(".react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select.react-datepicker__month-select").setValue("1").click();

        $(".subjects-auto-complete__input #subjectsInput").setValue("1234567890");
       // $("label.custom-control-label").shouldHave(text("Music")).click();
       // $("#uploadPicture").click();
       // $("#submit").click();

    }
}
