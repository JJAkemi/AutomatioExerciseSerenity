package com.automationexercise.stepdefinitions.logout;

import com.automationexercise.questions.LoginPage;
import com.automationexercise.tasks.homepage.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class Redirect {
    @When("hace click la opción Logout")
    public void logout_action(){
        theActorInTheSpotlight().attemptsTo(
                HomePage.clickLogoutMenu()
        );
    }

    @Then("se es redirigido a la pagina de inicio")
    public void redirect(){
        String expectedURL="https://automationexercise.com/login";

        theActorInTheSpotlight().should(
                seeThat("Se es redirigido a la url de login", LoginPage.isAtLoginUrl(expectedURL),equalTo(true))
        );
    }
}
