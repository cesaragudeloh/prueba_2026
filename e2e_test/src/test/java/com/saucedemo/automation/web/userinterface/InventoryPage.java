package com.saucedemo.automation.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class InventoryPage {


    public static final Target CART_LINK = Target.the("shopping cart link")
            .locatedBy("#shopping_cart_container a");

    public static final Target ALL_ADD_TO_CARD_BUTTONS = Target.the("all add to cart buttons")
            .locatedBy("button[id*='add-to-cart']");

    private InventoryPage() {
    }
}

