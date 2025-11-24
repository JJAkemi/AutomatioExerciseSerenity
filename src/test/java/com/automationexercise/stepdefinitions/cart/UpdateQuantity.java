package com.automationexercise.stepdefinitions.cart;

import com.automationexercise.questions.CartPage;
import com.automationexercise.tasks.cart.ProductCart;
import com.automationexercise.tasks.homepage.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateQuantity {
    @When("vuelve a agregar el mismo producto al carrito")
    public void add_product_again() {
        theActorInTheSpotlight().attemptsTo(
                HomePage.clickHomeMenu(),
                ProductCart.itemBlueTop(),
                ProductCart.clickViewCartLink()
        );
    }

    @And("el usuario agrega el producto 'Blue Top' al carrito")
    public void add_product_blue_top() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.itemBlueTop()
        );
    }

    @When("navega al carrito")
    public void navigate_cart() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.clickViewCartLink()
        );
    }

    @And("visualiza los detalles de la compra realizada")
    public void view_details_purchase() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.viewAndRememberDetails()
        );
    }

    @And("navega nuevamente a la página de inicio")
    public void navegate_homepage() {
        theActorInTheSpotlight().attemptsTo(
                HomePage.clickHomeMenu()
        );
    }

    @And("agrega otra vez el producto 'Blue Top' al carrito")
    public void add_product_Blue_Top() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.itemBlueTop()
        );
    }

    @Then("debería visualizar que la cantidad aumentó en una unidad")
    public void product_increased_quantity() {
        int quantityRemembered = Integer.parseInt(
                theActorInTheSpotlight().recall("cart_quantity")
        );

        String expected = String.valueOf(quantityRemembered + 1);

        theActorInTheSpotlight().should(
                seeThat("La cantidad en el carrito aumenta en 1", CartPage.productQuantity(), equalTo(expected))
        );
    }
}
