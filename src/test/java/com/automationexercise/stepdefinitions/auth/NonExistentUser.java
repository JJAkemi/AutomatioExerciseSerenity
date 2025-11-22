package com.automationexercise.stepdefinitions.auth;

import com.automationexercise.tasks.login.NavegateToHomePage;
import io.cucumber.java.en.And;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class NonExistentUser {
    @And("trata de iniciar sesión credenciales de un usuario inexistente")
    public void nonexistentuser(){
        String email = "non_existent_email@flare.com";
        String wrong_password = "non_existent_password";

        theActorInTheSpotlight().attemptsTo(
                NavegateToHomePage.withAnyCredentials(email, wrong_password)
        );
    }
}
