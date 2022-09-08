package com.demoqa.Page;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.Page.conponents.CalendarComponent;
import com.demoqa.Page.conponents.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private final static String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstnameInput = $("#firstName"),
            lastnameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitInput = $("#submit");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstnameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastnameInput.setValue(value);
        return this;

    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setNumber(String valeu) {
        numberInput.setValue(valeu);
        return this;
    }

    public RegistrationFormPage setSubjects(String valeu) {
        subjectsInput.setValue(valeu).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String valeu) {
        hobbyInput.$(byText(valeu)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String valeu) {
        pictureInput.uploadFromClasspath(valeu);
        return this;
    }

    public RegistrationFormPage setAddress(String valeu) {
        addressInput.setValue(valeu);
        return this;
    }

    public RegistrationFormPage setState(String valeu) {
        stateInput.click();
        $(byText(valeu)).click();
        return this;
    }

    public RegistrationFormPage setCity(String valeu) {
        cityInput.click();
        $(byText(valeu)).click();
        return this;
    }

    public RegistrationFormPage pressSubmit() {
        submitInput.click();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsTableComponent.checkViseble();
        return this;

    }

    public RegistrationFormPage checkResults(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}
