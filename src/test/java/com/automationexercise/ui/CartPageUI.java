package com.automationexercise.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CartPageUI {
    public static final Target PRODUCT_NAME = Target.the("nombre del producto en el carrito")
            .locatedBy("//td[@class='cart_description']//a");

    public static final Target PRODUCT_PRICE = Target.the("precio del producto")
            .locatedBy("//td[@class='cart_price']/p");

    public static final Target PRODUCT_QUANTITY = Target.the("cantidad del producto")
            .locatedBy("//button[@class='disabled']");

    public static final Target DELETE_PRODUCT = Target.the("botón de eliminar producto del carrito")
            .locatedBy("//a[@class='cart_quantity_delete']");

    public static final Target CART_IS_EMPTY_MESSAGE = Target.the("mensaje indicativo que el carrito de compras está vacio")
            .locatedBy("//b[contains(text(),'Cart is empty!')]");

    public static final Target DELETE_FIRST_ITEM = Target.the("Elimina primer producto en el carrito")
            .locatedBy("(//a[contains(@class,'cart_quantity_delete')])[1]");

    public static Target ROWS_TABLE_PRODUCTS_ADDED = Target.the("Todas las filas en la tabla de productos agregados")
            .located(By.cssSelector("tr"));

    public static final Target PROCEED_TO_CHECKOUT_BUTTON = Target.the("botón de Proceed to checkout para finalizar la compra")
            .locatedBy("//a[contains(text(),'Proceed To Checkout')]");

    public static final Target DELETE_BUTTONS = Target.the("botones de eliminar del carrito")
            .locatedBy("//a[@class='cart_quantity_delete']");
}
