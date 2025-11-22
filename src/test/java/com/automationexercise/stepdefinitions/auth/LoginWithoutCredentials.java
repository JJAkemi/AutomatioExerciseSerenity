package com.automationexercise.stepdefinitions.auth;

import com.automationexercise.questions.LoginPage;
import com.automationexercise.tasks.login.NavegateToHomePage;
import com.automationexercise.tasks.login.OpenPage;
import io.cucumber.java.en.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LoginWithoutCredentials {
    @Given("que el usuario abre la página automationexercise.com")
    public void openPage() {
        theActorCalled("User").attemptsTo(
                OpenPage.AutomationExercise()
        );
    }

    @When("hace click en la opción Signup Login")
    public void clickSignUpLogin() {
        theActorInTheSpotlight().attemptsTo(
                NavegateToHomePage.clickingSignUpLoginMenu()
        );
    }

    @And("en el formulario de Inicio de Sesion hace click en el boton Login sin introducir credenciales")
    public void signUpLoginPage() {
        theActorInTheSpotlight().attemptsTo(
                NavegateToHomePage.clickLoginButton()
        );
    }

    @Then("los campos Email y Password deben ser marcados como obligatorios")
    public void emailRequired() {
        theActorInTheSpotlight().should(
                seeThat("Campo email es requerido", LoginPage.emailFieldIsRequired(), equalTo(true)),
                seeThat("Campo password es requerido", LoginPage.passwordFieldIsRequired(), equalTo(true))
        );
    }

    @And("no debe cambiar de URL")
    public void sameUrl() {
        theActorInTheSpotlight().should(
                seeThat(LoginPage.currentUrl(), equalTo("https://automationexercise.com/login"))
        );
    }
}


