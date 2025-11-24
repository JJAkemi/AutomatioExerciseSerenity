package com.automationexercise.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaymentPageUI {
    public static final Target NAME_ON_CARD = Target.the("Nombre en tarjeta")
            .located(By.name("name_on_card"));

    public static final Target CARD_NUMBER = Target.the("Número de tarjeta")
            .located(By.name("card_number"));

    public static final Target CVC = Target.the("Código CVC")
            .located(By.name("cvc"));

    public static final Target EXPIRATION_MONTH = Target.the("Mes de expiración")
            .located(By.name("expiry_month"));

    public static final Target EXPIRATION_YEAR = Target.the("Año de expiración")
            .located(By.name("expiry_year"));

    public static final Target PAY_AND_CONFIRM_ORDER_BUTTON = Target.the("Botón Pay and Confirm")
            .located(By.xpath("//button[contains(text(),'Pay and Confirm Order')]"));

    public static final Target ORDER_CONFIRMED_MESSAGE = Target.the("Mensaje de exito de compra exitosa")
            .located(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]"));
}
