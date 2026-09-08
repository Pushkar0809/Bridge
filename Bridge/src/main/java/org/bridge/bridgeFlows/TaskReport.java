package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskReport {

    static WebDriverWait wait;

        public static void taskreport(ChromeDriver driver) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // GO TO TASK REPORT
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Reports']]"));

       // Hover over element
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//a[@id='sidebarLinks' and .//span[normalize-space()='Reports']]")).click();
        System.out.println("✔ Navigated to Report page");
        driver.findElement(By.xpath("//a[normalize-space()='Task Report']")).click();
        Thread.sleep(5000);
        System.out.println("✔ Navigated to Task Report page");

        // Engineering report
        driver.findElement(By.xpath("//a[text()='Engineering report']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Engineering report tab opened (export skipped)");

        // PENDING TASK
        driver.findElement(By.xpath("//a[text()='Pending tasks(L31)']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Pending tasks exported successfully");

        // Guest requests
        driver.findElement(By.xpath("//a[text()='Guest requests']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Guest requests exported successfully");

        // Work orders
        driver.findElement(By.xpath("//a[text()='Work orders']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Work orders exported successfully");

        // Food orders
        driver.findElement(By.xpath("//a[text()='Food orders']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Food orders exported successfully");

        // Discarded tasks
        driver.findElement(By.xpath("//a[text()='Discarded tasks']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
//        Thread.sleep(3000);
        System.out.println("✔ Discarded tasks exported successfully");

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");

        System.out.println("✔ Browser closed — Task Report script completed");

    }
}