package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.Page.RegistrationFormPage;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormWithPageObjectTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @Feature("Форма регистрации студентов")
    @Story("Заполнение формы регистрации")
    @Owner("ChekulaevDA")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Заполнение пользователем формы регистрации")
    void fillFormTest() {
        step("Открываем  страницу с формой регистрации", () -> {
            registrationFormPage.openPage() ;
        });
        step("Заполняем поля тестовыми данными", () -> {
            registrationFormPage .setFirstName("Denis")
                    .setLastName("Chekulaev")
                    .setEmail("Chekulaev@mail.ru")
                    .setGender("Male")
                    .setNumber("1234567890")
                    .setBirthDate("05", "August", "1986")
                    .setSubjects("Economics")
                    .setHobby("Sports")
                    .uploadPicture("img/1.png")
                    .setAddress("Rostov-on-Don")
                    .setState("Uttar Pradesh")
                    .setCity("Agra")
                    .pressSubmit();
        });
        step("Проверка данных на корректность заполнения", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResults("Student Name", "Denis Chekulaev")
                    .checkResults("Student Email", "Chekulaev@mail.ru")
                    .checkResults("Gender","Male")
                    .checkResults("Mobile", "1234567890")
                    .checkResults("Date of Birth", "05 August,1986")
                    .checkResults("Subjects", "Economics")
                    .checkResults("Hobbies", "Sports")
                    .checkResults("Picture", "1.png")
                    .checkResults("Address", "Rostov-on-Don")
                    .checkResults("State and City", "Uttar Pradesh Agra") ;
        });
    }
}
