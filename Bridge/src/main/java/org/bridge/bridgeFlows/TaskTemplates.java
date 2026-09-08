package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskTemplates {
    static WebDriverWait wait;

       public static void tasktemplate(ChromeDriver driver) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Go to place page and apply dirty filter ONCE
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//mat-icon[text()='settings_applications']"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//mat-icon[text()='settings_applications']")).click();
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Task Template']]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='btn-global' and text()='New Template']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//mat-expansion-panel-header[@id='mat-expansion-panel-header-9']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Cleaning and Servicing']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='success-lg-btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@matinput and @placeholder='Filter']")).sendKeys("Cleaning");
        Thread.sleep(5000);
        System.out.println("Task Template created");

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");

        System.out.println("Task Templates process complete");


    }
}