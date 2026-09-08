package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class Task {

        public static void task(ChromeDriver driver) throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate and perform actions
        driver.findElement(By.xpath("//*[@id=\"menu\"]/label")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='menu']/a[2]/mat-icon")).click();
        Thread.sleep(3000);

        //SELECT TASK TYPE
        By.xpath("//*[@id=\"main-container\"]/app-task-template-v2-create/div[2]/div/div/div/a[1]").findElement(driver).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='main-container']/app-task-template-v2-create/div[2]/div/div/div[1]/a[1]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Task type Selected Successfully");

        // SELECT ROOM NUMBER AND ASSIGN TO
        driver.findElement(By.xpath("//input[@placeholder='Filter']")).sendKeys("SK 102");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-task-template-v2-create/div[2]/div/div/div/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class, 'center')]//a[contains(@class, 'task-v2-btn')]")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@placeholder='Filter by name']")).sendKeys("pushkar");
//        Thread.sleep(3000);
        By.xpath("//*[@id=\"main-container\"]/app-task-template-v2-create/div[2]/div/div/div[1]/a[1]/span[1]").findElement(driver).click();
        Thread.sleep(3000);
        System.out.println("✔ Room assigned Successfully");

        //ADD COMMENT FOR THE TASK GENERATED
        driver.findElement(By.xpath("//textarea[@placeholder='Subtask item']")).sendKeys("a");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-task-template-v2-create/div[2]/div/div/div/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='main-container']/app-task-template-v2-create/div[2]/div/div/div[1]/a[3]")).click();
        Thread.sleep(5000);
        System.out.println("✔ Comment added to task");

        //TASK DOING PROCESS
        driver.get("https://qa-bridge.bloomrooms.in/#/task/task-list");
        driver.get("https://dev-bridge.bloomhotels.in/#/task/task-list");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-task-list/div/div/div/div[4]/div[1]/div/app-guest-request/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-task-summary/div[1]/div[6]/div[8]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"mat-expansion-panel-header-4\"]/span[1]/div/span/a/div")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");

        System.out.println("✔ Task completed Successfully");

    }
}
