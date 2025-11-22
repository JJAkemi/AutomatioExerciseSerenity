package com.automationexercise.stepdefinitions.auth;

import com.automationexercise.questions.HomePage;
import com.automationexercise.tasks.login.NavegateToHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class LoginSuccessful {
    @And("en el formulario de Inicio de Sesion  introduce las credenciales validas")
    public void enterValidCredentials() {
        String email = "test@flare.com";
        String password = "Test2025";

        theActorInTheSpotlight().attemptsTo(
                NavegateToHomePage.withAnyCredentials(email, password)
        );
    }

    @Then("se muestra un mensaje de saludo: Logged in as")
    public void redirectMainMenu() {
        theActorInTheSpotlight().should(
                seeThat("Mensage Logged in as <usuario>",HomePage.messageLoggedInAsVisible(), is(true))
        );

    }
}
