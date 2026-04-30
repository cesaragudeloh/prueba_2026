package com.saucedemo.automation.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.pages.PageObject;
public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD = Target.the("username field")
            .locatedBy("#user-name");

    public static final Target PASSWORD_FIELD = Target.the("password field")
            .locatedBy("#password");

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("#login-button");


    private LoginPage() {
    }
}

