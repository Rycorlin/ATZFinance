/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author xxani
 */
public abstract class LoanTemplate {

    public final void buildLoan() {
        setInterestRate();
        setTerm();
        setAmount();
    }
    
    public abstract double setInterestRate();
    public abstract int setTerm();
    public abstract double setAmount();
    public abstract void setBalanceDue(double n);
}
