package com.automationexercise.questions;

import com.automationexercise.ui.CheckoutPageUI;
import com.automationexercise.ui.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class HomePage implements Question<Boolean> {

    private static final String REGEX = "^Logged in as\\s+[A-Za-zÁ-Úá-ú0-9_.-]+$";

    public static HomePage messageLoggedInAsVisible() {
        return new HomePage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String message = HomePageUI.LOGGED_IN_AS_MESSAGE.resolveFor(actor).getText().trim();
        return message.matches(REGEX);
    }

    public static Question<String> isConfirmatioMessageVisible() {
        return actor -> HomePageUI.CONFIRMATION_ADD_TO_CART_MESSAGE.resolveFor(actor).getText().trim();
    }

    public static Question<Boolean> isContinueShoppingButtonVisible() {
        return actor -> HomePageUI.CONTINUE_SHOPPING_BUTTON.resolveFor(actor).isVisible();
    }
}


