package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Areas {

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
        driver.findElement(By.xpath("//input[@placeholder='Search property by name, city']")).sendKeys("Patna");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
        Thread.sleep(3000);
        System.out.println("✔ Property selected");

        // Go to AREAS
        driver.get("https://dev-bridge.bloomhotels.in/#/area/99991");
        Thread.sleep(3000);
        System.out.println("✔ Navigated to areas page");

        driver.findElement(By.xpath("//a[text()='Add More']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='Area Code']")).sendKeys("COnference");
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

        // Go to UNIT
        driver.get("https://dev-bridge.bloomhotels.in/#/unit/99991");
        Thread.sleep(3000);
        System.out.println("✔ Navigated to Unit page");

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