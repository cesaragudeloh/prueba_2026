package com.saucedemo.automation.web.tasks;

import com.saucedemo.automation.web.userinterface.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.WebElement;
import com.saucedemo.automation.web.util.RandomUtils;
import java.util.List;

public class AddFirstTwoProductsToCart implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElement> allAddToCartButtons =
                InventoryPage.ALL_ADD_TO_CARD_BUTTONS
                        .resolveAllFor(actor)
                        .stream()
                        .map(element -> (WebElement) element)
                        .toList();

        List<WebElement> randomButtons =
                RandomUtils.selectRandomElements(allAddToCartButtons, 2);

        for (WebElement button : randomButtons) {
            button.click();
        }
    }

    public static Performable items() {
        return Tasks.instrumented(AddFirstTwoProductsToCart.class);
    }
}


