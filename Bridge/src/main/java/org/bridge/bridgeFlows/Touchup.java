//package org.bridge.bridgeFlows;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import java.time.Duration;
//import java.util.List;
//
//public class Touchup {
//
//    static ChromeDriver driver;
//
//        public static void touchup(ChromeDriver driver) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Go to place page and apply touch-up filter ONCE
//            Actions actions = new Actions(driver);
//            WebElement element = driver.findElement(By.xpath("//span[text()='Rooms & Areas']"));
//        driver.get("https://dev-bridge.bloomhotels.in/#/place");
//        Thread.sleep(5000);
//        By.xpath("//span[text()=\"State\"]").findElement(driver).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//mat-option[@value='TOUCH_UP']")).click();
//        Thread.sleep(2000);
//
//        int roomsCleaned = 0;
//
//        // Loop until no touch-up rooms remain
//        while (true) {
//            // Find all rooms currently showing touch-up state
//            List<WebElement> touchupRooms = driver.findElements(
//                    By.xpath("//div[contains(@class,'place-code') and contains(@class,'vacant')]//span")
//            );
//
//            if (touchupRooms.isEmpty()) {
//                System.out.println("✅ All rooms have been cleaned. No more touch-up rooms found.");
//                break;
//            }
//
//            System.out.println("🔄 Touch-up rooms remaining: " + touchupRooms.size());
//
//            // Always click the first available touch-up room
//            touchupRooms.get(0).click();
//            Thread.sleep(3000);
//
//            try {
//                // Click touch-up label inside the room panel
//                wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("//span[@class='Clean1' and contains(text(), 'touch-up')]")
//                )).click();
//
//                // Set actual place state to "clean"
//                wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("//mat-select[@formcontrolname='actualPlaceState']")
//                )).click();
//                Thread.sleep(1000);
//
//                wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("//span[text()=' clean ']")
//                )).click();
//
//                // Select remark
//                wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("//span[normalize-space()='Select a Remark']"))).click();
//
//                By.xpath("//span[contains(text(), 'Checkout')]").findElement(driver).click();
//                Thread.sleep(1000);
//
//                // Submit
//                wait.until(ExpectedConditions.elementToBeClickable(
//                        By.xpath("//button[@type='submit']")
//                )).click();
//                Thread.sleep(3000);
//
//                System.out.println("✅ Room marked as clean successfully.");
//
//                roomsCleaned++;
//                System.out.println("✅ Cleaned! Total so far: " + roomsCleaned);
//
//            } catch (Exception e) {
//                System.out.println("⚠️ Error processing room: " + e.getMessage());
//                // Close any open panel/modal and retry
//                try {
//                    driver.findElement(By.xpath("//button[contains(@class,'close') or @aria-label='Close']")).click();
//                } catch (Exception ignored) {}
//                Thread.sleep(2000);
//            }
//            // Navigate back to the filtered list after each room
//            driver.get("https://dev-bridge.bloomhotels.in/#/place");
//            Thread.sleep(4000);
//
//            // Re-apply dirty filter after navigating back
//            By.xpath("//div[contains(@class,'place-code') and contains(@class,'vacant')]//span").findElement(driver).click();
//            Thread.sleep(2000);
//            // Refresh the filtered room list after each update
//            driver.navigate().refresh();
//            Thread.sleep(3000);
//        }
//
//            driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
//            System.out.println("✔ Move to property page");
//
//            System.out.println("Touch_up is Completed");
//    }
//}











package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class Touchup {

    public static void touchup(ChromeDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int roomsCleaned = 0;

        // Go to place page and apply touch-up filter for the first time
        applyTouchUpFilter(driver, wait);

        // Loop until no touch-up rooms remain
        while (true) {
            // Find all rooms currently showing touch-up state
            List<WebElement> touchupRooms = driver.findElements(
                    By.xpath("//div[contains(@class,'place-code') and contains(@class,'vacant')]//span")
            );

            if (touchupRooms.isEmpty()) {
                System.out.println("✅ All rooms have been cleaned. No more touch-up rooms found.");
                break;
            }

            System.out.println("🔄 Touch-up rooms remaining: " + touchupRooms.size());

            // Always click the first available touch-up room
            touchupRooms.get(0).click();
            Thread.sleep(3000);

            try {
                // Click touch-up label inside the room panel
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class='Clean1' and contains(text(), 'touch-up')]")
                )).click();

                // Set actual place state to "clean"
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//mat-select[@formcontrolname='actualPlaceState']")
                )).click();
                Thread.sleep(1000);

                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()=' clean ']")
                )).click();

                // Select remark
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='Select a Remark']"))).click();

                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(), 'Checkout')]"))).click();
                Thread.sleep(1000);

                // Submit
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@type='submit']")
                )).click();
                Thread.sleep(3000);

                System.out.println("✅ Room marked as clean successfully.");

                roomsCleaned++;
                System.out.println("✅ Cleaned! Total so far: " + roomsCleaned);

            } catch (Exception e) {
                System.out.println("⚠️ Error processing room: " + e.getMessage());
                // Close any open panel/modal and retry
                try {
                    driver.findElement(By.xpath("//button[contains(@class,'close') or @aria-label='Close']")).click();
                } catch (Exception ignored) {}
                Thread.sleep(2000);
            }
            applyTouchUpFilter(driver, wait);
        }

        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
        System.out.println("✔ Move to property page");

        System.out.println("Touch_up is Completed. Total rooms cleaned: " + roomsCleaned);
    }
    private static void applyTouchUpFilter(ChromeDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.get("https://dev-bridge.bloomhotels.in/#/place");
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()=\"State\"]")
        )).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//mat-option[@value='TOUCH_UP']")
        )).click();
        Thread.sleep(2000);
    }
}