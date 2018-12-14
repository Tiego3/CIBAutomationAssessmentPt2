/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cibautomationassessmentpt2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author tmathobela
 */
public class CIBLandingPage {
    
    WebDriver driver = new ChromeDriver();
    
    public void addButton(){
        driver.findElement(By.xpath("//button[contains(text(), 'Add User')]")).click();
    }
   
    public void insertData(String firstName, String lastName, String userName, String password, String customer, String role, String email, String cell){
        this
    }
}
