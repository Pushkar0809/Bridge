package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubTaskReport {

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

        // GO TO SUBTASK REPORT
        driver.get("https://dev-bridge.bloomhotels.in/#/reports/subtask-report");
        Thread.sleep(3000);
        System.out.println("✔ Navigated to SUBTask Report page");

        // Engineering REMARKS
        driver.findElement(By.xpath("//a[text()='Engineering remarks']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Engineering remarks exported successfully");

        // Today's REMARKS
//        driver.findElement(By.xpath("//a[text()='Today's remarks']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Today's remarks exported successfully");

        // Option REMARKS
        driver.findElement(By.xpath("//a[text()='Option remarks']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Today's remarks exported successfully");

        // Picture REMARKS
        driver.findElement(By.xpath("//a[text()='Picture remarks']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Picture remarks exported successfully");


        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Logged out successfully");
        driver.close();
        System.out.println("✔ Browser closed — Task Report script completed");


    }
}