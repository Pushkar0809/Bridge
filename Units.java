package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Units {

    static ChromeDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate & Login
        driver.get("https://dev-bridge.bloomhotels.in/");
//        driver.get("https://qa-bridge.bloomrooms.in/");
        driver.findElement(By.xpath("//*[@id='login']")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123@selenium");
        By.xpath("//*[@id='formContent']/form/div/input").findElement(driver).click();
        Thread.sleep(3000);
        System.out.println("✔ DEV Login successful");
//        System.out.println("✔ QA Login successful");

        // Select property
        driver.findElement(By.xpath("//input[@placeholder='Search property by name, city']")).sendKeys("Janpath");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Property selected");

        // GO TO UNITS
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//mat-icon[text()='settings_applications']"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//mat-icon[text()='settings_applications']")).click();
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Units']]")).click();
        Thread.sleep(5000);
        System.out.println("✔ Navigated to Units page");

        driver.findElement(By.xpath("//a[text()='Add More']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("BED");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("BED UNIT");
        driver.findElement(By.xpath("//input[@name='description']")).sendKeys("FOR TEST");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@formcontrolname='status']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Create']")).click();
        Thread.sleep(3000);
        System.out.println("✔ Unit Created");


        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        driver.close();


    }
}