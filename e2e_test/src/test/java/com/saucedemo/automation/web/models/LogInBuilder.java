package com.saucedemo.automation.web.models;

import com.saucedemo.automation.web.tasks.LogIn;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;


public class LogInBuilder {
    private String username;
    private String password;

    public LogInBuilder username(String username) {
        this.username = username;
        return this;
    }

    public LogInBuilder password(String password) {
        this.password = password;
        return this;
    }

    public Performable build() {
        return Instrumented.instanceOf(LogIn.class).withProperties(this.username, this.password);
    }
}

