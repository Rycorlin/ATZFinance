
package Controller;

import Model.LoanTransaction;
import Model.User;
import View.LoanTransactionView;
import javafx.stage.Stage;

/**
 *
 * class designated for handling the loan transactions.
 */
public class LoanTransactionController {
    
    User user;
    LoanTransactionView loanTransactionView;
    Stage primaryStage;
    LoanTransaction loanTransaction;
    
    public LoanTransactionController(LoanTransactionView view, Stage stage, User u){
        
        this.loanTransactionView = view;
        this.primaryStage = stage;
        this.user = u;
        
        
    }
    
    
    private void payLoan(){
        
        // Pay loan associated with this instance of user pased to the loan transaction class.
        
        
    }
    
}
