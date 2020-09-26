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

    private long interest_Rate;
    private int term_Length_In_Months;
    private double balance_due;


    /**
     * This is the default constructor for the Loan class
     */
    public Loan() {

    }

    /**
     * @param balance Sets the balance due for the customer
     *
     */
    public void setBalanceDue(double balance) {
        this.balance_due = balance;
    }

    /**
     * @return A double representing the balance due for the customer
     */
    public double getBalanceDue() {
        return balance_due;
    }

    /**
     * @return A long representing the interest rate for a customer
     */
    public long getInterest_Rate() {
        return interest_Rate;
    }

    /**
     * @param interest_Rate Sets the interest rate for a customer
     */
    public void setInterest_Rate(long interest_Rate) {
        this.interest_Rate = interest_Rate;
    }

    /**
     * @return An integer representing the length of the loan, in months, for a
     * users loan
     */
    public int getTerm_Length_In_Months() {
        return term_Length_In_Months;
    }

    /**
     * @param term_Length_In_Months Sets the length, in months, of the users
     * loan
     */
    public void setTerm_Length_In_Months(int term_Length_In_Months) {
        this.term_Length_In_Months = term_Length_In_Months;
    }

}
