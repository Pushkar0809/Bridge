package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HotelGuest {

    static ChromeDriver driver;
    static WebDriverWait wait;

//    public static void main(String[] args) throws InterruptedException {
public static void hotelguest(ChromeDriver driver) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate & Login
//        driver.get("https://dev-bridge.bloomhotels.in/");
//        driver.get("https://qa-bridge.bloomrooms.in/");
//        driver.findElement(By.id("login")).sendKeys("selenium");
//        driver.findElement(By.id("password")).sendKeys("123@selenium");
//        driver.findElement(By.xpath("//input[@value='Log In']")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ DEV Login successful");
//        System.out.println("✔ QA Login successful");


        // Select property
//        driver.findElement(By.xpath("//input[contains(@class,'search__property__input')]")).sendKeys("Bandra");
//        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Property selected");

        // GO TO GUEST MOVEMENT
        driver.get("https://dev-bridge.bloomhotels.in/#/guest-movement");
//        driver.get("https://QA-bridge.bloomrooms.in/#/guest-movement");
        Thread.sleep(5000);
        System.out.println("✔ Navigated to guest movement page");

        driver.findElement(By.xpath("//a[text()='clear']")).click();
        Thread.sleep(3000);
        System.out.println("Clear Inhouse Guest Plan Report");

        By.xpath("//h4[text()='Download Inhouse guest plan report']").findElement(driver).click();
        Thread.sleep(3000);
        System.out.println("Download Inhouse Guest Plan Report");



        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Logged out successfully");
        driver.quit();
        System.out.println("✔ Browser closed — Duty Tracker and User Access script completed");





    }
}