package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewSteps {
    @Given("the user is logged in")
    public void the_user_is_logged_in() { TestRunner.loginPage.setUpLoggedInUser(); }

    @Given("the user is on the planetarium homepage")
    public void the_user_is_on_the_planetarium_homepage() { TestRunner.loginPage.clickLogin(); }

    @Then("the user should be able to view their planets and moons")
    public void the_user_should_be_able_to_view_their_planets_and_moons() {
        try{
            TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            Assert.assertEquals(
                    String.format(
                            "Expected 'Welcome to the Home Page Batman, but got %s",
                            TestRunner.homePage.getHomePageGreeting()
                    ),
                    "Welcome to the Home Page Batman",
                    TestRunner.homePage.getHomePageGreeting());
            Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());
        } finally {
            TestRunner.homePage.logout();
        }
    }

    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() { TestRunner.loginPage.openLoginPage(); }

    @When("the user goes to the planetarium homepage")
    public void the_user_goes_to_the_planetarium_homepage() { TestRunner.homePage.tryToAccessHomePageDirectly(); }
    @Then("the user should not be able to access the planetarium homepage")
    public void the_user_should_not_be_able_to_access_the_planetarium_homepage() { Assert.assertNotEquals("Home", TestRunner.driver.getTitle()); }
}
