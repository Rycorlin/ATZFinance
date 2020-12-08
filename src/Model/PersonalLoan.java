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

    public PersonalLoan(int creditScore, double interestRate, double loanAmount, int term_Length_In_Months, Loan loan)
    {
        super(creditScore, interestRate, loanAmount, term_Length_In_Months, loan);
    }
   
}
