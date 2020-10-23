/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atzfinance;

/**
 *
 * @author xxani
 */
public class carLoan extends LoanTemplate
{

    private double balance_due;

    public carLoan(int creditScore, int TermLengthOption, int loanAmountOption)
    {
        this.creditScore = creditScore;
        this.TermLengthOption = TermLengthOption;
        this.loanAmountOption = loanAmountOption;
    }
    private int creditScore;
    private int TermLengthOption;
    private int loanAmountOption;
    private double interestRate;
    private int term_Length_In_Months;
  

    public double getInterestRate(int creditScore)
    {
        if (creditScore >= 0 || creditScore <= 589)
        {
            return 15.24;
        } else if (creditScore >= 590 || creditScore <= 619)
        {
            return 14.08;
        } else if (creditScore >= 620 || creditScore <= 659)
        {
            return 9.72;
        } else if (creditScore >= 660 || creditScore <= 689)
        {
            return 7.02;
        } else if (creditScore >= 690 || creditScore <= 719)
        {
            return 4.95;
        } else if (creditScore >= 720)
        {
            return 3.60;
        }
        return 0;
    }

    public int getTerm(int TermLengthOption)
    {
        switch (TermLengthOption)
        {
            case 1:
                return 36;
            case 2:
                return 48;
            case 3:
                return 60;
            case 4:
                return 72;
            case 5:
                return 84;
            case 6:
                return 96;
            case 7:
                return 108;
            case 8:
                return 120;
            default:
                break;
        }
        return 0;
    }

    public double getAmount(int loanAmountOption)
    {
        switch (loanAmountOption)
        {
            case 1:
                return 5000;
            case 2:
                return 10000;
            case 3:
                return 15000;
            case 4:
                return 20000;
            case 5:
                return 25000;
            case 6:
                return 30000;
            case 7:
                return 35000;
            case 8:
                return 40000;
            case 9:
                return 45000;
            case 10:
                return 50000;
            case 11:
                return 55000;
            case 12:
                return 60000;
            default:
                break;
        }
        return 0;
    }

    @Override
    public double setInterestRate()
    {
        return getInterestRate(creditScore);
    }

    @Override
    public int setTerm()
    {
        return getTerm(TermLengthOption);
    }

    @Override
    public double setAmount()
    {
        return getAmount(loanAmountOption);
    }

    public int getCreditScore()
    {
        return creditScore;
    }

    public void setCreditScore(int creditScore)
    {
        this.creditScore = creditScore;
    }

    public int getTermLengthOption()
    {
        return TermLengthOption;
    }

    public void setTermLengthOption(int TermLengthOption)
    {
        this.TermLengthOption = TermLengthOption;
    }

    public int getLoanAmountOption()
    {
        return loanAmountOption;
    }

    public void setLoanAmountOption(int loanAmountOption)
    {
        this.loanAmountOption = loanAmountOption;
    }

    public double getInterestRate()
    {
        return interestRate;
    }

    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }

    public int getTerm_Length_In_Months()
    {
        return term_Length_In_Months;
    }

    public void setTerm_Length_In_Months(int term_Length_In_Months)
    {
        this.term_Length_In_Months = term_Length_In_Months;
    }

    public double getBalanceDue()
    {
        return balance_due;
    }

     public void setBalanceDue(double balance) {
       balance_due = balance;
    }

  
}
