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
//        String permanentAddress = "some street 1";

        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Aleksey");
        $("#userEmail").setValue("alex@alex.com");
//        $("#gender-radio-3").click();
//        $(byText("Other")).click();
//        $("#gender-radio-3").parent().click();
        $("#genterWrapper").$(byText("Other")).click();
//        $$("label.custom-control-label").filter(text("Other")).get(0).click();
//        $("#genterWrapper").selectRadio("Other"); // not working
        $("#userNumber").setValue("1231231231");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2005");

        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
//        $$(".react-datepicker__day--028")
//                .filter(not(cssClass("react-datepicker__day--outside-month"))).first().click();
//        react-datepicker__day--028 react-datepicker__day--outside-month
//        react-datepicker__day--028
//        $("[aria-label=\"Choose Tuesday, June 28th, 2005\"]").click();
//        $x("//*[@aria-label=\"Choose Tuesday, June 28th, 2005\"]").click();
//        $x("//*[contains(@aria-label, \"June 28th, 2005\")]").click();

//        aria-label="Choose Tuesday, June 28th, 2005"
//        aria-label="Choose Thursday, July 28th, 2005"
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
        //$("#submit").click();


        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Aleksey"), text("alex@alex.com"), text("28 July,2005"));
        $(".table-responsive").shouldHave(text("1231231231"), text("Math"), text("Reading"));
        $(".table-responsive").shouldHave(text("1.jpg"), text("Qa guru street 7"), text("NCR Delhi"));

        //$(".table-responsive").$(byText("Student Name")).shouldHave(text("Alex Aleksey"));
        //$(".table-responsive").$(byText("Mobile")).shouldHave(text("1231231231"));
        //$(".table-responsive").$(byText("Subject")).shouldHave(text("Math"));
        // $(".table-responsive").$(byText("Hobbies")).shouldHave(text("Reading"));
        //$(".table-responsive").$(byText("Picture")).shouldHave(text("1.jpg"));
        //$(".table-responsive").$(byText("Address")).shouldHave(text("Qa guru street 7"));
        // $(".table-responsive").$(byText("State and City")).shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
        //$("#closeLargeModal").scrollIntoView(true).click();


        // $x("//td[text()='Student Name']").parent()

        //         .shouldHave(text("Alex Egorov"));
//        $x("//td[text()='Student Name'] /following-sibling::td").shouldHave(text("Alex Alekseev"));
//        $x("//td[text()='Student Email'] /following-sibling::td").shouldHave(text("alex@alex.com"));
//        $x("//td[text()='Gender'] /following-sibling::td").shouldHave(text("Male"));
//        $x("//td[text()='Date of Birth'] /following-sibling::td").shouldHave(text("28 July,2005"));
//        $x("//td[text()='Subjects'] /following-sibling::td").shouldHave(text("English, Chemistry, Arts"));
//        $x("//td[text()='Hobbies'] /following-sibling::td").shouldHave(text("Sports, Reading, Music"));
//        $x("//td[text()='Address'] /following-sibling::td").shouldHave(text("Gorkiy"));
//        $x("//td[text()='State and City'] /following-sibling::td").shouldHave(text("Haryana Panipat"));

        ;
//        $("#userName").setValue("Alex");
//        $("#userEmail").setValue("alex@qaguru.com");
//        $("input#currentAddress").setValue("some street 1");
//        $("#permanentAddress").setValue(permanentAddress);
//
//        $("#output #name").shouldHave(text("Alex"));
//        $("#output #email").shouldHave(text("alex@qaguru.com"));
//        $("#output p#currentAddress").shouldHave(text("some street 1"));
//        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }

    //  @Test
    // void emptyFillFormTest() {
    //     open("/automation-practice-form");
    //     $("#submit").click();

    //     $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    // }
}