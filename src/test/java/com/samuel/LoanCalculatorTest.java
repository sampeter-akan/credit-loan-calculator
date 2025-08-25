package com.samuel;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoanCalculatorTest {

    @Test
    public void testPageLoads() {
        // Automatically setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/samue/Projects/credit-loan-calculator/index.html");

        // Basic check: page title contains expected text
        assert driver.getTitle().contains("Loan Calculator");

        driver.quit();
    }
}
