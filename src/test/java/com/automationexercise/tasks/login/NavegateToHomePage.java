package com.automationexercise.tasks.login;

import com.automationexercise.ui.HomePageUI;
import com.automationexercise.ui.LoginPageUI;
import com.automationexercise.ui.LandingPageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegateToHomePage {
    public static Performable clickingSignUpLoginMenu() {
        return Task.where("{0} hace click en la opción del menu principal SIGNUP / LOGIN",
                WaitUntil.the(LandingPageUI.SIGNUP_LOGIN_MENU_OPTION, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(LandingPageUI.SIGNUP_LOGIN_MENU_OPTION),
                Click.on(LandingPageUI.SIGNUP_LOGIN_MENU_OPTION));
    }

    public static Performable clickLoginButton() {
        return Task.where("{0} Hace click en el botón Login",
                WaitUntil.the(LoginPageUI.LOGIN_BUTTON, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.to(LoginPageUI.LOGIN_BUTTON),
                Click.on(LoginPageUI.LOGIN_BUTTON));
    }

    public static Performable writeEmail(String email) {
        return Task.where("{0} ingresa email",
                WaitUntil.the(LoginPageUI.EMAIL_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(LoginPageUI.EMAIL_FIELD),
                Enter.theValue(email).into(LoginPageUI.EMAIL_FIELD));
    }

    public static Performable writePassword(String password) {
        return Task.where("{0} ingresa password",
                WaitUntil.the(LoginPageUI.PASSWORD_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(LoginPageUI.PASSWORD_FIELD),
                Enter.theValue(password).into(LoginPageUI.PASSWORD_FIELD));
    }

    public static Performable withAnyCredentials(String email, String password) {
        return Task.where("{0} ingresa credenciales válidas",
                writeEmail(email),
                writePassword(password),
                clickLoginButton()
        );
    }

    public static Performable withValidCredentials() {
        return Task.where("{0} ingresa credenciales válidas",
                writeEmail("test@flare.com"),
                writePassword("Test2025"),
                clickLoginButton()
        );
    }
}

