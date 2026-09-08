package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dirty {

    static WebDriverWait wait;

    public static void dirty(ChromeDriver driver) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://dev-bridge.bloomhotels.in/#/place");
        Thread.sleep(5000);
        applyDirtyFilter(driver);

        int roomsCleaned = 0;

        while (true) {

            List<WebElement> dirtyRooms = driver.findElements(
                    By.xpath("//div[contains(@class,'place-code') and contains(@class,'vacant')]//span")
            );

            if (dirtyRooms.isEmpty()) {
                System.out.println("✅ All rooms cleaned! Total: " + roomsCleaned);
                break;
            }

            System.out.println(" " + dirtyRooms.size() + " dirty room(s) remaining. Cleaning next one...");

            try {
                dirtyRooms.get(0).click();
                Thread.sleep(2000);

                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='clean-status']//span[text()=' dirty ']")
                )).click();

                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//mat-select//span[text()='dirty']")
                )).click();

                driver.findElement(By.xpath("//span[text()=' clean ']")).click();

                driver.findElement(By.xpath(
                        "//span[normalize-space()='Select a Remark']")).click();

                driver.findElement(By.xpath("//span[contains(text(), 'Checkout')]")).click();

                driver.findElement(By.xpath("//button[@type='submit']")).click();
                Thread.sleep(2000);

                roomsCleaned++;
                System.out.println("✅ Cleaned! Total so far: " + roomsCleaned);

            } catch (Exception e) {
                System.out.println("⚠️ Failed cleaning a room: " + e.getMessage());
                try {
                    driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                    // body not interactable, safe to ignore
                }
            }


            try {
                driver.get("https://dev-bridge.bloomhotels.in/#/place");
                Thread.sleep(3000);
                applyDirtyFilter(driver);
            } catch (Exception e) {
//                System.out.println("⚠️ Failed to reapply filter, retrying next loop: " + e.getMessage());
            }
        }

        System.out.println("✔ All rooms cleaned. Moving to property page.");
        driver.findElement(By.xpath("//mat-icon[normalize-space()='location_city']"));
    }

    private static void applyDirtyFilter(ChromeDriver driver) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()=\"State\"]")
        )).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//mat-option[@role='option' and @value='DIRTY']")
        )).click();
        Thread.sleep(2000);
    }
}