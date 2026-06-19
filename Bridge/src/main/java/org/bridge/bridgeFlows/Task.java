package org.bridge.bridgeFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.bridge.bridgeFlows.Touchup.driver;

public class Task {
//    public static void main(String[] args) throws InterruptedException {
        public static void task(ChromeDriver driver) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        // Navigate to Bridge IN DEV
//        driver.get("https://dev-bridge.bloomhotels.in/");
        // Navigate to Bridge IN QA
//        driver.get("https://qa-bridge.bloomrooms.in/");
//        Thread.sleep(3000);
//        driver.manage().window().maximize();

        //Login
//        driver.findElement(By.id("login")).sendKeys("selenium");
//        driver.findElement(By.id("password")).sendKeys("123@selenium");
//        driver.findElement(By.xpath("//input[@value='Log In']")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ DEV Login successful");
//        System.out.println("✔ QA Login successful");

        //close opt-in popup
//        driver.findElement(By.xpath("//*[@id=\"pushengage-opt-in-1-close\"]")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id=\"pushengage-subscriber-recovery-widget-close-button\"]")).click();
//        Thread.sleep(3000);

        // Select property
//        driver.findElement(By.xpath("//input[contains(@class,'search__property__input')]")).sendKeys("Bandra");
//        driver.findElement(By.xpath("//*[@id=\"main-container\"]/app-property-list/div/div[2]/div/a/div/div[1]")).click();
//        Thread.sleep(3000);
//        System.out.println("✔ Property selected");

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

        driver.manage().window().minimize();
        driver.close();

    }
}


//package org.example;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class Task {
//
//    static WebDriver driver;
//    static WebDriverWait wait;
//
//    // ---------------------- MAIN METHOD ----------------------
//    public static void main(String[] args) {
//
//        setupBrowser();
//
//        try {
//
//            login();
//
//            selectProperty("Bandra");
//
//            navigateToTaskSection();
//
//            createTask();
//
//            processTask();
//
//        } catch (Exception e) {
//
//            System.out.println("ERROR OCCURRED : " + e.getMessage());
//
//            e.printStackTrace();
//
//        } finally {
//
//            closeBrowser();
//        }
//    }
//
//    // ---------------------- SETUP ----------------------
//    public static void setupBrowser() {
//
//        driver = new ChromeDriver();
//
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.get("https://dev-bridge.bloomhotels.in/");
//    }
//
//    // ---------------------- COMMON CLICK METHOD ----------------------
//    public static void clickElement(By locator) {
//
//        try {
//
//            WebElement element = wait.until(
//                    ExpectedConditions.elementToBeClickable(locator)
//            );
//
//            element.click();
//
//        } catch (Exception e) {
//
//            // If normal click fails -> use JavaScript click
//            WebElement element = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(locator)
//            );
//
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//
//            js.executeScript("arguments[0].click();", element);
//        }
//    }
//
//    // ---------------------- SEND KEYS METHOD ----------------------
//    public static void enterText(By locator, String text) {
//
//        WebElement element = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(locator)
//        );
//
//        element.clear();
//
//        element.sendKeys(text);
//    }
//
//    // ---------------------- LOGIN ----------------------
//    public static void login() {
//
//        enterText(By.id("login"), "selenium");
//
//        enterText(By.id("password"), "123@selenium");
//
//        clickElement(By.xpath("//*[@id='formContent']/form/div/input"));
//
//        System.out.println("Login Successful");
//    }
//
//    // ---------------------- SELECT PROPERTY ----------------------
//    public static void selectProperty(String propertyName) {
//
//        enterText(
//                By.xpath("//input[@placeholder='Search property by name, city']"),
//                propertyName
//        );
//
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-property-list/div/div[2]/div/a")
//        );
//
//        System.out.println("Property Selected");
//    }
//
//    // ---------------------- NAVIGATION ----------------------
//    public static void navigateToTaskSection() {
//
//        clickElement(By.xpath("//*[@id='menu']/label"));
//
//        clickElement(By.xpath("//*[@id='menu']/a[2]/mat-icon"));
//
//        System.out.println("Navigated to Task Section");
//    }
//
//    // ---------------------- CREATE TASK ----------------------
//    public static void createTask() {
//
//        // Select Task Type
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-task-template-v2-create/div[2]/div/div/div/a[1]")
//        );
//
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-task-template-v2-create/div[2]/div/div/div[1]/a[1]")
//        );
//
//        // Select Room
//        enterText(
//                By.xpath("//input[@placeholder='Filter']"),
//                "SK 102"
//        );
//
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-task-template-v2-create/div[2]/div/div/div/a")
//        );
//
//        // Assign Task
//        clickElement(
//                By.xpath("//div[contains(@class,'center')]//a[contains(@class,'task-v2-btn')]")
//        );
//
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-task-template-v2-create/div[2]/div/div/div[1]/a[1]/span[1]")
//        );
//
//        // Add Comment
//        enterText(
//                By.xpath("//textarea[@placeholder='Subtask item']"),
//                "Task created using Selenium"
//        );
//
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-task-template-v2-create/div[2]/div/div/div/button")
//        );
//
//        // Final Submit
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-task-template-v2-create/div[2]/div/div/div[1]/a[3]")
//        );
//
//        System.out.println("Task Created Successfully");
//    }
//
//    // ---------------------- PROCESS TASK ----------------------
//    public static void processTask() {
//
//        driver.get("https://qa-bridge.bloomhotels.in/#/task/task-list");
//
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-task-list/div/div/div/div[4]/div[1]/div/app-guest-request/div/div")
//        );
//
//        clickElement(
//                By.xpath("//*[@id='main-container']/app-task-summary/div[1]/div[6]/div[8]/a")
//        );
//
//        clickElement(
//                By.xpath("//*[@id='mat-expansion-panel-header-4']/span[1]/div/span/a/div")
//        );
//
//        System.out.println("Task Processed");
//    }
//
//    // ---------------------- CLOSE BROWSER ----------------------
//    public static void closeBrowser() {
//
//        if (driver != null) {
//
//            driver.quit();
//        }
//
//        System.out.println("Browser Closed");
//    }
//}