package com.samuel;

import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanCalculatorTest {
    private static final Logger logger = LoggerFactory.getLogger(LoanCalculatorTest.class);

    @Test
    public void testPageLoads() {
        logger.info("Starting Selenium test for page load...");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://localhost:8000/index.html");

        logger.info("Page loaded, checking title...");
        assert driver.getTitle().contains("Credit Loan Calculator");
        logger.info("Test completed successfully.");

        driver.quit();
    }
}
