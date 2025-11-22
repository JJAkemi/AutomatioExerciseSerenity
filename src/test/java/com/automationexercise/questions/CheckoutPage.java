package com.automationexercise.questions;

import com.automationexercise.ui.CheckoutPageUI;
import net.serenitybdd.screenplay.Question;

public class CheckoutPage {
    public static Question<Boolean> isAddressBoxVisible() {
        return actor -> CheckoutPageUI.ADDRESS_DELIVERY_BOX.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> isInvoiceBoxVisible() {
        return actor -> CheckoutPageUI.ADDRESS_INVOICE_BOX.resolveFor(actor).isVisible();
    }
}
