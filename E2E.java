package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class E2E {

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

        // Select property
        driver.findElement(By.xpath("//input[@placeholder='Search property by name, city']")).sendKeys("Janpath");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
        Thread.sleep(3000);

        // Go to Access Control Page
        driver.get("https://dev-bridge.bloomhotels.in/#/accessControl");
        Thread.sleep(5000);

        // CREATE NEW USER
//        driver.findElement(By.xpath("//a[text()='Add New User']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("raw");
//        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("TEST");
//        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("RAW");
//        driver.findElement(By.xpath("//input[@name='phoneNo']")).sendKeys("1234567890");
//        driver.findElement(By.xpath("//mat-select[@placeholder='Department']")).click();
//        driver.findElement(By.xpath("//mat-option//span[normalize-space()='housekeeping']")).click();
//        driver.findElement(By.xpath("//mat-select[@aria-label='Level']")).click();
//        driver.findElement(By.xpath("//mat-option//span[normalize-space()='1']")).click();
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bloom@123");
//        driver.findElement(By.xpath("//input[@formcontrolname='status' and @type='checkbox']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
//        Thread.sleep(5000);

        //UPDATE USER IN OTHER PROPERTY
        driver.findElement(By.xpath("//a[text()='Add New User']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("raw");
        driver.findElement(By.xpath("//input[@name='firstName']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Existing User']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bloom@12");
        driver.findElement(By.xpath("//input[@formcontrolname='status' and @type='checkbox']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Update']")).click();

        //EDIT USER STATUS
        driver.findElement(By.xpath("//input[@placeholder='Filter']")).sendKeys("RAW");
        driver.findElement(By.xpath("//td[normalize-space()='TEST RAW']")).click();
        driver.findElement(By.xpath("//input[@name='phoneNo']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bloom@123");
        driver.findElement(By.xpath("//input[@formcontrolname='status' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();

        // GO TO Duty Tracker
        driver.get("https://dev-bridge.bloomhotels.in/#/user-logs");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Reset']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class,'mat-checkbox-inner-container')]")).click();
        Thread.sleep(5000);

        // Go to place page and apply dirty filter ONCE
        driver.get("https://dev-bridge.bloomhotels.in/#/task-template/template-list");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='btn-global' and text()='New Template']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//mat-expansion-panel-header[@id='mat-expansion-panel-header-9']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Cleaning and Servicing']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='success-lg-btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@matinput and @placeholder='Filter']")).sendKeys("Cleaning");
        Thread.sleep(5000);

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
        }


        // Go to place page and apply dirty filter ONCE
        driver.get("https://dev-bridge.bloomhotels.in/#/place");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()=\"State\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(), 'dirty')]")).click();
        Thread.sleep(3000);

//        int roomsCleaned = 0;

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
        }



        // Log-out from Bridge
        driver.findElement(By.xpath("//a[.//span[normalize-space()='Logout']]")).click();
        Thread.sleep(3000);
        driver.quit();

    }
}
