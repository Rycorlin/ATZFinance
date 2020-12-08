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
    private double amount;
    private String loanType;
    
    
    public final void buildLoan(double rate) {
        setInterestRate(rate);
        setTerm(12);
        setAmount(1000.00);
    }
    
    public void setInterestRate(double rate)
    {
        interestRate = rate;
    }
    
    public void setTerm(int newTerm)
    {
        term = newTerm;
    }
    
    public void setAmount(double newAmt)
    {
        amount = newAmt;
    }
    
    public void setBalanceDue(double n)
    {
        balanceDue = n;
    }
    
    public double getInterestRate()
    {
        return interestRate;
    }
    
    public int getTerm()
    {
        return term;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    public double getBalanceDue()
    {
        return balanceDue;
    }
    
    public abstract String loanType();
            
}
