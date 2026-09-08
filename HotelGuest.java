package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HotelGuest {

    static WebDriverWait wait;

public static void hotelguest(ChromeDriver driver) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // GO TO GUEST MOVEMENT
        driver.get("https://dev-bridge.bloomhotels.in/#/guest-movement");
        Thread.sleep(5000);
        System.out.println("✔ Navigated to guest movement page");

        driver.findElement(By.xpath("//a[text()='clear']")).click();
        Thread.sleep(3000);
        System.out.println("✔ Clear Inhouse Guest Plan Report");

        By.xpath("//h4[text()='Download Inhouse guest plan report']").findElement(driver).click();
        Thread.sleep(3000);
        System.out.println("✔ Download Inhouse Guest Plan Report");

       driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
       System.out.println("✔ Move to property page");

        System.out.println("✔ Hotel Guest script completed");

    }
}