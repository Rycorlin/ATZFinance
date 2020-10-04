/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.LoginView;
import atzfinance.CreditQuery;
import atzfinance.Customer;
import atzfinance.IncidentReport;
import atzfinance.Loan;
import atzfinance.User;
import atzfinance.LoanOfficer;
import java.util.ArrayList;
import atzfinance.TechSupport;
import atzfinance.LoanTransaction;


/**
 *
 * @author rycor
 */
public class TestHarness
{

    public static void main(String[] args) throws Exception
    {

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
        CreditQuery cq = new CreditQuery();
        //Integer creditScore = Integer.parseInt(cq.getScore());
        c1.setcustomerID(1);
        c1.setNumLoansActive(2);
        c1.setCreditScore(420);

        System.out.println("<<Customer TESTING>>");
        System.out.println("Customer 1 User ID: " + c1.getcustomerID());
        System.out.println("Customer 1 Number of loans active: " + c1.getNumLoansActive());
        System.out.println("Customer 1 Credit Score: " + c1.getCreditScore());
        System.out.println("-------------------------------");
        ////////////////////////////////////////////////////////////////////////////////////////////
     
         ////// LOAN TESTING ////////////////////////////////////////////////////////////////////////
        Loan l1 = new Loan(10.5, 72, 15000);
        Loan l2 = new Loan(15.0, 60, 12000);
        Loan l3 = new Loan(24.3, 120, 50000);
        System.out.println("<<Loan TESTING>>");
        System.out.println("Loan 1 Terms: Interest Rate = " + l1.getInterest_Rate() + "% ,Term in Months: " + l1.getTerm_Length_In_Months() + " ,Balance Due: " + l1.getBalanceDue());
        System.out.println("Loan 2 Terms: Interest Rate = " + l2.getInterest_Rate() + "% ,Term in Months: " + l2.getTerm_Length_In_Months() + " ,Balance Due: " + l2.getBalanceDue());
        System.out.println("Loan 3 Terms: Interest Rate = " + l3.getInterest_Rate() + "% ,Term in Months: " + l3.getTerm_Length_In_Months() + " ,Balance Due: " + l3.getBalanceDue());

        l3.setBalanceDue(45000);
        System.out.println("New Balance Loan Terms: Interest Rate = " + l3.getInterest_Rate() + "% ,Term in Months: " + l3.getTerm_Length_In_Months() + " ,Balance Due: " + l3.getBalanceDue());
        l3.setInterest_Rate(22.10);
        l3.setTerm_Length_In_Months(119);
        System.out.println("New Balance Loan Interest Rate & Length changed: Interest Rate = " + l3.getInterest_Rate() + "% ,Term in Months: " + l3.getTerm_Length_In_Months() + " ,Balance Due: " + l3.getBalanceDue());
        System.out.println("-------------------------------");
      
       
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////// LOAN TRANSACTION TESTING ////////////////////////////////////////////////////////////
        System.out.println("<<Loan Transation TESTING>>");
        System.out.println("***Customer side of making a payment***");
        System.out.println("The Loan Balance for Loan 1 is " + l1.getBalanceDue());
        LoanTransaction lt1 = new LoanTransaction();
        lt1.makePayment(l1, 200.0);
        System.out.println("Thank you for your $200 payment. Your new balance = " + l1.getBalanceDue());
        System.out.println(" ");

        System.out.println("***Employee side of crediting an account***");
        LoanTransaction lt2 = new LoanTransaction();
        lt2.creditAccount(l2, 2000.0);
        System.out.println("The account has been credited $2000.");
        System.out.println("The new balance = " + l2.getBalanceDue());

        System.out.println("-------------------------------");

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////// INCIDENT REPORT TESTING /////////////////////////////////////////////////////////////
        // Default
        IncidentReport incidentReport1 = new IncidentReport();
        // user, string args
        IncidentReport incidentReport2 = new IncidentReport(u1, "Ryan put Tdawg's stapler in a bowl of jello");

        System.out.println("<<IncidentReport TESTING>>");
        // set, get user
        incidentReport1.setUser(u2);
        System.out.println("Incident 1 User Information, through incident report object: " + incidentReport1.getUser().getFirstName());

        // set, get message
        incidentReport1.setMessage("Tdawg spilled coffee on Ryan's TPS report");
        System.out.println("Incident Report 1 Message: " + incidentReport1.getMessage());

        // printReport
        System.out.print("Incident Report 2 Print: ");
        incidentReport2.printReport();

        // setMessage again, new report.
        incidentReport2.setMessage("This is a new message...");
        System.out.println("New message: " + incidentReport2.getMessage());

        System.out.println("-------------------------------");
        ////////////////////////////////////////////////////////////////////////////////////////////

        
        ////// LOAN OFFICER TESTING ////////////////////////////////////////////////////////////////
        LoanOfficer lo1 = new LoanOfficer(12345, "Ryan", "OHagan", "rjo2880", 978685536);
        lo1.setNumLoansActive(10);
        ArrayList<Loan> historicalLoanTest = new ArrayList<Loan>();
        Loan loanTest1 = new Loan(.75, 1, 10.00);
        historicalLoanTest.add(loanTest1);
        lo1.setHistoricalLoans(historicalLoanTest);
        System.out.println("Performance Data " + lo1.getPerformanceMetrics());
        System.out.println("GetActiveLoans: " + lo1.getNumLoansActive());
        System.out.println("Get Historical Loans: " + lo1.getHistoricalLoans());
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////// CREDIT QUERY TESTING ////////////////////////////////////////////////////////////////
        CreditQuery cq2 = new CreditQuery();
        int creditScore = cq2.getScore();
        System.out.println("Credit score: " + creditScore);
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        ////// TECH SUPPORT TESTING ////////////////////////////////////////////////////////////////
        TechSupport ts1 = new TechSupport("Ryan", "OHagan", "rjo2880", 978685536);
        ArrayList<IncidentReport> testResults = ts1.searchErrorReports(u3);
        for (IncidentReport report : testResults){
            System.out.println("Name: " + report.getUser().getFirstName() + report.getUser().getLastName() +  " Message: " + report.getMessage());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////// LOGIN CONTROLLER TESTING ////////////////////////////////////////////////////////////////
        System.out.println("\n<<Login Controller TESTING>>");
        LoginController loginController = new LoginController(new LoginView());

        System.out.println("Testing login with correct credentials...");
        System.out.println(loginController.login("", ""));
        System.out.println("Testing login with incorrect credentials...");
        System.out.println(loginController.login("user", "pass"));

        //launches the GUI
        loginController = new LoginController(args);
        ////////////////////////////////////////////////////////////////////////////////////////////

    }
}
