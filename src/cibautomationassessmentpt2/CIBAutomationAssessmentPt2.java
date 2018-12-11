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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CIBAutomationAssessmentPt2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tmathobela\\Downloads\\chromedriver_win32\\chromedriver.exe");
       
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
    
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//table//span[text()='User Name'])"));
        
        public boolean IsTestElementPresent()
        {
            try
            {
                driver.findElement(By.xpath("//table//span[text()='User Name'])"));
                return true;
             }
            catch (NoSuchElementException)
            {
                return false;
            }  
              
        }
        
        

//    public void FindObject(){
//        
//
//    }  *
    
}

