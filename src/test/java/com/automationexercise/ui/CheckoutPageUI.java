package com.automationexercise.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPageUI {
    public static final Target ADDRESS_DELIVERY_BOX = Target.the("Caja con datos de dirección de entrega")
            .located(By.id("address_delivery"));

    public static final Target ADDRESS_INVOICE_BOX = Target.the("Caja con datos de dirección de facturación")
            .located(By.id("address_invoice"));

    public static final Target COMMENT_FIELD = Target.the("Campo para ingresar comentario")
            .located(By.name("message"));

    public static final Target PLACE_ORDER_BUTTON = Target.the("Botón Continue Shopping")
            .located(By.xpath("//a[contains(text(),'Place Order')]"));
}


