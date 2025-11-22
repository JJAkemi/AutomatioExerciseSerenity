package com.automationexercise.tasks.checkout;

import com.automationexercise.ui.CheckoutPageUI;
import com.automationexercise.ui.PaymentPageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Checkout {
    public static Performable addComment(String comment) {
        return Task.where("{0} agrega comentario",
                WaitUntil.the(CheckoutPageUI.COMMENT_FIELD, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(CheckoutPageUI.COMMENT_FIELD),
                Enter.theValue(comment).into(CheckoutPageUI.COMMENT_FIELD));
    }

    public static Performable clickPlaceOrder() {
        return Task.where("{0} click en el botón Place Order",
                WaitUntil.the(CheckoutPageUI.PLACE_ORDER_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(CheckoutPageUI.PLACE_ORDER_BUTTON),
                Click.on(CheckoutPageUI.PLACE_ORDER_BUTTON));
    }

    public static Performable fillPaymentFormWithData(String name, String cardNumber, String cvc, String month, String year) {
        return Task.where("{0} llena el formulario de pago",
                Enter.theValue(name).into(PaymentPageUI.NAME_ON_CARD),
                Enter.theValue(cardNumber).into(PaymentPageUI.CARD_NUMBER),
                Enter.theValue(cvc).into(PaymentPageUI.CVC),
                Enter.theValue(month).into(PaymentPageUI.EXPIRATION_MONTH),
                Enter.theValue(year).into(PaymentPageUI.EXPIRATION_YEAR),
                Click.on(PaymentPageUI.PAY_BUTTON)
        );
    }
}
