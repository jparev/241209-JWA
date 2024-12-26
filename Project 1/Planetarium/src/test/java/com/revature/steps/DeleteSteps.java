package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class DeleteSteps {
    @When("the user clicks the planet deletion link")
    public void the_user_clicks_the_planet_deletion_link() { TestRunner.homePage.chooseType("planet"); }

    @When("the user provides planet name {string} to delete")
    public void the_user_provides_planet_name_to_delete(String planetName) { TestRunner.homePage.deleteInput(planetName);}

    @Then("the planet and its corresponding moons are deleted")
    public void the_planet_and_its_corresponding_moons_are_deleted() { }

    @When("the user click the delete button")
    public void the_user_click_the_delete_button() { TestRunner.homePage.clickDelete(); }

    @Then("the homepage would be updated")
    public void the_homepage_would_be_updated() { Assert.assertTrue(TestRunner.homePage.deletePlanetCheck()); }

    @When("the user clicks the moon deletion link")
    public void the_user_clicks_the_moon_deletion_link() { TestRunner.homePage.chooseType("moon");  }

    @When("the user provides moon name {string} to delete")
    public void the_user_provides_moon_name_to_delete(String moonName) { TestRunner.homePage.deleteInput(moonName); }

    @Then("the table would refresh")
    public void the_table_would_refresh() { Assert.assertTrue(TestRunner.homePage.deleteMoonCheck());  }


}
