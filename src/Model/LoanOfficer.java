/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * A subclass of user, this contains employee information which includes all
 * standard user information, as well as permissions and employee ID.
 *
 */
public class LoanOfficer extends User {

    private int employeeID;
    private int numLoansActive;
    private ArrayList<LoanTemplate> historicalLoans = new ArrayList<>();

    /**
     *
     * @param employeeID Employee ID for the loan officer
     * @param fName First name of the loan officer
     * @param lName Last name of the loan officer
     * @param userName
     * @param socialSecurity
     *
     */
    public LoanOfficer(int employeeID, String fName, String lName, String userName, Integer socialSecurity) {
        super(fName, lName, userName, socialSecurity);
        this.employeeID = employeeID;
    }

    /*
    /**
     * @return a string denoting the current yearly performance of the employee
     * @param numLoansActive will be used to show their currently active loans
     * @param historicalLoans will show loans that have been paid in full under their directive
     * @param employeeID will be used for export purposes so that it can be filed properly
     */
    public String getPerformanceMetrics() {
        String performanceData = "Performance data for EMPL ID: " + employeeID + "/# of Active Loans: " + numLoansActive + "/# of Historical Loans: " + historicalLoans.size();
        return performanceData;
    }

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the numLoansActive
     */
    public int getNumLoansActive() {
        return numLoansActive;
    }

    /**
     * @param numLoansActive the numLoansActive to set
     */
    public void setNumLoansActive(int numLoansActive) {
        this.numLoansActive = numLoansActive;
    }

    /**
     * @return the historicalLoans
     */
    public ArrayList<LoanTemplate> getHistoricalLoans() {
        return historicalLoans;
    }

    /**
     * @param historicalLoans the historicalLoans to set
     */
    public void setHistoricalLoans(ArrayList<LoanTemplate> historicalLoans) {
        this.historicalLoans = historicalLoans;
    }

}
