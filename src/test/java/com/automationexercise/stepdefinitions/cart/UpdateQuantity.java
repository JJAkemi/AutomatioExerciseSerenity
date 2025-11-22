package com.automationexercise.stepdefinitions.cart;

import com.automationexercise.tasks.cart.ProductCart;
import com.automationexercise.tasks.homepage.HomePage;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateQuantity {
    @When("vuelve a agregar el mismo producto al carrito")
    public void add_product_again(){
        theActorInTheSpotlight().attemptsTo(
                HomePage.clickHomeMenu(),
                ProductCart.itemBlueTop(),
                ProductCart.clickViewCartLink()
        );
    }
}
