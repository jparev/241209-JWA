package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AddSteps {
    @When("the user clicks the planet creation link")
    public void the_user_clicks_the_planet_creation_link() { TestRunner.homePage.chooseType("planet"); }

    @When("the user provides planet name {string}")
    public void the_user_provides_planet_name(String planetName) {TestRunner.homePage.enterPlanetName(planetName); }

    @When("the user provides planet image {string}")
    public void the_user_provides_planet_image(String planetImage) { TestRunner.homePage.addPlanetImage(planetImage); }

    @When("the user clicks on submit")
    public void the_user_clicks_on_submit() { TestRunner.homePage.clickSubmit(); }

    @Then("the homepage should be updated")
    public void the_homepage_should_be_updated() { Assert.assertEquals(5, TestRunner.homePage.getAddNumberOfCelestialRows());}

    @When("the user clicks the moon creation link")
    public void the_user_clicks_the_moon_creation_link() { TestRunner.homePage.chooseType("moon"); }

    @When("the user provides moon name {string}")
    public void the_user_provides_moon_name(String moonName) { TestRunner.homePage.enterMoonName(moonName);  }

    @When("the user provides moon image {string}")
    public void the_user_provides_moon_image(String moonImage) { TestRunner.homePage.addMoonImage(moonImage); }

    @When("the user provides a planet {string} owning the moon")
    public void the_user_provides_a_planet_owning_the_moon(String planetId) { TestRunner.homePage.enterOrbitedPlanetId(planetId); }

}
