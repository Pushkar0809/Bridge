package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceReport {

    static ChromeDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate & Login
        driver.get("https://dev-bridge.bloomhotels.in/");
        driver.findElement(By.id("login")).sendKeys("selenium");
        driver.findElement(By.id("password")).sendKeys("123@selenium");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(3000);
        System.out.println("✔ Login successful");

        // Select property
        driver.findElement(By.xpath("//input[contains(@class,'search__property__input')]")).sendKeys("Bandra");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Property selected");

        // GO TO PLACE REPORT
        driver.get("https://dev-bridge.bloomhotels.in/#/reports/place-state");
        Thread.sleep(3000);
        System.out.println("✔ Navigated to SUBTask Report page");

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

        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Logged out successfully");
        driver.close();
        System.out.println("✔ Browser closed — PLACE Report script completed");


    }
}