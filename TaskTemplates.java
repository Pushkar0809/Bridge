package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskTemplates {
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

        // Select property
        driver.findElement(By.xpath("//input[@placeholder='Search property by name, city']")).sendKeys("patna");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
        Thread.sleep(3000);

        // Go to place page and apply dirty filter ONCE
        driver.get("https://dev-bridge.bloomhotels.in/#/task-template/template-list");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='btn-global' and text()='New Template']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//mat-expansion-panel-header[@id='mat-expansion-panel-header-9']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Cleaning and Servicing']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='success-lg-btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@matinput and @placeholder='Filter']")).sendKeys("Cleaning");
        Thread.sleep(5000);

        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Logged out successfully");
        driver.quit();
        System.out.println("Task Templates process complete");


    }
}