/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cibautomationassessmentpt2;

//import java.util.ArrayList;

/**
 *
 * @author tmathobela
 */
public class UserDetails {
    
    String firstName, lastName, userName , password,  role,  email,  cell;
    int customer;
    
    UserDetails(String firstName, String lastName, String userName, String password, int customer, String role, String email, String cell){
        
       
       this.firstName = firstName;
       this.lastName = lastName;
       this.userName = userName;
       this.role = role;
       this.customer = customer;
       this.email = email;
       this.password = password;
       this.cell = cell;
      
    }
    
}







