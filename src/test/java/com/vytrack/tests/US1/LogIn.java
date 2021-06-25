package com.vytrack.tests.US1;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogIn {
    @Test
    public void login(WebDriver driver){

        BrowserUtils.sleep(1);
        WebElement userName = driver.findElement(By.xpath("//input[@id ='prependedInput']"));
        userName.sendKeys(ConfigurationReader.getProperty("userName"));

        BrowserUtils.sleep(1);
        WebElement password = driver.findElement(By.xpath("//input[@id ='prependedInput2']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        BrowserUtils.sleep(1);
        WebElement clickButton = driver.findElement(By.xpath("//button[@id = '_submit']"));
        clickButton.click();
    }
}
