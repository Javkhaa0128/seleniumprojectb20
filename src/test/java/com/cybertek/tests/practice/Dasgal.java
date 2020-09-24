package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dasgal {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); // THIS LINE IS OPENING ME BROWSER

        driver.get("https://www.google.com");
// driver.getTitle();
        System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();

// driver.getCurrentUrl();

        String actualUrl = driver.getCurrentUrl();

             //  actualUrl.soutv - short cut

// driver.navigate().  back(), forward(), refresh(), and to(),

        Thread.sleep(2000);

// driver.navigate().to("URL");

        driver.navigate().to("https://www.facebook.com");
        driver.navigate().to("https://www.facebook.com");

// driver.getPageSource();

        String pageSource = driver.getPageSource();

        // System.out.println("pageSource = " + pageSource);

// driver.manage.window.maximiza();

        driver.manage().window().maximize();

//  driver.close();

        driver.close();

// driver.quit();

        driver.quit();

// .findElement(By.locator);

    }
}
