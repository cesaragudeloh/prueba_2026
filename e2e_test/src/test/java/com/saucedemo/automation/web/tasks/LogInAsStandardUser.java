package com.saucedemo.automation.web.tasks;

import com.saucedemo.automation.web.models.LogInBuilder;
import com.saucedemo.automation.web.userinterface.LoginPage;
import com.saucedemo.automation.web.util.AppConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;


public class LogInAsStandardUser implements Task {

    private final String username;
    private final String password;

    public LogInAsStandardUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LogInBuilder builder() {
        return new LogInBuilder();
    }

    public static Performable withDefaultCredentials() {
        return builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(AppConfig.baseUrl()),
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}




