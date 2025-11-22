package com.automationexercise.stepdefinitions.cart;

import com.automationexercise.questions.CartPage;
import com.automationexercise.tasks.cart.ProductCart;
import com.automationexercise.tasks.homepage.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class EmptyCart {
    @And("hace click en el boton Eliminar productos")
    public void delete_product() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.deleteProductAdded()
        );
    }

    @Then("el carrito muestra el mensaje que está vacío")
    public void empty_cart(List<String> expectedMessage) {
        String expected = expectedMessage.get(0);

        theActorInTheSpotlight().attemptsTo(
                ProductCart.scrollToEmtyMessage()
        );

        theActorInTheSpotlight().should(
                seeThat("Se muestra el mensaje de confirmación de carrito sin productos.", CartPage.isEmptyCartMessageVisible(), equalTo(expected)
                )
        );

        theActorInTheSpotlight().attemptsTo(
                HomePage.clickContinueShoppingIfVisible(),
                ProductCart.clearCart()
        );
    }
}
