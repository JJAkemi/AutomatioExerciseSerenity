package com.automationexercise.stepdefinitions;

import com.automationexercise.tasks.cart.ProductCart;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class Setup {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void checkItemOnCartBeforeLogout()
    {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProductCart.checkItemsAndClear()
        );
    }
}
