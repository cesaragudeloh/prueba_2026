package com.saucedemo.automation.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public final class CheckoutInformationPage {

    public static final Target FIRST_NAME_FIELD = Target.the("first name field")
            .locatedBy("#first-name");

    public static final Target LAST_NAME_FIELD = Target.the("last name field")
            .locatedBy("#last-name");

    public static final Target POSTAL_CODE_FIELD = Target.the("postal code field")
            .locatedBy("#postal-code");

    public static final Target CONTINUE_BUTTON = Target.the("continue button")
            .locatedBy("#continue");

    private CheckoutInformationPage() {
    }
}

