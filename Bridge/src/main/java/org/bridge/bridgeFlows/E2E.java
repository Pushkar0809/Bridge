package org.bridge.bridgeFlows;

import org.bridge.bridgeEnums.BridgeFlowEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class E2E {

    static ChromeDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Environment
//        driver.get("https://qa-bridge.bloomrooms.in/");
        driver.get("https://dev-bridge.bloomhotels.in/");
        System.out.println("✔ Redirected to Bridge");

        // Navigate & Login (done once)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By username = By.xpath("//input[@id='login']");
        WebElement user = wait.until(ExpectedConditions.presenceOfElementLocated(username));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        user = driver.findElement(username);
        user.sendKeys("selenium");
        driver.findElement(By.id("password")).sendKeys("123@Selenium");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        System.out.println("✔ Log in Successful");
        Thread.sleep(3000);

        // List of hotels to run the flow on
        List<String> hotelList = Arrays.asList(
               "worli" ,"WATERFRONT","Patna","janpath","Bandra"
//                "Bandra"
        );

//        BridgeFlowEnums.BridgeFlows  bridgeFlow=  BridgeFlowEnums.BridgeFlows.DUTY_TRACKER;

        // List of flows to run, IN ORDER, one after another
        List<BridgeFlowEnums.BridgeFlows> flowsToRun = Arrays.asList(
                BridgeFlowEnums.BridgeFlows.ANOMALY_REPORT,
                BridgeFlowEnums.BridgeFlows.DUTY_TRACKER,
                BridgeFlowEnums.BridgeFlows.HOTEL_GUEST,
                BridgeFlowEnums.BridgeFlows.PLACE_REPORT,
                BridgeFlowEnums.BridgeFlows.TASK_REPORT,
                BridgeFlowEnums.BridgeFlows.SUBTASK_REPORT,
                BridgeFlowEnums.BridgeFlows.DIRTY,
                BridgeFlowEnums.BridgeFlows.TOUCH_UP,
                BridgeFlowEnums.BridgeFlows.TASK,
                BridgeFlowEnums.BridgeFlows.AREAS,
                BridgeFlowEnums.BridgeFlows.UNITS,
                BridgeFlowEnums.BridgeFlows.ACESS_CONTROL,
                BridgeFlowEnums.BridgeFlows.TASK_TEMPLATES,
                BridgeFlowEnums.BridgeFlows.DELETE_TASK
        );

        for (String hotelName : hotelList) {
            System.out.println("---- Starting hotel: " + hotelName + " ----");

            try {
                selectProperty(hotelName);

                // Run every flow, one after another, for this hotel
                for (BridgeFlowEnums.BridgeFlows bridgeFlow : flowsToRun) {
                    System.out.println("  -> Starting flow: " + bridgeFlow + " for " + hotelName);

                    try {
                        runFlowWithRetry(driver, bridgeFlow);
                    } catch (Exception e) {
                        System.out.println("  ✘ Flow failed after retry: " + bridgeFlow + " for " + hotelName);
                        e.printStackTrace();
                        // continue to next flow instead of aborting the whole hotel
                    }

                    System.out.println("  -> Finished flow: " + bridgeFlow + " for " + hotelName);
                }

            } catch (Exception e) {
                System.out.println("✘ Failed to run flows for: " + hotelName);
                e.printStackTrace();
            }

            System.out.println("---- Finished hotel: " + hotelName + " ----");
        }

        driver.findElement(By.xpath("//mat-icon[contains(@class,'icon')]")).click();
        Thread.sleep(3000);
        driver.close();
    }

         // Runs a single flow, retrying once on failure.
    private static void runFlowWithRetry(ChromeDriver driver, BridgeFlowEnums.BridgeFlows bridgeFlow) throws InterruptedException {
        try {
            initializeFlow(driver, bridgeFlow);
        } catch (Exception e) {
            System.out.println("  ⚠ Error on flow " + bridgeFlow + ", retrying once...");
            initializeFlow(driver, bridgeFlow); // let this throw up if it fails again
        }
    }

    private static void selectProperty(String hotelName) throws InterruptedException {
        // If not already on the property selection screen, navigate back to it first.
        goToPropertySelection();
        driver.findElement(By.xpath("//input[@placeholder='Search property by name, city']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        driver.findElement(By.xpath("//input[@placeholder='Search property by name, city']")).sendKeys(hotelName);
        Thread.sleep(1500); // let search results populate

        driver.findElement(By.xpath("//div[@class='property-thum']")).click(); // select property
        System.out.println("✔ Property selected: " + hotelName);
        Thread.sleep(3000);
    }

    private static void goToPropertySelection() throws InterruptedException {
        // Re-hit the base URL (simplest, works if app redirects to property list post-login)
//        driver.get("https://qa-bridge.bloomrooms.in/");
        driver.get("https://dev-bridge.bloomhotels.in/");
        Thread.sleep(2000);
    }

    private static void initializeFlow(ChromeDriver driver, BridgeFlowEnums.BridgeFlows bridgeFlow) throws InterruptedException {

        if (bridgeFlow == BridgeFlowEnums.BridgeFlows.ACESS_CONTROL) {
            AcessControl.acesscontrol(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.ANOMALY_REPORT) {
            AnomalyReport.anomalyreport(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.AREAS) {
            Areas.areas(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.DIRTY) {
            Dirty.dirty(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.DUTY_TRACKER) {
            DutyTracker.dutytracker(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.HOTEL_GUEST) {
            HotelGuest.hotelguest(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.PLACE_REPORT) {
            PlaceReport.placereport(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.SUBTASK_REPORT) {
            SubTaskReport.subtaskreport(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.TASK) {
            Task.task(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.TASK_REPORT) {
            TaskReport.taskreport(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.TASK_TEMPLATES) {
            TaskTemplates.tasktemplate(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.TOUCH_UP) {
            Touchup.touchup(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.UNITS) {
            Units.units(driver);
        } else if (bridgeFlow == BridgeFlowEnums.BridgeFlows.DELETE_TASK) {
            DeleteTask.deletetask(driver);
        }
    }
}