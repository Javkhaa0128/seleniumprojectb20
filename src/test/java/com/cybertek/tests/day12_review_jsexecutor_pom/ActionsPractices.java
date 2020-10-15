package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class UploadPractice {

    @Test
    public void uploading_file_test(){
        //Getting the page
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        String path = "C:\\Users\\javkh\\OneDrive\\Pictures\\Saved Pictures";
    }
}
