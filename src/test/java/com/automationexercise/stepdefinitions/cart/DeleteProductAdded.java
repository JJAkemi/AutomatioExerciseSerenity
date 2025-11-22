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

public class DeleteProductAdded {
    @When("agrega mas de un producto al carrito")
    public void addTwoproducts() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.itemBlueTop(),
                HomePage.clickContinueShopping(),
                ProductCart.itemMenTshirt(),
                ProductCart.clickViewCartLink()
        );
    }

    @And("elimina uno de los productos del carrito")
    public void delete_product_added() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.deleteFirstItem()
        );
    }

    @Then("se elimina la fila seleccionada")
        public void validateDeletion() {
        theActorInTheSpotlight().should(
                seeThat("Solo queda una fila depues de eliminar", CartPage.hasOnlyOneRow(), equalTo(true))
        );

        theActorInTheSpotlight().attemptsTo(
                HomePage.clickContinueShoppingIfVisible(),
                ProductCart.clearCart()
        );
    }
}
