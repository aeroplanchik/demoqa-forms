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


    @Test
    void fillFormTest() {


        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("AlexAlex");
        $("#userEmail").setValue("alex@qaguru.com");
        $("label.custom-control-label").shouldHave(text("Male")).click();
        $("#userNumber").setValue("999999999");
        $("#dateOfBirthInput").setValue("05.05.1985").click();
      //  $("#userNumber").setValue("999999999");
      //  $("#userNumber").setValue("999999999");

    }
}
