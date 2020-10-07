package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dasgal {


/*
1.Open Chrome browser
2.Go to https://www.google.com
3.Verify title: Expected: Google
 */
    WebDriver driver;

      @BeforeMethod
              public void SetupGoogle(){
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

      }

    @Test
    public void Verify_Google() {
        driver.get("https://www.google.com");
          String actualResult = driver.getTitle();
          String expectedResult = "Google";

        Assert.assertEquals(actualResult,expectedResult);
      }

      /*
      1.Open Chrome browser
      2.Go to https://practice.cybertekschool.com
      3.Verify URL containsExpected: cybertekschool
      4.Verify title: Expected: Practice
       */
    @Test
    public void Verify_Title(){
        driver.get("http://practice.cybertekschool.com");
        String actualtURL =  driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        String expectedTitle = "Practice";

        Assert.assertTrue(actualtURL.contains("cybertekschool"));
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    /*
    TC #1: Facebook title verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Verify title: Expected: “Facebook - Log In or Sign Up”
     */
    @Test
    public void Facebook_Title_Verification (){
        driver.get("https://www.facebook.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    /*
    TC #2: Facebook incorrect login title verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Enter incorrect username
    4.Enter incorrect password
    5.Verify title changed to: Expected: “Log into Facebook | Facebook”
     */
    @Test
    public void Facebook_incorrect_Login (){
        driver.get("https://www.facebook.com");
        WebElement UserNameInput = driver.findElement(By.xpath("//input[@name='email']"));
        UserNameInput.sendKeys("aaaaaa@yahoo.com");
        WebElement PasswordInput = driver.findElement(By.xpath("//input[@name='pass']"));
        PasswordInput.sendKeys("123456" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        Assert.assertEquals(actualTitle, expectedTitle);
    }


    /*
    TC #3: Facebook header verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Verify header text is as expected: Expected: “Connect with friends and the world around you on Facebook.”
     */
    @Test
    public void Facebook_header_verification(){
        driver.get("https://www.facebook.com");
        WebElement context = driver.findElement(By.xpath("//h2[@class='_8eso']"));
        String ActualContext = context.getText();
        String ExpectedContext = "Connect with friends and the world around you on Facebook.";

        Assert.assertEquals(ActualContext, ExpectedContext);
    }

    //TC #4: Facebook header verification
    //    1.Open Chrome browser
    //    2.Go to https://www.facebook.com
    //    3.Verify “Create a page” link href value contains text: Expected: “registration_form”
    @Test
    public void Facebook_link_verification (){
        driver.get("https://www.facebook.com");
        String expectedAttribute = "registration_form";

        String actualAtrribute = driver.findElement(By.linkText("Create a Page")).getAttribute("href");

        Assert.assertTrue(actualAtrribute.contains(expectedAttribute));
    }


    //TC #1: Zero Bank title verification
    // 1.Open Chrome browser
    // 2.Go to http://zero.webappsecurity.com/login.html
    // 3.Verify titleExpected: “Zero -Log in”
    @Test
    public void Zero_Bank (){
        driver.get("http://zero.webappsecurity.com/login.html");
        String actual_Title = driver.getTitle();
        String expectedTitle = "Zero - Log in";
        Assert.assertEquals(actual_Title, expectedTitle);
    }

    //TC #2: Zero Bank link text verification
    // 1.Open Chrome browser
    // 2.Go to http://zero.webappsecurity.com/login.html
    // 3.Verify link text from top left:Expected: “Zero Bank”
    // 4.Verify link hrefattribute value contains:Expected: “index.html”
    @Test
    public void Zero_Bank_Link (){
        driver.get("http://zero.webappsecurity.com/login.html");
        String actualAtrribute = driver.findElement(By.linkText("Zero Bank")).getAttribute("href");
        String expectedAttribute = "index.html";
        Assert.assertTrue(actualAtrribute.contains(expectedAttribute));
    }


    //TC #3: Zero Bank login title verification
    // 1.Open Chrome browser
    // 2.Go to http://zero.webappsecurity.com/login.html
    // 3.Enter username: username
    // 4.Enter password: password
    // 5.Verify title changed to:Expected: “Zero –Account Summary”
    @Test
    public void Zero_Bank_Title (){
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        inputBox.sendKeys("username");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password" + Keys.ENTER);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";
        Assert.assertEquals(actualTitle, actualTitle);
    }

    //TC #4: Zero Bank login title verification
    // 1.Open Chrome browser
    // 2.Go to http://zero.webappsecurity.com/login.html
    // 3.Enter username: username
    // 4.Enter password: password
    // 5.Click to “Account Activity” link
    // 6.Verify title changed to:Expected: “Zero –Account Activity”
    // 7.Click to “Transfer Funds” link
    // 8.Verify title changed to:Expected: “Zero –Transfer Funds”
    // 9.Click to “Pay Bills” link
    // 10.Verify title changed to:Expected: “Zero -Pay Bills”
    // 11.Click to “My Money Map” link
    // 12.Verify title changed to:Expected: “Zero –My Money Map”
    // 13.Click to “Online Statements” link
    // 14.Verify title changed to:Expected: “Zero –Online Statements”
    @Test
    public void Zero_Bank_Login_Title (){
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        inputBox.sendKeys("username");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password" + Keys.ENTER);
        WebElement accountActivity = driver.findElement(By.linkText("Account Activity"));
        accountActivity.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String currentTitle = driver.getTitle();
        String currentExpectedTitle = "Zero - Account Activity";
        Assert.assertEquals(currentExpectedTitle,currentTitle);
        WebElement transferFundLink = driver.findElement(By.linkText("Transfer Funds"));
        transferFundLink.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        String secondTitle = driver.getTitle();
        String secondExpectedTitle = "Zero – Transfer Funds";
        Assert.assertEquals(secondExpectedTitle,secondTitle);

    }












}
