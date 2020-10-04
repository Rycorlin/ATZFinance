/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atzfinance;

/**
 *
 * A class that handles loan transactions
 */
public class LoanTransaction {

    Loan loan;

    public LoanTransaction(Loan loan) {
        this.loan = loan;

    }
    public LoanTransaction() {
        

    }
    
    //TODO: Write a Loan type check function to check type of loan received as
    // argument and initialize loan object to that type, proceed with below 
    // functions as normal depending on this loan type.
    /**
     * This function makes a payment on the loan
     *
     * @param loan is the loan we are making a payment on.
     * @param payment is the amount being paid on the loan.
     */
    public void makePayment(Loan loan, double payment) {
        double tempBalance = loan.getBalanceDue();
        loan.setBalanceDue(tempBalance - payment);
    }

    /**
     * This function credits the Loan with an amount of money.
     *
     * @param loan is the loan we are crediting.
     * @param credit is the amount credited to the account.
     */
    public void creditAccount(Loan loan, double credit) {
        double tempBalance = loan.getBalanceDue();
        loan.setBalanceDue(tempBalance - credit);
    }
}
