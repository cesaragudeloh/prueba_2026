package com.saucedemo.automation.web.tasks;

import com.saucedemo.automation.web.userinterface.InventoryPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class OpenCart implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(InventoryPage.CART_LINK));
    }

    public static Performable theCart() {
        return Instrumented.instanceOf(OpenCart.class).withProperties();
    }

}


