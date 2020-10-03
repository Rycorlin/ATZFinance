/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import atzfinance.Customer;
import atzfinance.IncidentReport;
import atzfinance.User;

/**
 *
 * @author rycor
 */
public class TestHarness {

    public static void main(String[] args) throws Exception {
            
        
        ////// USER TESTING ////////////////////////////////////////////////////////////////////////
        User u1 = new User("Ryan", "Milici", "Myliu", 12312412);
        User u2 = new User("Ted", "Tedson", "Tdawg", 223412);
        User u3 = new User("John", "Johnson", "Jman", 00123);
        
        System.out.println("<<USER TESTING>>");
        System.out.println("Testing User First Name: " + u1.getFirstName());
        System.out.println("Testing User Last Name: " + u1.getLastName());
        System.out.println("Testing User's User Name: " + u1.getUserName());
        System.out.println("Testing User Social Security: " + u1.getSocialSecurityNumber());
        System.out.println("-------------------------------"); 
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        ////// CUSTOMER TESTING ////////////////////////////////////////////////////////////////////
        Customer c1 = new Customer();
        c1.setcustomerID(1);
        c1.setNumLoansActive(2);
        c1.setCreditScore(420);
        
        System.out.println("<<Customer TESTING>>");
        System.out.println("Customer 1 User ID: " + c1.getcustomerID());
        System.out.println("Customer 1 Number of loans active: " + c1.getNumLoansActive());
        System.out.println("Customer 1 Credit Score: " + c1.getCreditScore());
        System.out.println("-------------------------------");
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        ////// INCIDENT REPORT TESTING /////////////////////////////////////////////////////////////
        IncidentReport incidentReport1 = new IncidentReport(u2, "Tdawg spilled coffee on Ryan's TPS report");
        IncidentReport incidentReport2 = new IncidentReport(u1, "Ryan put Tdawg's stapler in a bowl of jello");
        
        System.out.println("<<IncidentReport TESTING>>");
        System.out.print("Incident Report 1 Print: ");
        incidentReport1.printReport();
        System.out.print("Incident Report 2 Print: ");
        incidentReport2.printReport();
        System.out.println("Incident 2 User Information, through incident report object: " + incidentReport2.getUser().getFirstName());
        
        
        
        System.out.println("-------------------------------");
        
        
        
        System.out.println("<<Login Controller TESTING>>");
        LoginController loginController = new LoginController(args);
        
        
        

    }
}