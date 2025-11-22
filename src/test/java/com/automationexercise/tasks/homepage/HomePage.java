package com.automationexercise.tasks.homepage;

import com.automationexercise.ui.HomePageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.automationexercise.questions.HomePage.isContinueShoppingButtonVisible;
import static net.serenitybdd.screenplay.Task.where;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HomePage {
    public static Performable clickContinueShopping() {
        return where("{0} hace click en el boton Continue Shopping",
                WaitUntil.the(HomePageUI.CONTINUE_SHOPPING_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.CONTINUE_SHOPPING_BUTTON),
                Click.on(HomePageUI.CONTINUE_SHOPPING_BUTTON));
    }

    public static Performable clickHomeMenu() {
        return where("{0} hace click en menu Home",
                WaitUntil.the(HomePageUI.HOME_MENU, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.HOME_MENU),
                Click.on(HomePageUI.HOME_MENU)
        );
    }

    public static Performable clickCartMenu() {
        return where("{0} hace click en menu Cart",
                WaitUntil.the(HomePageUI.CART_MENU, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.CART_MENU),
                Click.on(HomePageUI.CART_MENU)
        );
    }

    public static Performable clickLogoutMenu() {
        return where("{0} hace click en la opcion del menu Logout",
                WaitUntil.the(HomePageUI.LOGOUT_MENU, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.LOGOUT_MENU),
                Click.on(HomePageUI.LOGOUT_MENU));
    }

    public static Performable clickContinueShoppingIfVisible() {
        return where("{0} hace click en el botón 'Continue Shopping' si es visible",
                actor -> {
                    boolean isVisible = isContinueShoppingButtonVisible().answeredBy(actor);

                    if (isVisible) {
                        actor.attemptsTo(
                                Click.on(HomePageUI.CONTINUE_SHOPPING_BUTTON)
                        );
                    } else {
                        System.out.println("El botón 'Continue Shopping' no está visible.");
                    }
                }
        );
    }
}


