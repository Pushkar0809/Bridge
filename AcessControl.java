package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        driver.findElement(By.id("login")).sendKeys("selenium");
        driver.findElement(By.id("password")).sendKeys("123@Selenium");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(3000);
        System.out.println("✔ DEV Login successful");
//        System.out.println("✔  QA Login successful");

        // Select property
        driver.findElement(By.xpath("//input[contains(@class,'search__property__input')]")).sendKeys("Janpath");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Property selected");


        // Go to Access Control Page
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//mat-icon[text()='settings_applications']"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//mat-icon[text()='settings_applications']")).click();
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Access Control']]")).click();
        System.out.println("✔ Access Control page open");

        // CREATE NEW USER
//        driver.findElement(By.xpath("//a[text()='Add New User']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Selenium");
//        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Selenium");
//        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Test");
//        driver.findElement(By.xpath("//input[@name='phoneNo']")).sendKeys("1234567890");
////        driver.findElement(By.xpath("//mat-select[@placeholder='Department']")).click();
////        driver.findElement(By.xpath("//mat-option//span[normalize-space()='housekeeping']")).click();
////        driver.findElement(By.xpath("//mat-select[@aria-label='Level']")).click();
////        driver.findElement(By.xpath("//mat-option//span[normalize-space()='1']")).click();
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123@Selenium");
//        driver.findElement(By.xpath("//input[@formcontrolname='status' and @type='checkbox']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
//        System.out.println("✔ New User Created");


        //UPDATE USER IN OTHER PROPERTY
//        driver.findElement(By.xpath("//a[text()='Add New User']")).click();
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Selenium");
//        driver.findElement(By.xpath("//input[@name='firstName']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[text()='Existing User']")).click();
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123@Selenium");
//        driver.findElement(By.xpath("//input[@formcontrolname='status' and @type='checkbox']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@value='Update']")).click();
//        Thread.sleep(3000);
        By.xpath("//input[@placeholder='Filter']").findElement(driver).sendKeys("Selenium");
        Thread.sleep(3000);
        System.out.println("✔ User created in other property");

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
