package com.automationexercise.stepdefinitions.auth;

import com.automationexercise.tasks.login.NavegateToHomePage;
import io.cucumber.java.en.And;

import static com.automationexercise.utils.DataProvider.getValue;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class NonExistentUser {
    @And("trata de iniciar sesión credenciales de un usuario inexistente")
    public void nonexistentuser(){
        String email = getValue("usuarios", "EMAIL", 3);
        String password = getValue("usuarios", "CLAVE", 3);

        theActorInTheSpotlight().attemptsTo(
                NavegateToHomePage.withAnyCredentials(email, password)
        );
    }
}
