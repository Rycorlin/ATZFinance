/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LoanTransaction;
import Model.User;
import View.LoanTransactionView;
import javafx.stage.Stage;

/**
 *
 * @author taren
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
