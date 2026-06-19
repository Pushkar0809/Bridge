package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dirty {

    static ChromeDriver driver;
    static WebDriverWait wait;

//    public static void main(String[] args) throws InterruptedException {
        public static void dirty(ChromeDriver driver) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate & Login
//        driver.get("https://dev-bridge.bloomhotels.in/");
//        driver.findElement(By.id("login")).sendKeys("selenium");
//        driver.findElement(By.id("password")).sendKeys("123@selenium");
//        driver.findElement(By.xpath("//input[@value='Log In']")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Login successful");

        // Select property
//        driver.findElement(By.xpath("//input[contains(@class,'search__property__input')]")).sendKeys("Bandra");
//        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Property selected");

        // Go to place page and apply dirty filter ONCE
        driver.get("https://dev-bridge.bloomhotels.in/#/place");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()=\"State\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(), 'dirty')]")).click();
        Thread.sleep(3000);

        int roomsCleaned = 0;

        // OUTER LOOP — keeps running until no dirty rooms are found at all
        while (true) {

            // Fetch fresh list of all dirty rooms on current page
            List<WebElement> dirtyRooms = driver.findElements(
                    By.xpath("//div[@class='place-code vacant dirty-color']")
            );

            if (dirtyRooms.isEmpty()) {
                System.out.println("✅ All rooms cleaned! Total: " + roomsCleaned);
                break;
            }

            System.out.println("🔍 Found " + dirtyRooms.size() + " dirty room(s). Starting batch...");

            // INNER LOOP — iterate over each dirty room index
            for (int i = 0; i < dirtyRooms.size(); i++) {

                // Re-fetch list each time to avoid StaleElementReferenceException
                List<WebElement> currentDirtyRooms = driver.findElements(
                        By.xpath("//div[@class='place-code vacant dirty-color']")
                );

                if (i >= currentDirtyRooms.size()) {
                    System.out.println("⚠️ Room index " + i + " no longer in DOM, skipping.");
                    break;
                }

                try {
                    System.out.println("🧹 Cleaning room " + (i + 1) + " of " + dirtyRooms.size() + "...");

                    // Click the i-th dirty room
                    currentDirtyRooms.get(i).click();
                    Thread.sleep(2000);

                    // Click dirty status to open clean/dirty toggle
                    wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@class='clean-status']//span[text()=' dirty ']")
                    )).click();
                    Thread.sleep(2000);

                    // Open status dropdown (currently showing 'dirty')
                    wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//mat-select//span[text()='dirty']")
                    )).click();
                    Thread.sleep(2000);

                    // Select 'clean'
                    driver.findElement(By.xpath("//span[text()=' clean ']")).click();
                    Thread.sleep(2000);

                    // Open remark dropdown
                    driver.findElement(By.xpath(
                            "//label[contains(text(),'Select a Remark')]/ancestor::mat-form-field//mat-select"
                    )).click();
                    Thread.sleep(2000);

                    // Select 'Checkout'
                    By.xpath("//span[contains(text(), 'Checkout')]").findElement(driver).click();
                    Thread.sleep(2000);

                    // Submit
                    driver.findElement(By.xpath("//button[@type='submit']")).click();
                    Thread.sleep(3000);

                    roomsCleaned++;
                    System.out.println("✅ Cleaned! Total so far: " + roomsCleaned);

                } catch (Exception e) {
                    System.out.println("⚠️ Failed on room index " + i + ": " + e.getMessage());
                    driver.findElement(By.tagName("body"))
                            .sendKeys(org.openqa.selenium.Keys.ESCAPE);
                    Thread.sleep(2000);
                }

                // Navigate back to the filtered list after each room
                driver.get("https://dev-bridge.bloomhotels.in/#/place");
                Thread.sleep(4000);

                // Re-apply dirty filter after navigating back
                By.xpath("//span[text()=\"dirty\"]").findElement(driver).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(), 'dirty')]")).click();
                Thread.sleep(3000);

            }
            // Outer loop re-checks — if all rooms were cleaned the list will now be empty
            System.out.println("✔ All Room is cleaned");
        }


        // Log-out from Bridge
        driver.findElement(By.xpath("//mat-icon[contains(@class,'icon')]")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
