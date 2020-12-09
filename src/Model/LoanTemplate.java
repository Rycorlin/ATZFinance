/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author xxani
 */

//this template was designed to give standardization to loan types
public abstract class LoanTemplate implements Serializable {
    
    protected double balanceDue;
    private double interestRate;
    private int term;
    
    
    public final void buildLoan(double rate) {
        getInterestRate();
        getTerm();
        getAmount();
    }
    
    public abstract void setInterestRate(double rate);
    public abstract void setTerm(int TermLengthOption);
    public abstract void setAmount(int loanAmountOption);
    public abstract void setBalanceDue(double n);
    public abstract void setLoanType(String type);
    
    public abstract double getInterestRate();
    public abstract int getTerm();
    public abstract double getAmount();
    public abstract double getBalanceDue();
    public abstract String getLoanType();


}
