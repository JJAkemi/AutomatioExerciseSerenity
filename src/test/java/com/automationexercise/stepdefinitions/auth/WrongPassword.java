package com.automationexercise.stepdefinitions.auth;

import com.automationexercise.questions.LoginPage;
import com.automationexercise.tasks.login.NavegateToHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

import static com.automationexercise.utils.DataProvider.getValue;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class WrongPassword {
    @And("trata de iniciar sesión ingresando un password incorrecto")
    public void wrongPassword() {
        String email = getValue("usuarios", "EMAIL", 2);
        String wrong_password = getValue("usuarios", "CLAVE", 2);

        theActorInTheSpotlight().attemptsTo(
                NavegateToHomePage.withAnyCredentials(email, wrong_password)
        );
    }

    @Then("se muestra el mensaje de error")
    public void validateErrorMessage(List<String> expectedMessage) {
        String expected = expectedMessage.get(0);

        theActorInTheSpotlight().should(
                seeThat("Se muestra el mensaje de error: Your email or password is incorrect!", LoginPage.isErrorMessageVisible(), equalTo(expected)
                )
        );
    }
}