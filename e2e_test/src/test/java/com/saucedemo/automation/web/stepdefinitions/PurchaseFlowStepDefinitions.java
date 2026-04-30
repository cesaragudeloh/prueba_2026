package com.saucedemo.automation.web.stepdefinitions;

import com.saucedemo.automation.web.tasks.AddFirstTwoProductsToCart;
import com.saucedemo.automation.web.tasks.CompleteCheckout;
import com.saucedemo.automation.web.tasks.LogInAsStandardUser;
import com.saucedemo.automation.web.tasks.OpenCart;
import com.saucedemo.automation.web.userinterface.CheckoutCompletePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

public class PurchaseFlowStepDefinitions {

    @Given("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LogInAsStandardUser.withDefaultCredentials()
        );
    }

    @When("the user adds two products to the cart and completes the checkout form")
    public void theUserAddsTwoProductsToTheCartAndCompletesTheCheckoutForm() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddFirstTwoProductsToCart.items(),
                OpenCart.theCart(),
                CompleteCheckout.withDefaultData()
        );
    }

    @Then("the user should see {string}")
    public void theUserShouldSee(String expectedMessage) throws InterruptedException {
        var actor = OnStage.theActorInTheSpotlight();

        String actualMessage = CheckoutCompletePage.COMPLETE_HEADER
                .resolveFor(actor)
                .getText();

        Ensure.that(actualMessage).contains(expectedMessage);
    }

}

