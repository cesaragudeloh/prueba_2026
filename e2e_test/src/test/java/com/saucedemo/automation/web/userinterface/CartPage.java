package com.saucedemo.automation.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class CartPage {


    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .locatedBy("#checkout");

    private CartPage() {
    }
}

