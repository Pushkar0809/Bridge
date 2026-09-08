//package org.bridge.bridgeFlows;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class DeleteTask {
//
//    static WebDriverWait wait;
//
//    public static void deletetask(ChromeDriver driver)throws InterruptedException  {
//
//        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//        // Navigate to task list
//        Actions actions = new Actions(driver);
//        WebElement element = driver.findElement(By.xpath("//mat-icon[normalize-space(text())='assignment_truned_in']"));
//
//        // Wait for the multi-select checkbox/input to be present & clickable
//        WebElement multiSelectInput = wait.until(
//                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='multiple-select-input']")));
//        multiSelectInput.click();
//
//        // Wait for "Delete all tasks" link/menu item to appear after the click above
//        WebElement deleteAllLink = wait.until(
//                ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Delete all tasks']")));
//        deleteAllLink.click();
//
//        // Wait for the note textarea (likely inside a confirmation dialog) to appear
//        WebElement noteTextarea = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[contains(@class,'add-note')]")));
//        noteTextarea.click();
//        noteTextarea.sendKeys("Test");
//
//        // Wait for and click Discard
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//a[normalize-space()='Discard']"))).click();
//    }
//}





package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class DeleteTask {

    static WebDriverWait wait;


    public static void deletetask(ChromeDriver driver) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//mat-icon[normalize-space(text())='assignment_truned_in']"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//mat-icon[normalize-space(text())='assignment_truned_in']")).click();
        System.out.println("✔ Task page open");
        Thread.sleep(5000);

        // Wait for the multi-select checkbox/input to be present & clickable
//        WebElement multiSelectInput = wait.until(
//                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='multiple-select-input']")));
//        multiSelectInput.click();
        driver.findElement(By.xpath("//*[@id='multiple-select-input']")).click();
        Thread.sleep(2000);

        // Wait for "Delete all tasks" link/menu item to appear after the click above
//        WebElement deleteAllLink = wait.until(
//                ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Delete all tasks']")));
        driver.findElement(By.xpath("//a[normalize-space(text())='Delete all tasks']")).click();
        Thread.sleep(2000);

    }
}