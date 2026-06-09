package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskReport {

    static ChromeDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate & Login
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

        // GO TO TASK REPORT
        driver.get("https://dev-bridge.bloomhotels.in/#/reports/task-report");
        Thread.sleep(3000);
        System.out.println("✔ Navigated to Task Report page");

        // PENDING TASK
        driver.findElement(By.xpath("//a[text()='Pending tasks(L31)']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Pending tasks exported successfully");

        // Engineering report
        driver.findElement(By.xpath("//a[text()='Engineering report']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Engineering report tab opened (export skipped)");

        // Guest requests
        driver.findElement(By.xpath("//a[text()='Guest requests']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Guest requests exported successfully");

        // Work orders
        driver.findElement(By.xpath("//a[text()='Work orders']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Work orders exported successfully");

        // Food orders
        driver.findElement(By.xpath("//a[text()='Food orders']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Food orders exported successfully");

        // Discarded tasks
        driver.findElement(By.xpath("//a[text()='Discarded tasks']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Discarded tasks exported successfully");

        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Logged out successfully");
        driver.close();
        System.out.println("✔ Browser closed — Task Report script completed");
    }
}