package com.saucedemo.automation.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class CheckoutCompletePage {

    public static final Target COMPLETE_HEADER = Target.the("order confirmation header")
            .locatedBy(".complete-header");

    private CheckoutCompletePage() {
    }
}

