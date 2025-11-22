package com.automationexercise.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPageUI {
      public static final Target EMAIL_FIELD = Target.the("Campo Email")
            .located(By.xpath("//input[@data-qa='login-email']"));

    public static final Target PASSWORD_FIELD = Target.the("Campo Password")
            .located(By.xpath("//input[@data-qa='login-password']"));

    public static final Target LOGIN_BUTTON = Target.the("Botón de Login")
            .located(By.xpath("//button[contains(.,'Login')]"));

    public static final Target WRONG_PASSWORD_ERROR =
            Target.the("Wrong password or email error message")
                    .located(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
}
