package atzfinance;

import java.util.ArrayList;

/**
 *
 * Contains customers that may have active loans
 */
public class Customer {

    private int customerID;
    private int numLoansActive;
    private ArrayList<LoanTemplate> activeLoanArray = new ArrayList<>();
    private int creditScore;

    /**
     * Returns the customer ID
     *
     * @return A integer representing the customer ID
     */
    public int getcustomerID() {
        return customerID;
    }

    /**
     * Sets the customer ID
     *
     * @param newID Sets the identification number for the customer
     */
    public void setcustomerID(int newID) {
        customerID = newID;
    }

    /**
     * Returns the active number of loans
     *
     * @return Returns an integer with the number of active loans
     */
    public int getNumLoansActive() {
        return numLoansActive;
    }

    /**
     * Sets the number of active loans for a customer
     *
     * @param newLoanNum Sets the total number of active loans for a customer
     */
    public void setNumLoansActive(int newLoanNum) {
        numLoansActive = newLoanNum;
    }

    public ArrayList<LoanTemplate> getActiveLoanArray() {
        return activeLoanArray;
    }

    public void setActiveLoanArray(ArrayList<LoanTemplate> loanArray) {
        activeLoanArray = loanArray;
    }

    /**
     * Returns the credit score of a customer
     *
     * @return Returns an integer with the credit score of a customer
     */
    public int getCreditScore() {
        return creditScore;
    }

    /**
     * Sets the credit score of a customer
     *
     * @param newCreditScore Sets the credit score for a customer
     */
    public void setCreditScore(int newCreditScore) {
        creditScore = newCreditScore;
    }
}
