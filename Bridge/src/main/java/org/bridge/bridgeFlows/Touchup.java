package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class Touchup {

    static ChromeDriver driver;
    static WebDriverWait wait;

//    public static void main(String[] args) throws InterruptedException {
        public static void touchup(ChromeDriver driver) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate & Login
//        driver.findElement(By.id("login")).sendKeys("selenium");
//        driver.findElement(By.id("password")).sendKeys("123@selenium");
//        driver.findElement(By.xpath("//input[@value='Log In']")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Login successful");

        // Select property
//        driver.findElement(By.xpath("//input[contains(@class,'search__property__input')]")).sendKeys("GOA");
//        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Property selected");

        // Go to place page and apply dirty filter ONCE
        driver.get("https://dev-bridge.bloomhotels.in/#/place");
        Thread.sleep(5000);
        By.xpath("//span[text()=\"State\"]").findElement(driver).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(), 'touch-up')]")).click();
        Thread.sleep(2000);

        int roomsCleaned = 0;

        // Loop until no touch-up rooms remain
        while (true) {
            // Find all rooms currently showing touch-up state
            List<WebElement> touchupRooms = driver.findElements(
                    By.xpath("//div[@class='place-code vacant touchup-color']/span")
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
                        By.xpath("//span[@class='mat-option-text' and text()=' clean ']")
                )).click();

                // Select remark
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//mat-select[@placeholder='Select a Remark']")
                )).click();

                By.xpath("//span[contains(text(), 'Checkout')]").findElement(driver).click();
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
            // Navigate back to the filtered list after each room
            driver.get("https://dev-bridge.bloomhotels.in/#/place");
            Thread.sleep(4000);

            // Re-apply dirty filter after navigating back
            By.xpath("//span[text()=\"touch-up\"]").findElement(driver).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(), 'touch-up')]")).click();
            Thread.sleep(3000);
            // Refresh the filtered room list after each update
            driver.navigate().refresh();
            Thread.sleep(3000);

//            driver.findElement(By.xpath("")).click();
        }


        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        driver.close();
    }
}