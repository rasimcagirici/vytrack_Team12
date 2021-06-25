package com.vytrack.tests.US2;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assigment003 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement userNameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userNameBox.sendKeys("user33");
        WebElement passwordBox = driver.findElement(By.cssSelector("input[id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");
        WebElement logInButton = driver.findElement(By.xpath("//*[.='Log in']"));
        logInButton.click();

    }

    @Test
    public void tc001_Vehicle_Info() {
        WebElement fleetButton = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        //System.out.println(fleetButton.getText());
        fleetButton.click();

        WebElement vehicleOption = driver.findElement(By.xpath("//span[.='Vehicles']"));
        //System.out.println(vehicleOption.getText());
        vehicleOption.click();

        WebElement carList = driver.findElement(By.xpath("//tbody[@class='grid-body']"));
        //System.out.println(carList.getText());
        System.out.println(carList.isDisplayed());
    }

    @Test
    public void tc002_Selected_Car_Info() {
        WebElement selectedCar = driver.findElement(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate']"));
        selectedCar.click();

        WebElement generalInfoButton = driver.findElement(By.xpath("//a[.='General']"));
        generalInfoButton.click();
        WebElement generalInfoList = driver.findElement(By.xpath("//div[@class='responsive-cell responsive-cell-no-blocks']"));
        //System.out.println(generalInfoList.getText());
        System.out.println(generalInfoList.isDisplayed());

    }

    @Test
    public void tc003_Add_Event() throws InterruptedException {

        WebElement addEventButton = driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEventButton.click();
        WebElement titleField = driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]'][1]"));
        Thread.sleep(3000);
        titleField.sendKeys("Big CyberKahunas");
        WebElement saveButton = driver.findElement(By.xpath("//button[.='Save']"));
        saveButton.click();

        WebElement generalTabEvent = driver.findElement(By.xpath("//strong[.='Big CyberKahunas']"));
        //System.out.println(generalTabEvent.getText());
        System.out.println(generalTabEvent.isDisplayed());

        WebElement activityButton = driver.findElement(By.xpath("//a[.='Activity']"));
        activityButton.click();
        WebElement activityTabEvent = driver.findElement(By.xpath("//strong[.='Big CyberKahunas']"));
        System.out.println(activityTabEvent.isDisplayed());
    }

    @Test
    public void tc004_Reset_Settings() throws InterruptedException {
        WebElement activitiesButton = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span"));
        //System.out.println(activitiesButton.getText());
        activitiesButton.click();
        WebElement calendarEventsButton = driver.findElement(By.xpath("//span[.='Calendar Events']"));
        calendarEventsButton.click();

        WebElement firstInListBeforeSort = driver.findElement(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-title']"));
        String beforeSort = firstInListBeforeSort.getText();
        System.out.println(beforeSort);


        WebElement titleSortButton = driver.findElement(By.xpath("//span[@class='grid-header-cell__label']"));
        titleSortButton.click();
        Thread.sleep(1000);
        WebElement firstInListAfterSort = driver.findElement(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-title']"));
        String afterSort = firstInListAfterSort.getText();
        System.out.println(afterSort);

        if (!beforeSort.equals(afterSort)) {
            System.out.println("Sort verification PASSED");
        } else {
            System.out.println("Sort verification FAILED");
        }
        //Assert.assertFalse(beforeSort.equals(afterSort), "Sort verification FAILED");

        WebElement resetButton = driver.findElement(By.xpath("//a[@class='action btn reset-action mode-text-only']"));
        resetButton.click();
        Thread.sleep(1000);

        WebElement firstInListAfterReset = driver.findElement(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-title']"));
        String afterReset = firstInListAfterReset.getText();
        System.out.println(afterReset);

        if (!afterReset.equals(afterSort) && afterReset.equals(beforeSort)) {
            System.out.println("Reset verification PASSED");
        } else {
            System.out.println("Reset verification FAILED");
        }
        // Assert.assertTrue((!afterReset.equals(afterSort) && afterReset.equals(beforeSort)), "Reset verification FAILED");
    }


    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
