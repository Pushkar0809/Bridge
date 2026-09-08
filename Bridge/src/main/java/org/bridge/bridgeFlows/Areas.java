package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Areas {

    static WebDriverWait wait;

        public static void areas(ChromeDriver driver) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Go to AREAS
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//mat-icon[text()='settings_applications']"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//mat-icon[text()='settings_applications']")).click();
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Areas']]")).click();
        Thread.sleep(5000);
        System.out.println("✔ Navigated to areas page");

        driver.findElement(By.xpath("//a[text()='Add More']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='Area Code']")).sendKeys("Conference");
        driver.findElement(By.xpath("//input[@name='Area Name']")).sendKeys("CONFERENCE");
        driver.findElement(By.xpath("//input[@name='Floor']")).sendKeys("0");
        driver.findElement(By.xpath("//input[@name='Block']")).sendKeys("A");
        driver.findElement(By.xpath("//input[@name='statechange']")).sendKeys("360");
        driver.findElement(By.xpath("//span[normalize-space()='None']")).click();
        driver.findElement(By.xpath("//span[text()=' clean ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='status']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Create']")).click();
        Thread.sleep(3000);
        System.out.println("✔ Areas Created");

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");


    }
}