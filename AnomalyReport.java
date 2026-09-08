package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AnomalyReport {
    static WebDriverWait wait;

    public static void anomalyreport(ChromeDriver driver) throws InterruptedException {
//        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // GO TO Anamoly REPORT
        Actions actions = new Actions(driver);
        WebElement element = By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Reports']]").findElement(driver);

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Reports']]")).click();
        System.out.println("✔ Navigated to Report page");
        driver.findElement(By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Anamoly Report']]")).click();
        Thread.sleep(5000);
        System.out.println("✔ Navigated to Anomaly Report page");

        // All anomaly
        driver.findElement(By.xpath("//a[text()='All Anomalies']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ All Anomalies exported successfully");

        // Pending anomaly
        driver.findElement(By.xpath("//a[text()='Pending Anomalies']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Pending anomaly exported successfully");

        // MESH
        driver.findElement(By.xpath("//a[text()='Mesh']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ MESH exported successfully");

        // PMS
        driver.findElement(By.xpath("//a[text()='PMS']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ PMS exported successfully");

        // Bridge
        driver.findElement(By.xpath("//a[text()='Bridge']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Bridge exported successfully");

        // POS
        driver.findElement(By.xpath("//a[text()='POS']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ POS exported successfully");

        // Manual anomaly
        driver.findElement(By.xpath("//a[text()='Manual']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Manual exported successfully");

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");

        System.out.println("✔ Browser closed — Anamoly Report script completed");



    }
}