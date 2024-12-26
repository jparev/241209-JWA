package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {

    @When("the user provides login username {string}")
    public void the_user_provides_login_username(String username) { TestRunner.loginPage.enterUsername(username); }

    @When("the user provides login password {string}")
    public void the_user_provides_login_password(String password) {TestRunner.loginPage.enterPassword(password); }

    @Given("the user submits the login credentials")
    public void the_user_submits_the_login_credentials() { TestRunner.loginPage.clickLogin();}

    @Then("the user should be redirected to the planetarium homepage")
    public void the_user_should_be_redirected_to_the_planetarium_homepage() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }

    @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }
}
