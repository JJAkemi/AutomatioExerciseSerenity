package com.automationexercise.stepdefinitions.checkout;

import com.automationexercise.questions.CheckoutPage;
import com.automationexercise.tasks.cart.ProductCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidateAddress {
    @And("hace click en el botón Prooceed to checkout")
    public void proceed_checkout(){
        theActorInTheSpotlight().attemptsTo(
                ProductCart.clickCheckoutButton()
        );
    }

    @Then("debe visualizar que la direccion se encuentre registrada")
    public void validate_address(){
        theActorInTheSpotlight().should(
                seeThat("Recuadro de datos de Dirección de Residencia se visualiza", CheckoutPage.isAddressBoxVisible(),equalTo(true)),
                seeThat("Recuadro de datos de Dirección de Facturación se visualiza", CheckoutPage.isInvoiceBoxVisible(),equalTo(true))
        );
    }
}
