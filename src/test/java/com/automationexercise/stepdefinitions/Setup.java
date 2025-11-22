package com.automationexercise.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class Setup {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
