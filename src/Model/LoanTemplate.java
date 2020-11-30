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
        setInterestRate(rate);
        setTerm();
        setAmount();
    }
    
    public abstract void setInterestRate(double rate);
    public abstract int setTerm();
    public abstract double setAmount();
    public abstract void setBalanceDue(double n);
}
