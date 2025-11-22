package com.automationexercise.tasks.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenPage {
    private static final String URL = "https://automationexercise.com/";

    public static Performable AutomationExercise() {
        return Task.where("{0} abre la página automationexercise.com",
                Open.url(URL)
        );
    }
}