package pages;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void typeFirstName(String value) {
        $("#firstName").val(value);
    }

    public void typeLastName(String value) {

        $("#lastName").val(value);
    }

    public void typeEmail(String value) {

        $("#userEmail").val(value);
    }

    public void chooseGender(String value) {
        $(byText(value)).click();
    }
    public void typeNumber(String value) {

        $("#userNumber").val(value);
    }
    public void setDate(String day,String month,String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label='Choose Thursday, January 3rd, 1991']").click();
    }

    public void typeSubject (String value) {
        $("#subjectsInput").val(value).pressEnter();
    }
    public void chooseHobby (String value) {
        $(byText(value)).click();
    }
    public void uploadPicture (String value) {
        $("#uploadPicture").uploadFromClasspath("new.png");
    }
    public void setAreaCurrentAddress(String value) {
        $("#currentAddress").val(value);
    }
    public void selectState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }
    public void selectCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }
    public void clickSubmit() {
        $("#submit").click();
    }
    public void checkResults(String firstName,
                             String lastName,
                             String email,
                             String gender,
                             String number,
                             String day,
                             String month,
                             String year,
                             String subject,
                             String hobby,
                             String picture,
                             String address,
                             String state,
                             String city) {
        $x("//td[text()='Student Name']/following::td[1]").shouldHave(text(firstName), text(lastName));
        $x("//td[text()='Student Email']/following::td[1]").shouldHave(text(email));
        $x("//td[text()='Gender']/following::td[1]").shouldHave(text(gender));
        $x("//td[text()='Mobile']/following::td[1]").shouldHave(text(number));
        $x("//td[text()='Date of Birth']/following::td[1]").shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']/following::td[1]").shouldHave(text(subject));
        $x("//td[text()='Hobbies']/following::td[1]").shouldHave(text(hobby));
        $x("//td[text()='Picture']/following::td[1]").shouldHave(text(picture));
        $x("//td[text()='Address']/following::td[1]").shouldHave(text(address));
        $x("//td[text()='State and City']/following::td[1]").shouldHave(text(state + " " + city));
    }


}