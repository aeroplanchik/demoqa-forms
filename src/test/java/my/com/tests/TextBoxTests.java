package my.com.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        String permanentAddress = "some street 1";

        open("https://demoqa.com/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@qaguru.com");
        $("#currentAddress").setValue("some street 1");
        $("#permanentAddress").setValue("another street 2");
        $("#submit").click();

        


        open("https://demoqa.com/automation-practice-form");
        $("#userName").setValue("Alex");
        $(by("gender", "Male"));

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@qaguru.com"));
        $("#output #currentAddress").shouldHave(text(permanentAddress));
        $("#output #permanentAddress").shouldHave(text("another street 2"));

    }
}
