package com.automationexercise.questions;

import com.automationexercise.ui.CartPageUI;
import net.serenitybdd.screenplay.Question;

public class CartPage {
    public static Question<String> productName() {
        return actor -> CartPageUI.PRODUCT_NAME.resolveFor(actor).getText().trim();
    }

    public static Question<String> productPrice() {
        return actor -> CartPageUI.PRODUCT_PRICE.resolveFor(actor).getText().trim();
    }

    public static Question<String> productQuantity() {
        return actor -> CartPageUI.PRODUCT_QUANTITY.resolveFor(actor).getText().trim();
    }

    public static Question<String> isEmptyCartMessageVisible() {
        return actor -> CartPageUI.CART_IS_EMPTY_MESSAGE.resolveFor(actor).getText().trim();
    }

    public static Question<Integer> productRowsCount() {
        return actor -> CartPageUI.PRODUCT_ROWS.resolveAllFor(actor).size();
    }
}
