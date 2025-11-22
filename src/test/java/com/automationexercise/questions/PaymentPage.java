package com.automationexercise.questions;

import com.automationexercise.ui.CheckoutPageUI;
import com.automationexercise.ui.HomePageUI;
import com.automationexercise.ui.PaymentPageUI;
import net.serenitybdd.screenplay.Question;

public class PaymentPage {
    public static Question<String> confirmationPaymentText() {
        return actor -> PaymentPageUI.ORDER_CONFIRMED_MESSAGE.resolveFor(actor).getText().trim();
    }
}
