package com.vytrack.tests.US3;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assigment005 {
    @BeforeClass
    public void setUp() {

        Driver.getDriver().get("https://qa3.vytrack.com/user/login");
        WebElement userNameBox = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        userNameBox.sendKeys("user33");
        WebElement passwordBox = Driver.getDriver().findElement(By.cssSelector("input[id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");
        WebElement logInButton = Driver.getDriver().findElement(By.xpath("//*[.='Log in']"));
        logInButton.click();

        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1']"));
        fleetButton.click();

        WebElement vehicleOption = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"));
        vehicleOption.click();
    }


    @Test
    public void tc001_Export_Grid_Dropdown() {

        WebElement exportGridButton = Driver.getDriver().findElement(By.linkText("Export Grid"));
        exportGridButton.click();

        WebElement csvXlsxOption = Driver.getDriver().findElement(By.xpath("(//ul[@class='dropdown-menu'])[3]"));

        Assert.assertTrue(csvXlsxOption.isDisplayed(), "csvXlsxOption is not displayed. FAIL!!!");

    }


    @Test
    public void tc002_Dropdown_Is_On_Left() {

        BrowserUtils.sleep(2);
        WebElement exportGrit = Driver.getDriver().findElement(By.xpath("//a[@title='With this button you will export the content of the grid as it appears to you, with filters and sorting applied. All pages will be exported.']/../../../../preceding-sibling::div"));

        String export = exportGrit.getAttribute("class");

        if(export.contains("left")){
            System.out.println("Export Grid dropdown is on the left of the page");
        }
        else{
            System.out.println("Export Grid dropdown is not on the left of the page");
        }

    }

    @Test
    public void tc003_Refresh() {
        ////WebElement refreshButton = Driver.getDriver().findElement(By.xpath("//a[@title='Refresh']"));
        ////refreshButton.click();
        ////Assert.assertTrue(refreshButton.isEnabled());
        WebElement refreshButton = Driver.getDriver().findElement(By.cssSelector("i.fa-repeat"));
        Assert.assertTrue(refreshButton.isEnabled());
        refreshButton.click();
    }

    @Test
    public void tc004_Reset() {
        WebElement resetButton = Driver.getDriver().findElement(By.xpath("//a[@title='Reset']"));
        resetButton.click();
        Assert.assertTrue(resetButton.isEnabled());
    }

    @Test
    public void tc005_Grid_Settings() {
        WebElement gridSettingsButton = Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']"));
        gridSettingsButton.click();
        WebElement gridSettingsDropDownMenu = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown-menu']"));
        Assert.assertTrue(gridSettingsDropDownMenu.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
