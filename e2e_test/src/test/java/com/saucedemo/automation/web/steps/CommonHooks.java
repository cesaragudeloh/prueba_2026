package com.saucedemo.automation.web.steps;

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
        OnStage.theActorCalled("SauceDemo user").attemptsTo(Open.url(baseUrl));

    }
}

