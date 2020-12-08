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

//This class holds the specifications for a personal loan
public class PersonalLoan extends Loan {

    private int creditScore;
    private int TermLengthOption;
    private int loanAmountOption;
    private double interestRate;
    private int term_Length_In_Months;
    private double balance_due;

    public PersonalLoan(int creditScore, int TermLengthOption, int loanAmountOption) {
        this.creditScore = creditScore;
        this.TermLengthOption = TermLengthOption;
        this.loanAmountOption = loanAmountOption;
    }
    
    @Override
    public String loanType()
    {
        return "Personal Loan";
    }

    public double getInterestRate(int creditScore) {
        if (creditScore >= 0 || creditScore <= 629) {
            return 32;
        } else if (creditScore >= 630 || creditScore <= 689) {
            return 19.9;
        } else if (creditScore >= 690 || creditScore <= 719) {
            return 15.5;
        } else if (creditScore >= 720) {
            return 12.5;
        }
        return 0;
    }

    public int getTerm(int TermLengthOption) {
        switch (TermLengthOption) {
            case 1:
                return 12;
            case 2:
                return 36;
            case 3:
                return 60;
            case 4:
                return 72;
            case 5:
                return 96;
            case 6:
                return 120;
            case 7:
                return 180;
            default:
                break;
        }
        return 0;
    }

    public double getAmount(int loanAmountOption) {
        switch (loanAmountOption) {
            case 1:
                return 500;
            case 2:
                return 1000;
            case 3:
                return 2000;
            case 4:
                return 3000;
            case 5:
                return 5000;
            case 6:
                return 10000;
            case 7:
                return 15000;
            case 8:
                return 20000;
            default:
                break;
        }
        return 0;
    }

    public double setInterestRate()
    {
        return getInterestRate(creditScore);
    }

    @Override  
    public int getTerm()
    {
        return getTerm(TermLengthOption);
    }

    @Override
    public double getAmount()
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

    @Override
    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }

    public int getTermLengthInMonths()
    {
        return term_Length_In_Months;
    }

    public void setTermLengthInMonths(int term_Length_In_Months) {
        this.term_Length_In_Months = term_Length_In_Months;
    }

    public double getBalanceDue()
    {
        return balance_due;
    }

    @Override
    public void setBalanceDue(double balance) {
       balance_due = balance;
    }
}
