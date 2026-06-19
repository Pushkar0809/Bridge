package org.bridge.bridgeFlows;

import org.bridge.bridgeEnums.BridgeFlowEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123@Selenium");
        driver.findElement(By.xpath("//*[@id='formContent']/form/div/input")).click();
        System.out.println("✔ Log in Successful");
        Thread.sleep(3000);

        // Select property
        driver.findElement(By.xpath("//input[@placeholder='Search property by name, city']")).sendKeys("Bandra");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
        System.out.println("✔ Property selected");
        Thread.sleep(3000);

        int retry = 0;
        BridgeFlowEnums.BridgeFlows bridgeFlow = BridgeFlowEnums.BridgeFlows.DUTY_TRACKER;

        try {

            initializeFlow(driver, bridgeFlow);

        } catch (Exception e) {
            if (retry == 0) {
                initializeFlow(driver, bridgeFlow);
            }
            System.out.println("error on the flow");
        }
        driver.close();
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
        }
    }
}