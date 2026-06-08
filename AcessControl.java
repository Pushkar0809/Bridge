package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcessControl {

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

        // GO TO Duty Tracker
        driver.get("https://dev-bridge.bloomhotels.in/#/user-logs");
        Thread.sleep(5000);
        By.xpath("//button[text()='Reset']").findElement(driver).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class,'mat-checkbox-inner-container')]")).click();
        Thread.sleep(5000);
        System.out.println("✔ Duty Tracker Done");

        // Go to Access Control Page
//        driver.get("https://dev-bridge.bloomhotels.in/#/accessControl");
//        Thread.sleep(5000);
//        System.out.println("✔ Access Control");

        // CREATE NEW USER
//        driver.findElement(By.xpath("//a[text()='Add New User']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("raw");
//        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("TEST");
//        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("RAW");
//        driver.findElement(By.xpath("//input[@name='phoneNo']")).sendKeys("9876543210");
//        driver.findElement(By.xpath("//mat-select[@placeholder='Department']")).click();
//        driver.findElement(By.xpath("//mat-option//span[normalize-space()='housekeeping']")).click();
//        driver.findElement(By.xpath("//mat-select[@aria-label='Level']")).click();
//        driver.findElement(By.xpath("//mat-option//span[normalize-space()='1']")).click();
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bloom@123");
//        driver.findElement(By.xpath("//input[@formcontrolname='status' and @type='checkbox']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
//        System.out.println("✔ New User Created");


        //UPDATE USER IN OTHER PROPERTY
//        driver.findElement(By.xpath("//a[text()='Add New User']")).click();
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("raw");
//        driver.findElement(By.xpath("//input[@name='firstName']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[text()='Existing User']")).click();
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bloom@12");
//        driver.findElement(By.xpath("//input[@formcontrolname='status' and @type='checkbox']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//input[@value='Update']")).click();
//        System.out.println("✔ User created in other property");

        //EDIT USER STATUS
//        driver.findElement(By.xpath("//input[@placeholder='Filter']")).sendKeys("RAW");
//        driver.findElement(By.xpath("//td[normalize-space()='TEST RAW']")).click();
//        driver.findElement(By.xpath("//input[@name='phoneNo']")).sendKeys("1234567890");
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bloom@123");
//        driver.findElement(By.xpath("//input[@formcontrolname='status' and @type='checkbox']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
//        System.out.println("✔ User details Updated");


        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Logged out successfully");
        driver.quit();
        System.out.println("✔ Browser closed — Duty Tracker and User Access script completed");

    }
}
