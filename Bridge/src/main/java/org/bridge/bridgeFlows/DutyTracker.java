package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DutyTracker {

    static ChromeDriver driver;
    static WebDriverWait wait;

//    public static void main(String[] args) throws InterruptedException {
        public static void dutytracker(ChromeDriver driver) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate & Login
//        driver.get("https://dev-bridge.bloomhotels.in/");
//        driver.findElement(By.id("login")).sendKeys("selenium");
//        driver.findElement(By.id("password")).sendKeys("123@Selenium");
//        driver.findElement(By.xpath("//input[@value='Log In']")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ DEV Login successful");
//        System.out.println("✔  QA Login successful");

        // Select property
//        driver.findElement(By.xpath("//input[contains(@class,'search__property__input')]")).sendKeys("janpath");
//        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Property selected");


        // GO TO Duty Tracker
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//img[@alt='Duty Tracker']"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//img[@alt='Duty Tracker']")).click();
//        driver.findElement(By.xpath("//a[.//span[normalize-space()='Access Control']]")).click();
        System.out.println("✔ DutyTracer page open");
        Thread.sleep(5000);
        By.xpath("//button[text()='Reset']").findElement(driver).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class,'mat-checkbox-inner-container')]")).click();
        Thread.sleep(5000);
        System.out.println("✔ Duty Tracker Done");

        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Logged out successfully");
        driver.quit();
        System.out.println("✔ Browser closed — Duty Tracker and User Access script completed");


    }
}