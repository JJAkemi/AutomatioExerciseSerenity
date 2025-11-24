package com.automationexercise.tasks.cart;

import com.automationexercise.questions.CartPage;
import com.automationexercise.tasks.homepage.HomePage;
import com.automationexercise.ui.CartPageUI;
import com.automationexercise.ui.HomePageUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.awaitility.Awaitility;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProductCart {
    public static Performable itemBlueTop() {
        return Task.where("{0} hace click en el boton Add to cart del producto Blue Top",
                WaitUntil.the(HomePageUI.ADD_TO_CART_PRODUCT_BLUE_TOP, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.ADD_TO_CART_PRODUCT_BLUE_TOP),
                Click.on(HomePageUI.ADD_TO_CART_PRODUCT_BLUE_TOP));
    }

    public static Performable itemMenTshirt() {
        return Task.where("{0} hace click en el boton Add to cart del producto Men Tshirt",
                WaitUntil.the(HomePageUI.ADD_TO_CART_PRODUCT_MEN_TSHIRT, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.ADD_TO_CART_PRODUCT_MEN_TSHIRT),
                Click.on(HomePageUI.ADD_TO_CART_PRODUCT_MEN_TSHIRT));
    }

    public static Performable clickViewCartLink() {
        return Task.where("{0} hace click en el link View Cart",
                WaitUntil.the(HomePageUI.CONFIRMATION_VIEW_CART_LINK, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.CONFIRMATION_VIEW_CART_LINK),
                Click.on(HomePageUI.CONFIRMATION_VIEW_CART_LINK));
    }

    public static Performable deleteProductAdded() {
        return Task.where("{0} hace click en el link View Cart",
                WaitUntil.the(CartPageUI.DELETE_PRODUCT, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(CartPageUI.DELETE_PRODUCT),
                Click.on(CartPageUI.DELETE_PRODUCT));
    }

    public static Performable scrollToEmtyMessage() {
        return Task.where("{0} hace click en el link View Cart",
                WaitUntil.the(CartPageUI.CART_IS_EMPTY_MESSAGE, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(CartPageUI.CART_IS_EMPTY_MESSAGE));
    }

    public static Performable deleteFirstItem() {
        return Task.where("{0} elimina el primer producto del carrito",
                WaitUntil.the(CartPageUI.DELETE_FIRST_ITEM, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(CartPageUI.DELETE_FIRST_ITEM),
                Click.on(CartPageUI.DELETE_FIRST_ITEM)
        );
    }

    public static Performable clickCheckoutButton() {
        return Task.where("{0} click en rl botón Proceed to checkout",
                WaitUntil.the(CartPageUI.PROCEED_TO_CHECKOUT_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(CartPageUI.PROCEED_TO_CHECKOUT_BUTTON),
                Click.on(CartPageUI.PROCEED_TO_CHECKOUT_BUTTON)
        );
    }

    public static Performable clearCart() {
        return Task.where("{0} limpia el carrito despues cada prueba",
                actor -> {
                    actor.attemptsTo(
                            HomePage.clickCartMenu()
                    );

                    // Obtener cuántos items hay
                    List<WebElementFacade> items = CartPageUI.DELETE_BUTTONS.resolveAllFor(actor);

                    // Si la lista no está vacía, eliminar uno por uno
                    while (!items.isEmpty()) {
                        items.get(0).click();  // Elimina el primero
                        actor.attemptsTo(WaitUntil.angularRequestsHaveFinished());
                        items = CartPageUI.DELETE_BUTTONS.resolveAllFor(actor);
                    }
                }
        );
    }

    public static Performable viewAndRememberDetails() {
        return Task.where("{0} recuerda los valores mostrados en el carrito de compras para el producto Blue Top",
                actor -> {

                    String name = actor.asksFor(CartPage.productName());
                    String price = actor.asksFor(CartPage.productPrice());
                    String quantity = actor.asksFor(CartPage.productQuantity());

                    actor.remember("cart_name", name);
                    actor.remember("cart_price", price);
                    actor.remember("cart_quantity", quantity);
                }
        );
    }


    public static Performable waitDeleteItemAction() {
        return Task.where("{0} espera que la tabla actualice la eliminación de un producto",
                actor -> {

                    Integer before = actor.recall("count_before_delete");

                    Awaitility.await()
                            .pollInterval(Duration.ofMillis(300))
                            .atMost(Duration.ofSeconds(10))
                            .until(() -> {

                                int current = CartPageUI.PRODUCT_ROWS.resolveAllFor(actor).size();
                                return current == before - 1;
                            });
                }
        );
    }
}


