/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atzfinance;

/**
 *
 * A class containing information about user loans
 *
 */
public class Loan {

    private double interest_Rate;
    private int term_Length_In_Months;
    private final double balance_due;
    
    /**
     * This is the default constructor for the Loan class
     * @param rate takes argument interest rate of type long.
     * @param termLength takes loan term length of type int.
     * @param balance takes loan balance of type double.
     */
    public Loan(double rate, int termLength, double balance) {
        this.interest_Rate = rate;
        this.term_Length_In_Months = termLength;
        this.balance_due = balance;
    }

    /**
     * This is an immutable class.
     * @param balance Sets the balance due for the customer
     * @return newLoan returns object of Loan type, immutable class.
     *
     */
    public synchronized Loan setBalanceDue(double balance) {
        return new Loan(this.interest_Rate, this.term_Length_In_Months, balance);
    }

    /**
     * @return A double representing the balance due for the customer
     */
    public double getBalanceDue() {
        return balance_due;
    }

    /**
     * @param interest_Rate Sets the interest rate for a customer
     */
    public void setInterest_Rate(double interest_Rate) {
        this.interest_Rate = interest_Rate;
    }
    
    /**
     * @return A long representing the interest rate for a customer
     */
    public double getInterest_Rate() {
        return interest_Rate;
    }

    /**
     * @param term_Length_In_Months Sets the length, in months, of the users
     * loan
     */
    public void setTerm_Length_In_Months(int term_Length_In_Months) {
        this.term_Length_In_Months = term_Length_In_Months;
    }
    /**
     * @return An integer representing the length of the loan, in months, for a
     * users loan
     */
    public int getTerm_Length_In_Months() {
        return term_Length_In_Months;
    }

}
