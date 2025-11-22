package com.automationexercise.questions;

import com.automationexercise.ui.LoginPageUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class LoginPage {
    public static Question<Boolean> emailFieldIsRequired() {
        return actor -> LoginPageUI.EMAIL_FIELD
                .resolveFor(actor)
                .getAttribute("required") != null;
    }

    public static Question<Boolean> passwordFieldIsRequired() {
        return actor -> LoginPageUI.PASSWORD_FIELD
                .resolveFor(actor)
                .getAttribute("required") != null;
    }

    public static Question<String> currentUrl() {
        return actor -> BrowseTheWeb.as(actor)
                .getDriver()
                .getCurrentUrl();
    }

    public static Question<String> isErrorMessageVisible() {
        return actor -> LoginPageUI.WRONG_PASSWORD_ERROR.resolveFor(actor).getText().trim();
    }


    public static Question<Boolean> isAtLoginUrl(String expectedUrl) {
        return actor -> BrowseTheWeb.as(actor).getDriver().getCurrentUrl().equals(expectedUrl);
    }
}
