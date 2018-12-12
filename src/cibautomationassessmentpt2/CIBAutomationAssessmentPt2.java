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
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CIBAutomationAssessmentPt2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
//        Runtime.getRuntime().exec("cmd /c start \"\" build.bat");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tmathobela\\Downloads\\chromedriver_win32\\chromedriver.exe");
       
        WebDriver driver = new ChromeDriver();
        
        driver.navigate().to("http://www.way2automation.com/angularjs-protractor/webtables/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    
        driver.manage().window().maximize();

        if (!driver.findElement(By.xpath("//table/thead/tr/th/span[text()='User Name']")).isDisplayed()) {
           System.out.println("false");
        }    
       
//       File FilePath = new File("C:\\Users\\tmathobela\\Downloads\\UserDetails.xlsx");
//       FileInputStream fs = new FileInputStream(FilePath);
     
        driver.findElement(By.xpath("//button[contains(text(), 'Add User')]")).click();
       
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("FName");
       
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("LName");    
        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("LName");
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("LName");
        driver.findElement(By.xpath("//input[@value = 15]")).click();
        WebElement el = driver.findElement(By.xpath("//select[@name='RoleId']"));
        Select sel = new Select(el);
        sel.selectByVisibleText("Customer");
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("LName@mail.com");
        driver.findElement(By.xpath("//input[@name='Mobilephone']")).sendKeys("LName");

        driver.findElement(By.xpath("//button[text()= 'Save']")).click();
       boolean value = true;
        List<String> val =  new ArrayList<>();
        val.add("FName");
         val.add("jjj");
         
        List<WebElement> cells = driver.findElements(By.xpath("//td[@class='smart-table-data-cell']"));

        for(int i=0; i<val.size(); i++ ){
            for (WebElement cell : cells) {
                if (cell.getText().equals(val.get(i))){
                    value = true;
                   break;
                }
                else {
                    value = false;
                }
                
            }
            if(!(value==true)){
                System.out.print("false");
            } 
        }
            
        
     
    }
       

}

