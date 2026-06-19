package org.bridge.Env;

import org.bridge.bridgeEnums.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Enviroment {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String envName = System.getProperty("env", "dev");

        Environment env = Environment.fromString(envName);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(env.getUrl());

        System.out.println("Running tests on: " + env);
    }
    }