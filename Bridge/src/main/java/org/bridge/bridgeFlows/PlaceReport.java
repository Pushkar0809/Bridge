package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceReport {

    static ChromeDriver driver;
    static WebDriverWait wait;

public static void placereport(ChromeDriver driver) throws InterruptedException {
//        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // GO TO PLACE REPORT
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Reports']]"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Reports']]")).click();
        System.out.println("✔ Navigated to Report page");
        driver.findElement(By.xpath("//a[normalize-space()='Place Report']")).click();
        Thread.sleep(5000);
        System.out.println("✔ Navigated to Place Report page");

        // Recent observation
        driver.findElement(By.xpath("//a[text()='Recent observation']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Recent observation exported successfully");

        // Recent anomaly
        driver.findElement(By.xpath("//a[text()='Recent anomaly']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Recent anomaly exported successfully");

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");

        System.out.println("✔ Browser closed — PLACE Report script completed");


    }
}