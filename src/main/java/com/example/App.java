package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) throws Exception {
        // 1) ChromeDriver executable path (installed by apt as /usr/bin/chromedriver)
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // 2) Tell ChromeDriver to use Chromium binary (snap/apt path)
        ChromeOptions options = new ChromeOptions();
        // Try this path first; if chromium is elsewhere (e.g. /snap/bin/chromium), change it
        options.setBinary("/usr/bin/chromium-browser");

        // (optional) run visible (default) — for headless automation add: options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open Sauce Demo
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            Thread.sleep(1500); // let page settle

            // login using the test credentials from the lab doc
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            Thread.sleep(2500); // wait for login to complete

            // print a short confirmation to terminal
            System.out.println("Logged in — current page title: " + driver.getTitle());

            // (optional) take any further actions, e.g., click product, etc.

        } finally {
            // close the browser
            driver.quit();
        }
    }
}
