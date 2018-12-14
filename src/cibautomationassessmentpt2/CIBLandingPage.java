/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cibautomationassessmentpt2;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author tmathobela
 */
public class CIBLandingPage {
  
    //initialise webdriver object
    WebDriver driver = new ChromeDriver();
   
    String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
    String extentReportImage = System.getProperty("user.dir") + "\\extentReportImage.png";

   // ExtentReports extentRp = new ExtentReports(extentReportFile,false);
  //  ExtentTest extentTest; 

    //Assigns values
    UserDetails user1 = new UserDetails("FName1","LName1","User1","Pass1",15,"Admin","admin@mail.com","082555");
    UserDetails user2 = new UserDetails("FName2","LName2","User2","Pass2",16,"Customer","customer@mail.com","083444");
    
    
    public void navigate(){
       //  extentRp.startTest("CIB Automation Assessment Pt2");
         driver.navigate().to("http://www.way2automation.com/angularjs-protractor/webtables/");
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    
         driver.manage().window().maximize();
    }
    
    public void addButton(){
        driver.findElement(By.xpath("//button[contains(text(), 'Add User')]")).click();
    }
  
    //call insertData method - To insert data into fields
    public void insertData(){
       
        //Adds values in array list
        ArrayList<UserDetails> userdet = new ArrayList<UserDetails>(); 
        userdet.add(user1);
        userdet.add(user2);
        
        //Decalre variables
        Random rand;
        int num = 0;
        String user;
        Select select;
        String exp = "this is not a unique value";
        
        //Iterating through the values in the array
        Iterator i=userdet.iterator();  
        while(i.hasNext()){ 
             
            //call addButton method - To click add button
            this.addButton();
            
            //Gets user details
            UserDetails ud=(UserDetails)i.next();  

            inputValues("FirstName", ud.firstName);
            inputValues("LastName", ud.lastName);
            
            //Checking if username is unique
            //If the user element is not found, the exception will be caught and values will be entered...
            //Else the username will be tied with random number to be unique
            //the new user name created and checked again if unique
            user = ud.userName;
            try{
                driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]")).isDisplayed(); 
            }
            catch (NoSuchElementException e){

                exp = e.toString();
                
            }
          
           // while (driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]")).isDisplayed()) {
            while (exp.contains("this is not a unique value")) {
                
                //Random number generator
                rand = new Random();
                num = rand.nextInt(10000);
                
                //new user created
                user = ud.userName + String.valueOf(num);
                
                //checking if user is unique
                try{
                    driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]")).isDisplayed(); 
                }
                catch (NoSuchElementException e){

                    exp = e.toString();
                }
            }  
            
            inputValues("UserName", user);
            inputValues("Password", ud.password);
                
            driver.findElement(By.xpath("//input[@value = "+ud.customer+"]")).click();
           
            //Selecting an item in drop down
            WebElement elm = driver.findElement(By.xpath("//select[@name='RoleId']"));
            select = new Select(elm);
            select.selectByVisibleText(ud.role);
      
            inputValues("Email",ud.email);
            
            inputValues("Mobilephone", ud.cell);

            this.saveBtn();
            
            //Check if value is added by comparing the data from the assigned constructors to the list of values in the table
            boolean value = true;
            List<WebElement> cells = driver.findElements(By.xpath("//td[@class='smart-table-data-cell']"));
            for(int j=0; j<userdet.size(); j++ ){
                for (WebElement cell : cells) {
                   if (cell.getText().contains(userdet.get(j).toString())){
                        value = true;
                        break;
                    }
                    else {
                        value = false;
                    }
                   
                }
                
                if(!(value==true)){
                    System.out.println("There is a value not added");
                //    extentTest.log(LogStatus.FAIL, "There is a value not added in the table");
                } 
                else{
                //    extentTest.log(LogStatus.PASS, "There values are added in the table");
                }
            }
   
        }
        
    }
    
    //Method to clear and enter value to field... 
    //The xpath is derived of similar attributes except name of which it will be passed in with value
    public void inputValues(String nameProperty, String value){
            
        driver.findElement(By.xpath("//input[@name='"+nameProperty+"']")).clear();
        driver.findElement(By.xpath("//input[@name='"+nameProperty+"']")).sendKeys(value);
        
    }
    
    //Check if table exist by cheking if it's displayed
    public void findUserTable(){
        
        if (!driver.findElement(By.xpath("//table/thead/tr/th/span[text()='User Name']")).isDisplayed()) {
           System.out.println("User Table does not exist");
          // extentTest.log(LogStatus.INFO, "User Table does not exist");
        }  
        
    }
    
    //Click save button
    public void saveBtn(){
      //  extentTest.log(LogStatus.INFO, "Data inserted and saved");
        driver.findElement(By.xpath("//button[text()= 'Save']")).click();
    }
    
    //Close app after run
    public void closeApp(){
        
        driver.close();
     //   extentTest.log(LogStatus.INFO, "App closed");
      //  extentRp.flush();
    }
            
}
