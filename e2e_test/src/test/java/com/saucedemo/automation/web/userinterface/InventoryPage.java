package com.saucedemo.automation.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class InventoryPage {


    public static final Target CART_LINK = Target.the("shopping cart link")
            .locatedBy("#shopping_cart_container a");

    private InventoryPage() {
    }
}

