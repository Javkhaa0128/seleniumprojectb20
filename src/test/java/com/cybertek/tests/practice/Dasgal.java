package com.cybertek.tests.practice;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.SmartBearUtilities;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Dasgal {


    /*
    1.Open Chrome browser
    2.Go to https://www.google.com
    3.Verify title: Expected: Google
     */
    WebDriver driver;

    @BeforeMethod
    public void SetupGoogle() {
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

        Assert.assertEquals(actualResult, expectedResult);
    }

    /*
    1.Open Chrome browser
    2.Go to https://practice.cybertekschool.com
    3.Verify URL containsExpected: cybertekschool
    4.Verify title: Expected: Practice
     */
    @Test
    public void Verify_Title() {
        driver.get("http://practice.cybertekschool.com");
        String actualtURL = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        String expectedTitle = "Practice";

        Assert.assertTrue(actualtURL.contains("cybertekschool"));
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    /*
    TC #1: Facebook title verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Verify title: Expected: “Facebook - Log In or Sign Up”
     */
    @Test
    public void Facebook_Title_Verification() {
        driver.get("https://www.facebook.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle, expectedTitle);
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
    public void Facebook_incorrect_Login() {
        driver.get("https://www.facebook.com");
        WebElement UserNameInput = driver.findElement(By.xpath("//input[@name='email']"));
        UserNameInput.sendKeys("aaaaaa@yahoo.com");
        WebElement PasswordInput = driver.findElement(By.xpath("//input[@name='pass']"));
        PasswordInput.sendKeys("123456" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Log into Facebook | Facebook";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Assert.assertEquals(actualTitle, expectedTitle);
    }


    /*
    TC #3: Facebook header verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Verify header text is as expected: Expected: “Connect with friends and the world around you on Facebook.”
     */
    @Test
    public void Facebook_header_verification() {
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
    public void Facebook_link_verification() {
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
    public void Zero_Bank() {
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
    public void Zero_Bank_Link() {
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
    public void Zero_Bank_Title() {
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
    public void Zero_Bank_Login_Title() {
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        inputBox.sendKeys("username");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password" + Keys.ENTER);
        WebElement accountActivity = driver.findElement(By.linkText("Account Activity"));
        accountActivity.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedTitle1 = "Zero - Account Activity";
        String currentTitle1 = driver.getTitle();
        Assert.assertEquals(expectedTitle1, currentTitle1);
        driver.findElement(By.xpath("//a[.='Transfer Funds']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualTitle2 = driver.getTitle();
        String ExpectedTitle2 = "Zero - Transfer Funds";
        Assert.assertEquals(actualTitle2, ExpectedTitle2);
        driver.findElement(By.xpath("//a[.='Pay Bills']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "Zero - Pay Bills";
        Assert.assertEquals(actualTitle3, expectedTitle3);
        driver.findElement(By.xpath("//a[.='My Money Map']")).click();
        String expectedTitle4 = "Zero - My Money Map";
        String actualTitle4 = driver.getTitle();
        Assert.assertEquals(expectedTitle4, actualTitle4);
        driver.findElement(By.xpath("//a[.='Online Statements']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualTitle5 = driver.getTitle();
        String expectedTitle5 = "Zero - Online Statements";
        Assert.assertEquals(actualTitle5, expectedTitle5);
    }

    //TC #3: PracticeCybertek/ForgotPassword URL verification
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/forgot_password
    // 3.Enter any email into input box
    // 4.Click on Retrieve password
    // 5.Verify URL contains: Expected: “email_sent”
    // 6.Verify textbox displayed the content as expected.
    // Expected: “Your e-mail’s been sent!”
    // Hint: You need to use getText method for this practice
    @Test
    public void Cybertek_ForgotPassword() {
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/input"));
        inputBox.sendKeys("popeye_557@yahoo.com");
        driver.findElement(By.xpath("//button[.='Retrieve password']")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "email_sent";
        Assert.assertTrue(currentUrl.contains(expectedUrl));
        WebElement contest = driver.findElement(By.xpath("//h4[@name='confirmation_message']")); //.getText();
        //String expectedContest = "Your e-mail's been sent!";
        //Assert.assertEquals(contest,expectedContest);
        contest.isDisplayed();

    }

    //TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/add_remove_elements
    // 3. Click to “Add Element” button
    // 4. Verify “Delete” button is displayed after clicking.
    // 5. Click to “Delete” button.
    // 6. Verify “Delete” button is NOT displayed after clicking.
    // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    @Test
    public void Cybertek_AddRemoveElements() {
        driver.get("http://practice.cybertekschool.com/add_remove_elements");
    }


    //TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/add_remove_elements
    // 3. Click to “Add Element” button 50 times
    // 4. Verify 50 “Delete” button is displayed after clicking.
    // 5. Click to ALL “Delete” buttons to delete them.
    // 6. Verify “Delete” button is NOT displayed after clicking.
    // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    // Hint: Need to use findElements method.
    @Test
    public void AddRemoveElements() {

    }


    //TC #2: SeleniumEasy CheckboxVerification–Section 1
    // 1.Open Chrome browser
    // 2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // 3.Verify “Success –Check box is checked” message is NOTdisplayed.
    // 4.Click to checkbox under “Single Checkbox Demo” section
    // 5.Verify “Success –Check box is checked” message isdisplayed.
    @Test
    public void CheckboxVerification() {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        String checkBoxNotDisplayed = "Success –Check box is checked";
        //Assert.assertTrue(checkBoxNotDisplayed);

        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement message = driver.findElement(By.xpath("//div[.='Success - Check box is checked']"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(message.isDisplayed());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        checkBox.click();
        Assert.assertFalse(message.isDisplayed());
    }


    // TC #3: SeleniumEasy Checkbox Verification –Section 2
    // 1.Open Chrome browser
    // 2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // 3.Verify “Check All” button text is “Check All”
    // 4.Click to “Check All” button
    // 5.Verify all check boxes are checked
    // 6.Verify button text changed to “Uncheck All”
    @Test
    public void Checkbox_Verification() {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkAll = driver.findElement(By.xpath("(//input[@type='button']/../input)[1]"));
        checkAll.click();
        WebElement firstBox = driver.findElement(By.xpath("//input[@class='cb1-element']"));
        Assert.assertTrue(firstBox.isSelected());
    }


    //TC #02: FINDELEMENTS_APPLE
    // 1.Open Chrome browser
    // 2.Go to https://www.apple.com
    // 3.Click to iPhone
    // 4.Print out the texts of all links
    // 5.Print out how many link is missing text
    // 6.Print out how many link has text
    // 7.Print out how many total link
    @Test
    public void FINDELEMENTS_APPLE() {
        driver.get("https://www.apple.com");
        WebElement iphone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iphone.click();
        List<WebElement> iphonelinks = driver.findElements(By.xpath("//li//a"));
        int linkWithoutText = 0;
        int linkWithText = 0;

        for (WebElement eachlink : iphonelinks) {
            System.out.println(eachlink.getText());
            if (eachlink.getText().isEmpty()) {
                linkWithoutText++;
            } else {
                linkWithText++;
            }
        }
        System.out.println("iphonelinks.size() = " + iphonelinks.size());
        System.out.println("linkWithoutText = " + linkWithoutText);
        System.out.println("linkWithText = " + linkWithText);
    }


    // TC #03: FINDELEMENTS_APPLE
    // 1.Open Chrome browser
    // 2.Go to https://www.apple.com
    // 3.Click to all of the headers one by one.Mac, iPad, iPhone, Watch, TV, Music, Support
    // 4.Printout how many links on each page with the titles of the pages
    // 5.Loop through all
    // 6.Print out how many link is missing textTOTAL
    // 7.Print out how many link has textTOTAL
    // 8.Print out how many total linkTOTAL
    @Test
    public void FINDELEMENTS_APPLE2() throws InterruptedException {
        driver.get("https://www.apple.com");

        List<WebElement> headers = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
        int linkWithoutText = 0;
        int linkWithText = 0;

        for (int i = 1; i < 8; i++) {
            headers.get(i).click();
            Thread.sleep(1);

            List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
            System.out.println("Number of links on page:" + driver.getTitle() + " " + listOfLinks.size());

            for (WebElement each : listOfLinks) {
                String textOfLink = each.getText();
                if (textOfLink.isEmpty()) {
                    linkWithoutText++;
                } else {
                    linkWithText++;
                }
            }
            System.out.println(linkWithoutText);
            System.out.println(linkWithText);

            driver.navigate().back();
            headers = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
        }

    }


    //TC #3: Amazon link number verification
    // 1. Open Chrome browser
    // 2. Go to https://www.amazon.com
    // 3. Enter search term (use cssSelector to locate search box)
    // 4. Verify title contains search term
    @Test
    public void link_verification() {
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.cssSelector("input[type='text']"));
        searchBox.sendKeys(" search term" + Keys.ENTER);
        String actualTitle = driver.getTitle();
        String expectedTitle = "search term";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    //TC #0: FINDELEMENTS
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/forgot_password
    // 3.Print out the texts of all links
    // 4.Print out how many total link
    @Test
    public void FINDELEMENTS() {
        driver.get("http://practice.cybertekschool.com/forgot_password");
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        for (WebElement eachlink : listOfLinks) {
            String textOfLinks = eachlink.getText();
            System.out.println("textOfLinks = " + textOfLinks);
        }
        System.out.println("Count of links: " + listOfLinks.size());
    }


    //TC #0: FINDELEMENTS
    // 1.Open Chrome browser
    // 2.Go to https://www.merriam-webster.com/
    // 3.Print out the texts of all links
    // 4.Print out how many link is missing text
    // 5.Print out how many link has text
    // 6.Print out how many total link
    @Test
    public void FINDELEMENTS2() {
        driver.get("https://www.merriam-webster.com/");
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        int missingText = 0;
        int withText = 0;

        for (WebElement eachLink : listOfLinks) {
            String textOfLinks = eachLink.getText();
            System.out.println("textOfLinks = " + textOfLinks);
            if (textOfLinks.isEmpty()) {
                missingText++;
            } else {
                withText++;
            }
        }
        System.out.println("missingText = " + missingText);
        System.out.println("withText = " + withText);
        System.out.println("listOfLinks.size() = " + listOfLinks.size());
    }


    //Practice:	Cybertek	Checkboxes
    // 1.Go	to	http://practice.cybertekschool.com/checkboxes
    // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
    // 3.Confirm	checkbox	#2	is	SELECTED	by	default.
    // 4.Click	checkbox	#1	to	select	it.
    // 5.Click	checkbox	#2	to	deselect	it.
    // 6.Confirm	checkbox	#1	is	SELECTED.
    // 7.Confirm	checkbox	#2	is	NOT
    @Test
    public void cybertek_checkbox() {
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        Assert.assertFalse(checkBox1.isSelected());
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Assert.assertTrue(checkBox2.isSelected());
        checkBox1.click();
        checkBox2.click();
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertFalse(checkBox2.isSelected());
    }


    //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”
    // 4.Verify“State selection” default selected value is correctExpected: “Select a State”
    @Test
    public void verifying_Dropdown() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select simpleDropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String defualtOption = simpleDropDown.getFirstSelectedOption().getText();
        String expectedDefualt = "Please select an option";
        Assert.assertEquals(defualtOption, expectedDefualt);
        Select state_selection = new Select(driver.findElement(By.id("state")));
        String actualState = state_selection.getFirstSelectedOption().getText();
        String expectedState = "Select a State";
        Assert.assertEquals(actualState, expectedState);
    }


    // TC #2: Selecting state from State dropdown and verifying result
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select Illinois
    // 4.Select Virginia
    // 5.Select California
    // 6.Verify final selected option is California.Use all Select options.(visible text, value, index)
    @Test
    public void stateDropDown() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select stateDropdownOption = new Select(driver.findElement(By.id("state")));
        stateDropdownOption.selectByVisibleText("Illinois");
        Thread.sleep(2000);
        stateDropdownOption.selectByValue("VA");
        Thread.sleep(2000);
        stateDropdownOption.selectByIndex(5);
        String lastSelected = stateDropdownOption.getFirstSelectedOption().getText();
        String expectedSelected = "California";
        Assert.assertEquals(lastSelected, expectedSelected);
    }


    // TC #3: Selecting date on dropdown and verifying
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select “December 1st, 1921” and verify it is selected.
    // Select year using  : visible text
    // Select month using : value attribute
    // Select day using   : index number
    @Test
    public void selectingDate() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select yearSelecting = new Select(driver.findElement(By.id("year")));
        yearSelecting.selectByVisibleText("1921");

        Select monthSelecting = new Select(driver.findElement(By.id("month")));
        monthSelecting.selectByValue("11");

        Select daySelecting = new Select(driver.findElement(By.id("day")));
        daySelecting.selectByIndex(0);
    }


    // TC #4: Selecting value from multiple select dropdown
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select all the options from multiple select dropdown.
    // 4.Print out all selected values.5.Deselect all values.
    @Test
    public void mulitpleSelect() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        List<WebElement> list1 = driver.findElements(By.xpath("//select[@name='Languages']"));

        Select multipleSelect = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        multipleSelect.selectByVisibleText("Java");
        multipleSelect.selectByVisibleText("JavaScript");
        multipleSelect.selectByValue("c#");
        multipleSelect.selectByIndex(4);
        multipleSelect.selectByVisibleText("Python");
        multipleSelect.selectByVisibleText("C");

        for (WebElement eachlink : list1) {
            System.out.println(eachlink.getText());
        }
        multipleSelect.deselectAll();
    }


    // TC #5: Selecting value from non-select dropdown
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Click to non-select dropdown
    // 4.Select Facebook from dropdown
    // 5.Verify title is “Facebook -Log In or Sign Up”
    @Test
    public void Selecting_value() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[4]")).click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    //TC #1: Smartbear software link verification
    // 1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “test”
    // 5.Click to Login button
    // 6.Print out count of all the links on landing page
    // 7.Print out each link text on this page
    @Test
    public void smartBear_link_cerification() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement userNameBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameBox.sendKeys("Tester");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List<WebElement> Lists = driver.findElements(By.xpath("//body//a"));
        System.out.println(Lists.size());
        for (WebElement eachLintText : Lists) {
            System.out.println(eachLintText.getText());
        }
    }


    //TC#2: Smartbearsoftware order placing
    // 1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “test”
    // 5.Click on Login button
    // 6.Click on Order
    // 7.Select familyAlbum from product, set quantity to 2
    // 8.Click to “Calculate” button
    // 9.Fill address Info with JavaFaker
    // •Generate: name, street, city, state, zip code
    // 10.Click on “visa” radio button
    // 11.Generate card number using JavaFaker
    // 12.Click on “Process”
    // 13.Verify success message “New order has been successfully added.”
    @Test
    public void Smartbearsoftware() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
        driver.findElement(By.xpath("//a[.='Order']")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        select.selectByVisibleText("FamilyAlbum");
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys(Keys.BACK_SPACE + "2");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Faker javaFaker = new Faker();
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        username.sendKeys(javaFaker.name().fullName());
        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys(javaFaker.address().streetAddress());
        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys(javaFaker.address().city());
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys(javaFaker.address().state());
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCode.sendKeys(javaFaker.address().zipCode().replaceAll("-", ""));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();
        WebElement creditCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        creditCard.sendKeys(javaFaker.finance().creditCard().replaceAll("-", ""));
        WebElement expirationDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("10/25");
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
        String message = driver.findElement(By.xpath("//strong")).getText();
        String expectedMessage = ("New order has been successfully added.");
        Assert.assertEquals(message, expectedMessage);
    }


    //TC#3: Smartbear software order verification
    // 1.Open browser and login to Smartbear software
    // 2.Click on View all orders
    // 3.Verify Susan McLaren has order on date “01/05/2010”
    @Test
    public void order_verification() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
        String orderName = driver.findElement(By.xpath("//td[.='Susan McLaren']")).getText();
        String expectedOrderName = "Susan McLaren";
        String orderDate = driver.findElement(By.xpath("//td[.='01/05/2010']")).getText();
        String expectedOrderDate = "01/05/2010";
        Assert.assertEquals(orderDate, expectedOrderDate, "Order date does not match! Verification FAIL!!!");
        Assert.assertEquals(orderName, expectedOrderName, "Order name does not match! Verification FAIL!!!");
    }


    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verify Order in SmartBearUtils class.
    // •Method takes WebDriver object and String(name).
    // •Method should verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.
    @Test
    public void verifyOrder() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
        SmartBearUtilities.verifyOrder(driver, "Mark Smith");
    }


    // Practice #5: Method: printNamesAndCities
    // •Create a method named printNamesAndCitiesin SmartBearUtils class.
    // •Method takes WebDriver object.
    // •This method should simply print all the names in the List of All Orders.
    // •Create a new TestNG test to test if the method is working as expected.
    // •Output should be like:
    // •Name1: name , City1: city
    // •Name2: name , City2: city
    @Test
    public static void printNameAndCity(WebDriver driver) {
    }


    //TC#6: Cybertek registration form confirmation
    // Note: Use JavaFaker when possible.
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/registration_form
    // 3.Enter first name
    // 4.Enter last name
    // 5.Enter username
    // 6.Enter email address
    // 7.Enter password
    // 8.Enter phone number
    // 9.Select a gender from radio buttons
    // 10.Enter date of birth
    // 11.Select Department/Office
    // 12.Select Job Title
    // 13.Select programming language from checkboxes
    // 14.Clickto sign up button
    // 15.Verify success message “You’ve successfully completed registration.”is displayed.
    @Test
    public void registrationform_Verification() {
        driver.get("http://practice.cybertekschool.com/registration_form");
        Faker javaFaker = new Faker();
        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement phonenumber = driver.findElement(By.xpath("//input[@name='phone']"));
        WebElement gender = driver.findElement(By.xpath("//input[@name='gender']"));
        WebElement DOB = driver.findElement(By.xpath("//input[@name='birthday']"));
        firstname.sendKeys(javaFaker.name().firstName());
        lastname.sendKeys(javaFaker.name().lastName());
        username.sendKeys(javaFaker.name().fullName().replaceAll(" ", ""));
        email.sendKeys(javaFaker.internet().emailAddress());
        password.sendKeys(javaFaker.number().digits(8));
        phonenumber.sendKeys(javaFaker.phoneNumber().phoneNumber());
        gender.click();
        DOB.sendKeys("01/28/1992");
        Select select = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        select.selectByVisibleText("Mayor's Office");
        Select secondSelect = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        secondSelect.selectByVisibleText("SDET");
        WebElement programLanguage = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        programLanguage.click();
        driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();
        WebElement message = driver.findElement(By.xpath("//div[@class='alert alert-success']/p"));
        Assert.assertTrue(message.isDisplayed());
    }


    //TC #1: Information alert practice
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    // 3.Click to “Click for JS Alert”button
    // 4.Click to OK button from the alert
    // 5.Verify “You successfulyclicked an alert”text is displayed.
    @Test
    public void alert_practice() {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        Alert JS_Alert = driver.switchTo().alert();
        BrowserUtils.wait(1);
        JS_Alert.accept();
    }


    // TC #2: Confirmationalert practice
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    // 3.Click to “Click for JS Confirm” button
    // 4.Click to OK button from the alert
    // 5.Verify “You clicked: Ok” text is displayed.
    @Test
    public void Confirmation_alert() {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        BrowserUtils.wait(2);
        alert.accept();
    }


    // TC #3: Information alert practice
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    // 3.Click to “Click for JS Prompt” button
    // 4.Send “hello”text to alert
    // 5.Click to OK button from the alert
    // 6.Verify “You entered:  hello” text is displayed.
    @Test
    public void Information_alert() {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        BrowserUtils.wait(1);
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(message.isDisplayed());
    }


    //TC #4: Iframe practice
    // 1.Create a new class called: IframePractice
    // 2.Create new test and make set ups
    // 3.Go to: http://practice.cybertekschool.com/iframe
    // 4.Assert: “Your content goes here.” Text is displayed.
    // 5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
    @Test
    public void iframe() {
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement message = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(message.isDisplayed());
        driver.switchTo().defaultContent();
        WebElement headerText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(headerText.isDisplayed());
    }


    //TC# :	Window	Handle practice
    // 1.Create	a new class	called:	WindowHandlePractice
    // 2.Create	new	test and make set ups
    // 3.Go	to : http://practice.cybertekschool.com/windows
    // 4.Assert: Title	is	“Practice”
    // 5.Click to: “Click Here”text
    // 6.Switch	to new	Window.
    // 7.Assert: Title is “New Window”
    @Test
    public void handle_Practice() {
        driver.get("http://practice.cybertekschool.com/windows");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        String mainHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current Title: " + driver.getTitle());
        }
        Assert.assertTrue(driver.getTitle().equals("New Window"));
        BrowserUtils.wait(1);
        driver.close();
        driver.switchTo().window(mainHandle);
    }


    //TC-6 : Window Handle practice
    // 1.Create new test and make set ups
    // 2.Go to : https://www.amazon.com
    // 3.Copy paste the lines from below into your class
    // 4.Create a logic to switch to the tab where Etsy.com is open
    // 5.Assert: Title contains “Etsy”
    @Test
    public void windowHandle() {
        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        Set<String> SetOfWindows = driver.getWindowHandles();
        for (String each : SetOfWindows) {
            driver.switchTo().window(each);
            System.out.println(driver.getTitle());
            if (driver.getTitle().equals("Etsy")) {
                break;
            }
        }
    }


    //TC #9: SmartBear delete order
    // 1.Open browser and login to SmartBear
    // 2.Delete “Mark Smith” from the list
    // 3.Assert it is deleted from the list
    @Test
    public void SmartBearDelete() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']")).click();
        List<WebElement> listOfNames = driver.findElements(By.xpath("//td//td[2]"));
        for (WebElement eachName : listOfNames) {
            if (!eachName.getText().equals("Mark Smith")) {
                System.out.println("Mark Smith deleted Verification PASS!!!");
            } else {
                System.out.println("Verification FAIL!!!");
            }
        }
    }


    // TC #10: SmartBear edit order
    // 1.Open browser and login to SmartBear
    // 2.Click to edit button from the right for “Steve Johns”
    // 3.Change name to “Michael Jordan”
    // 4.Click Update5.Assert “Michael Jordan” is in the list
    @Test
    public void smartBearEdit() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
        driver.findElement(By.xpath("(//td//tr/td[13]/../td[13])[3]")).click();
        WebElement inpuBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        inpuBox.clear();
        inpuBox.sendKeys("Micheal Jordan");
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']")).click();
        List<WebElement> listOfNames = driver.findElements(By.xpath("//td/../td[2]"));
        for (WebElement eachName : listOfNames) {
            if (eachName.getText().equals("Micheal Jordan")) {
                Assert.assertTrue(true);
            }
        }
    }


    // TC#11: Create a method called removeName()
    // 1.Accepts two parameters: WebDriver, String name
    // 2.Method will remove the given name from the list of Smartbear
    // 3.Create a new TestNG test, and call your method.
    // 4.Assert that your method removed the given name


    //TC#15: Hover Test
    // 1.Go to http://practice.cybertekschool.com/hovers
    // 2.Hover over	to first image
    // 3.Assert:
    //          a.“name: user1” is displayed
    // 4.Hover over	to second image
    // 5.Assert:
    //          a.“name: user2”	is displayed
    // 6.Hover over	to third image
    // 7.Confirm:
    //          a.“name: user3”	is di
    @Test
    public void hover_Test() {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement picture1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement picture2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement picture3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));
        WebElement message1 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[1]"));
        WebElement message2 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[2]"));
        WebElement message3 = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[3]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(picture1).perform();
        Assert.assertTrue(message1.isDisplayed());
        actions.moveToElement(picture2).perform();
        Assert.assertTrue(message2.isDisplayed());
        actions.moveToElement(picture3).perform();
        Assert.assertTrue(message3.isDisplayed());
    }


    //TC #16: Double ClickTest
    // 1.Go	to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    // 2.Switch	to iframe.
    // 3.Double	click on the text “Double-click	me	to change my text color.”
    // 4.Assert: Text’s	“style”	attribute value	color : red
    @Test
    public void double_click() {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        BrowserUtils.wait(1);
        driver.switchTo().frame("iframeResult");
        WebElement message = driver.findElement(By.xpath("//p[@id='demo']"));
        BrowserUtils.wait(1);
        Actions actions = new Actions(driver);
        actions.moveToElement(message).doubleClick().perform();
        WebElement getAttribute1 = driver.findElement(By.xpath("//p[@id='demo']"));
        String attValue = getAttribute1.getAttribute("style");
        Assert.assertTrue(attValue.contains("color: red;"));


    }


    //TC#17: Context Click –HOMEWORK
    // 1.Go	to https://the-internet.herokuapp.com/context_menu
    // 2.Right click to	the	box.
    // 3.Alert	will open.
    // 4.Accept	alert
    // No assertion	needed	for	this practice
    @Test
    public void context_click() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box1 = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action = new Actions(driver);
        action.moveToElement(box1).contextClick().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    //TC#16: Hover Test
    // 1.Go	to https://demos.telerik.com/kendo-ui/dragdrop/index
    // 2.Drag and drop the small circle	to	bigger circle.
    // 3.Assert:
    //      -Text in big circle	changed to:	“You did great!”
    @Test
    public void hover_test() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        BrowserUtils.wait(1);
        WebElement smallCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = driver.findElement(By.xpath("//div[@id='droptarget']"));
        actions.moveToElement(smallCircle).clickAndHold().moveToElement(bigCircle).perform();
    }


    //TC#30: Vytrack negative login test -> Wrong Password Test
    // 1. Go to https://qa3.vytrack.com
    // 2. Enter correct username
    // 3. Enter incorrectpassword
    // 4. Verify error message text is as expected
    //         Expected: “Invalid user name or password.
    // ”Note: Follow Page Object Model design pattern, and get your correct credentials from configuration.properties file




    //TC#31: Vytrack negative login test -> Wrong Username Test
    // 1. Go to https://qa3.vytrack.com
    // 2. Enter incorrectusername
    // 3. Enter correctpassword
    // 4. Verify error message text is as expected
    //       Expected: “Invalid user name or password.”
    //  Note: Follow Page Object Model design pattern, and get your correct credentials from configuration.properties file





    //TC#32 : Vytrack positive login test -> Sales Manager
    // 1. Go to https://qa3.vytrack.com
    // 2. Enter correct username
    // 3. Enter correct password
    // 4. Verify title changed
    //          Expected: “Dashboard”
    //   Note: Follow Page Object Model design pattern, and get your correct credentials from configuration.properties file



    //TC#32 : Vytrack positive login test -> Sales Manager
    // 1. Go to https://qa3.vytrack.com
    // 2. Enter correct username
    // 3. Enter correct password
    // 4. Verify title changed
    //          Expected: “Dashboard”
    //  Note: Follow Page Object Model design pattern, and get your credentials from configuration.properties file


    //TC#33 : Vytrackpositive login test -> Driver Manager
    // 1. Go to https://qa3.vytrack.com
    // 2. Enter correct username
    // 3. Enter correct password
    // 4. Verify title changed
    //          Expected: “Dashboard”
    // Note: Follow Page Object Model design pattern, and get your credentials from configuration.properties file


    //TC#34 : Vytrack positive login test -> Store Manager
    // 1. Go to https://qa3.vytrack.com
    // 2. Enter correct username
    // 3. Enter correct password
    // 4. Verify title changed
    //          Expected: “Dashboard”
    // Note: Follow Page Object Model design pattern, and get your credentials from configuration.properties file


    //TC#35: Vytrack forgot password page verifications -> TITLE and URL
    // 1. Go to https://qa3.vytrack.com
    // 2. Click to “Forgot your password?”link
    // 3. Verify title changed to expected
    //            Expected: “Forgot Password”
    // 4. Verify url is as expected:
    //            Expected: “https://qa3.vytrack.com/user/reset-request”
    // Note: Follow Page Object Model design pattern



    //TC#36: Vytrack forgot password pageverification -> ERROR MESSAGE
    // 1.Go to https://qa3.vytrack.com/user/reset-request
    // 2.Enter random username
    // 3. Click to request button
    // 4. Verifyerror message is displayed
    // 5. Verify error message text is as expected.
    //           Expected: There is no active user with username or email address “given text”.
    //  Note: Follow Page Object Model design pattern




}



