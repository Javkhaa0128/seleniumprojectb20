package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Bitrix {

    WebDriver driver;
    @BeforeMethod
    public void Google_Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void Bitrix_Login (){
        driver.get("https://login2.nextbasecrm.com/");
        WebElement userNameBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userNameBox.sendKeys("helpdesk21@cybertekschool.com");
        WebElement passwordBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        passwordBox.sendKeys("UserUser" + Keys.ENTER);
        WebElement messageButton = driver.findElement(By.xpath("//div[@class='feed-add-post-form-variants']/span/span"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        messageButton.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(iframe);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        WebElement contentBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        contentBox.sendKeys("Get that $120K");
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("(//button[@id='blog-submit-button-save']/../button)[1]")).click();
    }

    @Test
    public void Bitrix_link_icon(){
        driver.get("https://login2.nextbasecrm.com/");
        WebElement userNameBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userNameBox.sendKeys("helpdesk21@cybertekschool.com");
        WebElement passwordBox = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        passwordBox.sendKeys("UserUser" + Keys.ENTER);
        WebElement messageButton = driver.findElement(By.xpath("//div[@class='feed-add-post-form-variants']/span/span"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        messageButton.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(iframe);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//span[@title='Link']/i")).click();

    }

}
