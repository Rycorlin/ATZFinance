package Controller;

import Model.Loan;
import Model.User;
import Model.UserTable;
import View.CreateAccountView;
import View.HomeView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.util.regex.*;

/**
 *
 * Controller for the CreateAccountView.  Takes information from that view and adds loans to user
 */

public class CreateAccountController {

    private CreateAccountView createAccountView;
    private Stage stage;

    public CreateAccountController(CreateAccountView createAccountView, Stage stage) {
        this.createAccountView = createAccountView;
        this.stage = stage;
        setup();
    }

    //This is where the user is set up when "Create Account" is clicked. Currently 3 loans are automatically generated for all users as a proof of concept.
    public void setup() {
        createAccountView.register.setOnAction((ActionEvent event) -> {
            if (validUsername() && validPassword() && validNames()) {
                
                // Set some default loans for the purpose of displaying the project.
                Loan loan1 = new Loan();
                loan1.setBalanceDue(1000);
                loan1.setInterestRate(5.5);
                loan1.setTermLengthInMonths(4);
                
                Loan loan2 = new Loan();
                loan2.setBalanceDue(2000);
                loan2.setInterestRate(2.9);
                loan1.setTermLengthInMonths(8);
                
                Loan loan3 = new Loan();
                loan3.setBalanceDue(3000);
                loan3.setInterestRate(8.1);
                loan1.setTermLengthInMonths(1);
                
                User newUser = new User(createAccountView.getFirstName(), createAccountView.getLastName(), createAccountView.getUsername(),
                        createAccountView.getPassword(), loan1);
                newUser.addLoanToUser(loan2);
                newUser.addLoanToUser(loan3);
                
                loan1.setLoanType("Personal");
                loan2.setLoanType("Car");
                loan3.setLoanType("Personal");
                
                UserTable.addUser(newUser);
                
                new HomeView(stage, newUser);
            }
        });
    }

    //Determines if the password meets the standards given.
    private boolean validPassword() {
        String p1 = createAccountView.getPassword();
        String p2 = createAccountView.getConfirmPassword();

        //make sure the user has entered something in the text fields
        if (p1 == null || p2 == null) {
            return false;
        }

        //passwords do not match
        if (!p1.equals(p2)) {
            createAccountView.passwordMatchError.setVisible(true);
            return false;
        }

        createAccountView.passwordMatchError.setVisible(false);

        // Regex for 1+ digit, 1+ lowercase, 1+ uppercase, no spaces, 8-50 characters
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,50}$";

        //compiles regex pattern and checks if password matches it
        if(!Pattern.compile(regex).matcher(p1).matches()) {
            createAccountView.passwordSecurityError.setVisible(true);
            return false;
        }

        return true;
    }

    //checks the stored HashSet of usernames to see if it is available
    private boolean validUsername() {
        if (UserTable.getUsernameSet().contains(createAccountView.getUsername())) {
            createAccountView.usernameError.setVisible(true);
            return false;
        }
        createAccountView.usernameError.setVisible(false);
        return true;
    }
    
    //Checks to make sure that first and last name are not already taken.
    private boolean validNames() {
        String fn = createAccountView.getFirstName();
        String ln = createAccountView.getLastName();

        if (fn == null || ln == null) {
            return false;
        }

        Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p.matcher(fn);
        Matcher m2 = p.matcher(ln);
        boolean b1 = m1.find();
        boolean b2 = m2.find();

        if (b1)
        {
        createAccountView.nameNumberError.setVisible(true);
        return false;
        }
        
        if (b2)
        {
        createAccountView.nameNumberError.setVisible(true);
        return false;
        }
        return true;
    }

}