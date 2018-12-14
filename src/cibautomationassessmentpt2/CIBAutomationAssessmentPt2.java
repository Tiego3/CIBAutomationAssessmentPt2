/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cibautomationassessmentpt2;

/**
 *
 * @author tmathobela
 */


import java.io.File;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 * @author tmathobela
 */
public class CIBAutomationAssessmentPt2 {
    
    WebDriver driver = new ChromeDriver();
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
   
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        //set Chromedriver to enable running on chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tmathobela\\Downloads\\chromedriver_win32\\chromedriver.exe");
             
        //initialise CIBLandingPage class
        CIBLandingPage cib = new CIBLandingPage();   
        
        // call navigate method - driver object to navigate to webpage - wait for page to load - and maximize window
        cib.navigate();
        
//         call findUserTable method- To verify if table exist
        cib.findUserTable();

        //call insertData method - To insert data into fields
        cib.insertData();
        
        //Close app
        cib.closeApp();
     
    }    
    
}