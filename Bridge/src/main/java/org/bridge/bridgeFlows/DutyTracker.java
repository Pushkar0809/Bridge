package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DutyTracker {

    static WebDriverWait wait;

        public static void dutytracker(ChromeDriver driver) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//img[@alt='Duty Tracker']"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//img[@alt='Duty Tracker']")).click();
        System.out.println("✔ DutyTracker page open");
        Thread.sleep(5000);
        By.xpath("//button[text()='Reset']").findElement(driver).click();
        System.out.println("✔ Duty Tracker is RESET");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[contains(@class,'mdc-checkbox__native-control')]")).click();
        System.out.println("✔ Task show in duty tracker");
        Thread.sleep(5000);

        System.out.println("✔ Duty Tracker Done");

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");

        System.out.println("✔ Browser closed — Duty Tracker and User Access script completed");


    }
}