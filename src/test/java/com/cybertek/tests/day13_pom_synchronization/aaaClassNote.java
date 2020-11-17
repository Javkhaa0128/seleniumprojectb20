package com.cybertek.tests.day13_pom_synchronization;
/*
Oct 14th, Wednesday
REVIEW SESSION:
JavaScriptExecutor:
    - It is basically just an interface coming from Selenium library that has 2 methods.
    - These methods allow us to use JavaScript code in our Java/Selenium code.
    - We use JSExecutor interface when we want to do things that we cannot do with our Java/Selenium code, such as: scrolling.
    How do we use JSExecutor?
    - We need to downcast our WebDriver type to JavaScriptExecutor type.
    - Only then we will be able to use methods coming from JavaScriptExecutor.
    Syntax:
    #1-) We create instance of JavaScriptExecutor, and cast our driver type to it.
        JavaScriptExecutor js = (JavaScriptExecutor) Driver.getDriver();
    #2-) We use 'js' object to reach JavaScriptExecutor methods.
    #3-) We just pass whatever JavaScript code we want to use/inject into those methods.
    js.executeScript("java script code")
    -> arguments[0].scrollIntoView(true) --> this will scroll to a specific web element we want to scroll
    js.executeScript("arguments[0].scrollIntoView(true)", WebElementWeWantToScroll);
    js.executeScript("arguments[0].scrollIntoView(true)", link);
    js.executeScript("window.scrollBy(0, anyNum)"); -> we pass here two numbers that will be accepted as x and y axis.
    - if i want to move down 500 pixels, and I dont want to move left or right:
    js.executeScript("window.scrollBy(0, 500)"); --> this will scroll 500 pixels down
    js.executeScript("window.scrollBy(0, -500)"); --> this will scroll 500 pixels up
    -> sending string using js function
    js.executeScript("arguments[0].setAttribute('value', 'something@gmail.com')", emailInput);
    -> clicking to web element using js function
    js.executeScript("arguments[0].click()", signUpbutton);
========================================================================
Today's schedule:
    - Page Object Model Design Pattern Review
    - Synchronization / WebDriverWait class
------------------------------------
What tools/languages we are currently using in our project?
    - Java
    - Selenium
    - TestNG
    - Maven (as a built automation tool)
    - JavaFaker
    - WebDriverManager
What does our folder structure look like?
    -src
        -test
            -java
                -com.PROJECT
                    -tests
                    -utilities
                        -Driver
                        -ConfigurationReader
                        -SmartBearUtils
                        -BrowserUtils
                        -WebDriverFactory
                    -pages
    -configuration.properties
    -pom.xml
TELL ME ABOUT YOUR FRAMEWORK?
What tools we are using
What kind of folder structure we created
What kind of JAVA/SELENIUM logic we created
What kind of design patterns we used in our project
What Design Pattern we have used?
    - Singleton Design Pattern
        - What issue did we adress using this pattern?
            - We solved the problem of doing the same setup for our driver in each and every class
            - We made sure that we are getting exactly the same driver instance every time we call our driver
        - How did we achieve Singleton Design Pattern?
            - Created a private constructor, and created getter method that returns the same driver instance all the time.
    - Page Object Model Design Pattern, aka(also known as) POM
        - What is Page Object Model Design Pattern:
            - Creating java classes for the each page of AUT. And we store related web elements in its own java class.
                - LoginPage.java
                    -username
                    -password
                    -loginbutton
                    -errormessage
                    -LOGINMETHOD(username,password)
                - LandingPage.java
                - SearchPage.java
    What are the advantages of using POM?
        - Re-usable: We locate web elements ONLY ONCE, then we keep re-using.
        - Easy to maintain : Since we store each web element only once, we know exactly where to find the web element and how to fix the problem.
        - Readable : Very easy to understand
    How do we achieve Page Object Model Design Pattern?
    -> After creating the java class
        #1 -  Create constructor, and initialize elements: driver, class object.
            public LoginPage(){
                PageFactory.initElements(driver, this);
            }
        #2 - We need to use @FindBy annotation to locate web elements
        @FindBy( locatorType = "locator")
        public WebElement usernameInput;
 */
public class aaaClassNote {
}
