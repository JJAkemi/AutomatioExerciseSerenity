package com.automationexercise.stepdefinitions;

import com.automationexercise.tasks.cart.ProductCart;
import com.automationexercise.utils.DataProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class Setup {
    @BeforeAll
    public static void setUp() throws Exception {
        // Inicializa el DataProvider con la ruta del Excel
        DataProvider.init("src/test/resources/data/datos.xlsx");
    }

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
