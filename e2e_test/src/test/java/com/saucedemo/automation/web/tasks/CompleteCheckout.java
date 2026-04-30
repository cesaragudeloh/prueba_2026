package com.saucedemo.automation.web.tasks;

import com.saucedemo.automation.web.userinterface.CartPage;
import com.saucedemo.automation.web.userinterface.CheckoutInformationPage;
import com.saucedemo.automation.web.userinterface.CheckoutOverviewPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CompleteCheckout implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public CompleteCheckout(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static Performable withDefaultData() {
        return Instrumented.instanceOf(CompleteCheckout.class).withProperties("Cesar", "Automation", "54001");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON),
                Enter.theValue(firstName).into(CheckoutInformationPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutInformationPage.LAST_NAME_FIELD),
                Enter.theValue(postalCode).into(CheckoutInformationPage.POSTAL_CODE_FIELD),
                Click.on(CheckoutInformationPage.CONTINUE_BUTTON),
                Click.on(CheckoutOverviewPage.FINISH_BUTTON)
        );
    }
}

