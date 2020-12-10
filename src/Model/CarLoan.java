package Model;


/**
 *
 * A class that holds holds the specifications for a car loan.
 */
public class CarLoan extends Loan {

    public CarLoan(int creditScore, double interestRate, double loanAmount, int term_Length_In_Months, String loan)
    {
        super (creditScore, interestRate, loanAmount, term_Length_In_Months, loan);
    }

}
