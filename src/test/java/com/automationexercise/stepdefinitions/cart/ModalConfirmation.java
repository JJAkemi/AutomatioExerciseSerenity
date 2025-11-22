package com.automationexercise.stepdefinitions.cart;

import com.automationexercise.tasks.cart.ProductCart;
import com.automationexercise.tasks.homepage.HomePage;
import com.automationexercise.tasks.login.NavegateToHomePage;
import com.automationexercise.tasks.login.OpenPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ModalConfirmation {
    @Given("que el usuario a iniciado sesión exitosamente en automationexercise.com")
    public void login_ok() {
        theActorCalled("User").attemptsTo(
                OpenPage.AutomationExercise(),
                NavegateToHomePage.clickingSignUpLoginMenu(),
                NavegateToHomePage.withValidCredentials()
        );
    }

    @When("hace click en el boton Add to cart de un producto")
    public void click_add_to_cart() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.itemBlueTop()
        );
    }

    @Then("se muestra el mensaje de confirmación")
    public void confirmation_message(List<String> expectedMessage) {
        String expected = expectedMessage.get(0);

        theActorInTheSpotlight().should(
                seeThat("Se muestra el mensaje de confirmación: Your product has been added to cart.", com.automationexercise.questions.HomePage.isConfirmatioMessageVisible(), equalTo(expected)
                )
        );

        theActorInTheSpotlight().attemptsTo(
                HomePage.clickContinueShoppingIfVisible(),
                ProductCart.clearCart()
        );
    }
}
