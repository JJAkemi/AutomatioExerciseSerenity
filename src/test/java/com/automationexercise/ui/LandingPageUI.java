package com.automationexercise.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LandingPageUI {
    public static final Target SIGNUP_LOGIN_MENU_OPTION=Target.the("Opción dentro del menu con el texto 'Signup / Login' en la pagina principal")
            .located(By.xpath("//a[contains(.,'Signup / Login')]"));
}
