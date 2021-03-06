package Model;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * A class that defines a loan.
 */


public class Loan extends LoanTemplate implements Serializable
{
    private int creditScore;
    private double interestRate;
    private double loanAmount;
    private int term_Length_In_Months;
    private String loanType;
    
    /**
     *
     * @param creditScore credit score of the user
     * @param interestRate interest rate of the loan
     * @param loanAmount the amount of the loan
     * @param term_Length_In_Months the length of the loan in months
     * @param loanType the type of loan
     */

    
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

    // utilizes a user's credit score to determine the interest rate for their loan
    @Override
    public void setInterestRateAuto()
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

    //defines the length of time the user will be paying off his loan
    @Override
    public void setTermLengthInMonths(int term)
    {
        switch (term) {
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

    
    // this method sets the amount the loan will be opened for
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

    // this method will set the amount the user owes
    @Override
    public void setBalanceDue(double balance)
    {
        this.balanceDue = balance;
    }
    
    // this method defines the type of loan the user has
    
    @Override
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
        return loanType;
    }

    @Override
    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

}
