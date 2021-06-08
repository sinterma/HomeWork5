package tests;


        import com.codeborne.selenide.Configuration;
        import com.github.javafaker.Faker;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import pages.RegistrationPage;

public class RegistrationWithFakers {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            number = faker.number().digits(10),
            gender = "Female",
            day = "3",
            month = "January",
            year = "1991",
            subject = "Economics",
            hobby = "Sports",
            picture = "new.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";


    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.chooseGender(gender);
        registrationPage.typeNumber(number);
        registrationPage.setDate(day, month, year);
        registrationPage.typeSubject(subject);
        registrationPage.chooseHobby(hobby);
        registrationPage.uploadPicture(picture);
        registrationPage.setAreaCurrentAddress(address);
        registrationPage.selectState(state);
        registrationPage.selectCity(city);
        registrationPage.clickSubmit();

        registrationPage.checkResults (firstName,
                lastName,
                email,
                gender,
                number,
                day,
                month,
                year,
                subject,
                hobby,
                picture,
                address,
                state,
                city);


    }

}