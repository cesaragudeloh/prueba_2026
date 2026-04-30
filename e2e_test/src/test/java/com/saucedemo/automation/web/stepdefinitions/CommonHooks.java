package com.saucedemo.automation.web.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actions.Open;
import com.saucedemo.automation.web.util.AppConfig;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class CommonHooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        String baseUrl = AppConfig.baseUrl();
        OnStage.theActorCalled("standard_user")
                .attemptsTo(
                        Open.url(baseUrl)
                );
    }
}

