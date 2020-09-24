package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        //1 - Setup the driver
        WebDriverManager.chromedriver().setup();

        //2 - Create instance of the driver
        WebDriver driver = new ChromeDriver(); //THIS LINE IS OPENING ME BROWSER

        driver.manage().window().maximize();

        //3 - Use the driver instance to test selenium
        driver.get("https://www.google.com");

        System.out.println("The title of the page is: "+driver.getTitle());

        String actualTitle = driver.getTitle();
        System.out.println("The Actual title: "+actualTitle);

        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);

        System.out.println("actualURL = " + actualURL);  // actualURL.soutv + enter

        Thread.sleep(1000);

        driver.navigate().back();

        Thread.sleep(1000);

        driver.navigate().forward();  // goes back to the previous page

        Thread.sleep(1000);

        driver.navigate().refresh();   // refreshes the page

        Thread.sleep(1000);

        driver.navigate().to("https://www.youtube.com");

       // String pageSource = driver.getPageSource();
       // System.out.println("pageSource = " + pageSource);

        driver.close();






    }
}
