///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controller;
//
//import Model.CreditQuery;
//import Model.IncidentReport;
//import Model.User;
//import Model.LoanOfficer;
//import Model.LoanTemplate;
//import java.util.ArrayList;
//import Model.TechSupport;
//import Model.LoanTransaction;
//import Model.CarLoan;
//import Model.PersonalLoan;
//
//
///**
// *
// * @author rycor
// */
//public class TestHarness
//{
//
//    public static void main(String[] args) throws Exception {
//
//        ////// USER TESTING ////////////////////////////////////////////////////////////////////////
//        User u1 = new User("Ryan", "Milici", "Myliu", "test");
//        User u2 = new User("Ted", "Tedson", "Tdawg", "test");
//        User u3 = new User("John", "Johnson", "Jman", "test");
//
//        System.out.println("<<USER TESTING>>");
//        System.out.println("Testing User First Name: " + u1.getFirstName());
//        System.out.println("Testing User Last Name: " + u1.getLastName());
//        System.out.println("Testing User's User Name: " + u1.getUserName());
//        System.out.println("Testing User Social Security: ");
//        System.out.println("-------------------------------");
//        ////////////////////////////////////////////////////////////////////////////////////////////
//
//        ////// CUSTOMER TESTING ////////////////////////////////////////////////////////////////////
//        /*Customer c1 = new Customer();
//        CreditQuery cq = new CreditQuery();
//        //Integer creditScore = Integer.parseInt(cq.getScore());
//        c1.setcustomerID(1);
//        c1.setNumLoansActive(2);
//        c1.setCreditScore(420);
//
//        System.out.println("<<Customer TESTING>>");
//        System.out.println("Customer 1 User ID: " + c1.getcustomerID());
//        System.out.println("Customer 1 Number of loans active: " + c1.getNumLoansActive());
//        System.out.println("Customer 1 Credit Score: " + c1.getCreditScore());
//        System.out.println("-------------------------------");*/
//        ////////////////////////////////////////////////////////////////////////////////////////////
//     
//         ////// LOANTEMPLATE TESTING ////////////////////////////////////////////////////////////////////////
//        System.out.println("<<Loan TESTING>>");
//        System.out.println("Personal Loan Example");
//        PersonalLoan pl1 = new PersonalLoan(718, 2, 3);
//        System.out.println("your personal loan interest rate is " + pl1.setInterestRate() + "%, your term length is " + pl1.setTerm() + "months, your amount borrowed is " + pl1.setAmount());
//        System.out.println("Car Loan Example");
//        CarLoan cl1 = new CarLoan(615, 3, 2);
//        System.out.println("your car loan is for $" + cl1.setAmount() + " at an interest rate of " + cl1.setInterestRate() + "% for " + cl1.setTerm() + "months");
//        System.out.println("-------------------------------");
//      
//       
//        ////////////////////////////////////////////////////////////////////////////////////////////
//        ////// LOAN TRANSACTION TESTING ////////////////////////////////////////////////////////////
//        System.out.println("<<Loan Transation TESTING>>");
//        System.out.println("***Customer side of making a payment***");
//        System.out.println("The Loan Balance for Perosnal Loan 1 is " + pl1.setAmount());
//        
//        LoanTemplate loanTemplate = null;
//        //LoanTransaction lt = new LoanTransaction();
//        LoanTransaction lt = null;
//        lt = lt.getInstanceOfLoanTransaction();
//        lt.makePayment(pl1, 200.0);
//        System.out.println("Thank you for your $200 payment. Your new balance = " + pl1.getBalanceDue());
//        System.out.println(" ");
//
//        System.out.println("***Employee side of crediting an account***");
//       // System.out.println("The Initial Loan Balance for Car Loan 1 is " + pl1.setAmount());
//  
//
//        System.out.println("-------------------------------");
//
//        ////////////////////////////////////////////////////////////////////////////////////////////
//        ////// INCIDENT REPORT TESTING /////////////////////////////////////////////////////////////
//        // Default
//        IncidentReport incidentReport1 = new IncidentReport();
//        // user, string args
//        IncidentReport incidentReport2 = new IncidentReport(u1, "Ryan put Tdawg's stapler in a bowl of jello");
//
//        System.out.println("<<IncidentReport TESTING>>");
//        // set, get user
//        incidentReport1.setUser(u2);
//        System.out.println("Incident 1 User Information, through incident report object: " + incidentReport1.getUser().getFirstName());
//
//        // set, get message
//        incidentReport1.setMessage("Tdawg spilled coffee on Ryan's TPS report");
//        System.out.println("Incident Report 1 Message: " + incidentReport1.getMessage());
//
//        // printReport
//        System.out.print("Incident Report 2 Print: ");
//        incidentReport2.printReport();
//
//        // setMessage again, new report.
//        incidentReport2.setMessage("This is a new message...");
//        System.out.println("New message: " + incidentReport2.getMessage());
//
//        System.out.println("-------------------------------");
//        ////////////////////////////////////////////////////////////////////////////////////////////
//
//        
//        ////// LOAN OFFICER TESTING ////////////////////////////////////////////////////////////////
//        //LoanOfficer lo1 = new LoanOfficer(12345, "Ryan", "OHagan", "rjo2880", "test");
//        //lo1.setNumLoansActive(10);
//        ArrayList<LoanTemplate> historicalLoanTest = new ArrayList<>();
//        //PersonalLoan loanTest1 = new PersonalLoan(719, 1, 3);
//       // historicalLoanTest.add(loanTest1);
//        //lo1.setHistoricalLoans(historicalLoanTest);
//        //System.out.println("Performance Data " + lo1.getPerformanceMetrics());
//        //System.out.println("GetActiveLoans: " + lo1.getNumLoansActive());
//        //System.out.println("Get Historical Loans: " + lo1.getHistoricalLoans());
//        ////////////////////////////////////////////////////////////////////////////////////////////
//
//        ////// CREDIT QUERY TESTING ////////////////////////////////////////////////////////////////
//        CreditQuery cq2 = new CreditQuery();
//        int creditScore = cq2.getScore();
//        System.out.println("Credit score: " + creditScore);
//        ////////////////////////////////////////////////////////////////////////////////////////////
//        
//        ////// TECH SUPPORT TESTING ////////////////////////////////////////////////////////////////
//        //TechSupport ts1 = new TechSupport("Ryan", "OHagan", "rjo2880", "test");
//       // ArrayList<IncidentReport> testResults = ts1.searchErrorReports(u3);
//       // testResults.forEach((report) ->
//        //{
//        //    System.out.println("Name: " + report.getUser().getFirstName() + report.getUser().getLastName() +  " Message: " + report.getMessage());
//        //}); ////////////////////////////////////////////////////////////////////////////////////////////
//
//        ////// LOGIN CONTROLLER TESTING ////////////////////////////////////////////////////////////////
//        System.out.println("\n<<Login Controller TESTING>>");
//        //LoginController loginController = new LoginController(new LoginView());
//
//        System.out.println("Testing login with correct credentials...");
//        //System.out.println(loginController.login("", ""));
//        System.out.println("Testing login with incorrect credentials...");
//       // System.out.println(loginController.login("user", "pass"));
//
//        //launches the GUI
//        //loginController = new LoginController(args);
//        ////////////////////////////////////////////////////////////////////////////////////////////
//
//    }
//}
