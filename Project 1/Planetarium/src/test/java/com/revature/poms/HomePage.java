package com.revature.poms;

import com.revature.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "locationSelect")
    private WebElement locationSelect;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(className = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(xpath = "//table[@id='celestialTable']//tr")
    private List<WebElement> tableRows;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){ return tableRows.size() - 1; }

    public int getAddNumberOfCelestialRows(){
        int rowCount = tableRows.size();
        TestRunner.wait.until(driver -> {
            List<WebElement> rowsAfter = driver.findElements(By.tagName("tr"));
            System.out.println("rc" + rowCount);
            System.out.println(rowsAfter.size());
            return rowsAfter.size() > rowCount;
        });
        return driver.findElements(By.tagName("tr")).size() - 1;
    }

    public boolean deletePlanetCheck(){
        try {
            WebElement element = driver.findElement(By.xpath("//td[text()=\"Earth\"]"));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public boolean deleteMoonCheck(){
        try {
            WebElement element = driver.findElement(By.xpath("//td[text()=\"Luna\"]"));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }

    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void chooseType(String type){
        Select select = new Select(locationSelect);
        select.selectByValue(type);
    }

    public void enterPlanetName (String planetName) { planetNameInput.sendKeys(planetName); }

    public void addPlanetImage(String fileName) {
        if(!fileName.equals(""))
            planetImageInput.sendKeys("D:\\Projects\\Project 1\\Planetarium\\src\\test\\resources\\Celestial-Images\\" + fileName); }

    public void clickSubmit() { submitButton.click(); }

    public void enterMoonName (String moonName) { moonNameInput.sendKeys(moonName); }

    public void enterOrbitedPlanetId (String orbitedPlanetId) { orbitedPlanetInput.sendKeys(orbitedPlanetId); }

    public void addMoonImage(String fileName) {
        if(!fileName.equals(""))
            moonImageInput.sendKeys("D:\\Projects\\Project 1\\Planetarium\\src\\test\\resources\\Celestial-Images\\" + fileName);
    }

    public void deleteInput (String deleteString) { deleteInput.sendKeys(deleteString); }

    public void clickDelete(){ deleteButton.click(); }

    public void logout() { logoutButton.click(); }

}