package com.automationexercise.stepdefinitions.checkout;

import com.automationexercise.questions.HomePage;
import com.automationexercise.questions.PaymentPage;
import com.automationexercise.tasks.checkout.Checkout;
import com.automationexercise.tasks.payment.Payment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PlaceOrder {
    @And("ingresa un comentario en la orden")
    public void add_commet() {
        String comment = "Test";
        theActorInTheSpotlight().attemptsTo(
                Checkout.addComment(comment)
        );
    }

    @And("hace click en el botón Place Order")
    public void place_order() {
        theActorInTheSpotlight().attemptsTo(
                Checkout.clickPlaceOrder()
        );
    }

    @And("llena el formulario de datos de la tarjeta de credito")
    public void ill_form() {
        String name = "Tester";
        String cardNumer = "4242424242424242";
        String cvcNumber = "123";
        String expirationMonth = "12";
        String expirationYear = "2028";

        theActorInTheSpotlight().attemptsTo(
                Checkout.fillPaymentFormWithData(name, cardNumer, cvcNumber, expirationMonth, expirationYear)
        );
    }

    @And("hace click en el botón Pay and Confirm Order")
    public void click_pay_confirm() {
        theActorInTheSpotlight().attemptsTo(
                Payment.clickPlaceOrder()
        );
    }

    @Then("se muestra el mensaje de compra exitosa")
    public void place_order_successful(List<String> expectedMessage) {
        String expected = expectedMessage.get(0);

        theActorInTheSpotlight().should(
                seeThat("Se muestra el mensaje de compra exitosa", PaymentPage.confirmationPaymentText(), equalTo(expected)
                )
        );
    }
}
