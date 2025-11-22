package com.automationexercise.tasks.payment;

import com.automationexercise.ui.PaymentPageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Payment {
    public static Performable clickPlaceOrder() {
        return Task.where("{0} click en el botón Pay and Confirm Order",
                WaitUntil.the(PaymentPageUI.PAY_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(PaymentPageUI.PAY_BUTTON),
                Click.on(PaymentPageUI.PAY_BUTTON));
    }
}
