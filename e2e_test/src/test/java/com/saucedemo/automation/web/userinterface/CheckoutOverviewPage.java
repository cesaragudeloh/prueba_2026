package com.saucedemo.automation.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class CheckoutOverviewPage {


    public static final Target FINISH_BUTTON = Target.the("finish button")
            .locatedBy("#finish");

    private CheckoutOverviewPage() {
    }
}

