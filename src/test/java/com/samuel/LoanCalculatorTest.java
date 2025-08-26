package com.samuel;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoanCalculatorTest {

    @Test
    public void testPageLoads() {
        // Automatically setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Set Chrome options for headless mode and unique user data dir (for CI)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());

        WebDriver driver = new ChromeDriver(options);

        // Use a local web server for CI, or switch to file:// URL for local testing
        driver.get("http://localhost:8000/index.html");

        // Basic check: page title contains expected text
        assert driver.getTitle().contains("Credit Loan Calculator");

        driver.quit();
    }
}
