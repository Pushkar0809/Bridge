package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Units {
    static WebDriverWait wait;

public static void units(ChromeDriver driver) throws InterruptedException {
//        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();


        // GO TO UNITS
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//mat-icon[text()='settings_applications']"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//mat-icon[text()='settings_applications']")).click();
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Units']]")).click();
        Thread.sleep(5000);
        System.out.println("✔ Navigated to Units page");

        driver.findElement(By.xpath("//a[text()='Add More']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("BED");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("BED UNIT");
        driver.findElement(By.xpath("//input[@name='description']")).sendKeys("FOR TEST");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@formcontrolname='status']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Create']")).click();
        Thread.sleep(3000);
        System.out.println("✔ Unit Created");

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");


    }
}