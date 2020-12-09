/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author taren
 */
public class Loan extends LoanTemplate implements Serializable
{

    private int creditScore;
    private double interestRate;
    private double loanAmount;
    private int term_Length_In_Months;
    private String loanType;

    public Loan(int creditScore, double interestRate, double loanAmount, int term_Length_In_Months, String loan)
    {
        this.creditScore = creditScore;
        this.interestRate = interestRate;
        this.loanAmount = loanAmount;
        this.term_Length_In_Months = term_Length_In_Months;
        this.loanType = loan;
    }

    public Loan()
    {
        Random rand = new Random();
        setLoanID(rand.nextInt(10000));
        System.out.println("LoanID set to "+getLoanID());
    }
    
    

    @Override
    public void setInterestRate(double rate)
    {
        if (creditScore >= 0 || creditScore <= 589)
        {
            this.interestRate = 15.24;
        } else if (creditScore >= 590 || creditScore <= 619)
        {
            this.interestRate = 14.08;
        } else if (creditScore >= 620 || creditScore <= 659)
        {
            this.interestRate = 9.72;
        } else if (creditScore >= 660 || creditScore <= 689)
        {
            this.interestRate = 7.02;
        } else if (creditScore >= 690 || creditScore <= 719)
        {
            this.interestRate = 4.95;
        } else if (creditScore >= 720)
        {
            this.interestRate = 3.60;
        }
    }

    @Override
    public void setTerm(int TermLengthOption)
    {
        switch (TermLengthOption) {
            case 1:
                this.term_Length_In_Months = 36;
            case 2:
                this.term_Length_In_Months = 48;
            case 3:
                this.term_Length_In_Months = 60;
            case 4:
                this.term_Length_In_Months = 72;
            case 5:
                this.term_Length_In_Months = 84;
            case 6:
                this.term_Length_In_Months = 96;
            case 7:
                this.term_Length_In_Months = 108;
            case 8:
                this.term_Length_In_Months = 120;
            default:
                break;
        }
        
    }

    @Override
    public void setAmount(int loanAmountOption)
    {
        switch (loanAmountOption) {
            case 1:
                this.loanAmount = 5000;
            case 2:
                this.loanAmount =  10000;
            case 3:
                this.loanAmount =  15000;
            case 4:
                this.loanAmount =  20000;
            case 5:
                this.loanAmount =  25000;
            case 6:
                this.loanAmount =  30000;
            case 7:
                this.loanAmount =  35000;
            case 8:
                this.loanAmount =  40000;
            case 9:
                this.loanAmount =  45000;
            case 10:
                this.loanAmount =  50000;
            case 11:
                this.loanAmount =  55000;
            case 12:
                this.loanAmount =  60000;
            default:
                break;
        }
    }

    @Override
    public void setBalanceDue(double balance)
    {
        this.balanceDue = balance;
    }
    
    public void setLoanType(String type)
    {
        this.loanType = type;
    }
    

    @Override
    public double getInterestRate()
    {
        return interestRate;
    }

    @Override
    public int getTerm()
    {
        return term_Length_In_Months;
    }

    @Override
    public double getAmount()
    {
        return loanAmount;
    }

    @Override
    public double getBalanceDue()
    {
        return balanceDue;
    }
    
     @Override
    public String getLoanType()
    {
        return loanType.toString();
    }

}
