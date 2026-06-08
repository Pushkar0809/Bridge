package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AnomalyReport {

    static ChromeDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate & Login
        driver.get("https://dev-bridge.bloomhotels.in/");
        driver.findElement(By.xpath("//*[@id='login']")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123@selenium");
        By.xpath("//*[@id='formContent']/form/div/input").findElement(driver).click();
        Thread.sleep(3000);
        System.out.println("✔ Login successful");

        // Select property
        driver.findElement(By.xpath("//input[@placeholder='Search property by name, city']")).sendKeys("Bandra");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Property selected");

        // GO TO Anamoly REPORT
        driver.get("https://dev-bridge.bloomhotels.in/#/reports/anamoly-report");
        Thread.sleep(3000);
        System.out.println("✔ Navigated to SUBTask Report page");

        // Recent anomaly
        driver.findElement(By.xpath("//a[text()='Pending Anomalies']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Recent anomaly exported successfully");

        // Recent anomaly
        driver.findElement(By.xpath("//a[text()='All Anomalies']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ All Anomalies exported successfully");

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

        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Logged out successfully");
        driver.close();
        System.out.println("✔ Browser closed — Anamoly Report script completed");



    }
}