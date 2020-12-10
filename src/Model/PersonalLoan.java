package Model;


/**
 *
 * A class that holds holds the specifications for a personal loan.
 */


public class PersonalLoan extends Loan {

    public PersonalLoan(int creditScore, double interestRate, double loanAmount, int term_Length_In_Months, String loan)
    {
        super(creditScore, interestRate, loanAmount, term_Length_In_Months, loan);
    }
   
}
