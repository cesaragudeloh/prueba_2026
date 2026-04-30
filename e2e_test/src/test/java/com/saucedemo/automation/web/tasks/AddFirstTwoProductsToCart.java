package com.saucedemo.automation.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.saucedemo.automation.web.util.RandomUtils;
import java.util.List;

public class AddFirstTwoProductsToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> allAddToCartButtons = driver.findElements(
                By.cssSelector("button[id*='add-to-cart']")
        );

        List<WebElement> randomButtons = RandomUtils.selectRandomElements(allAddToCartButtons, 2);
        for (WebElement button : randomButtons) {
            button.click();
        }
    }

    public static Performable items() {
        return Tasks.instrumented(AddFirstTwoProductsToCart.class);
    }
}


