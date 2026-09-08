package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubTaskReport {

    static WebDriverWait wait;

        public static void subtaskreport(ChromeDriver driver) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // GO TO SUBTASK REPORT
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Reports']]"));

        // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Reports']]")).click();
        System.out.println("✔ Navigated to Report page");
        driver.findElement(By.xpath("//a[normalize-space()='Subtask Report']")).click();
        Thread.sleep(5000);
        System.out.println("✔ Navigated to SUBTask Report page");

        // Engineering REMARKS
        driver.findElement(By.xpath("//a[text()='Engineering remarks']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Engineering remarks exported successfully");

        // Today's REMARKS
        driver.findElement(By.xpath("//a[contains(normalize-space(), \"Today's remarks\")]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Today's remarks exported successfully");

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

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");

        System.out.println("✔ Browser closed — Sub_Task Report script completed");


    }
}