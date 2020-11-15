package Controller;

import Model.User;
import Model.UserTable;
import View.CreateAccountView;
import View.HomeView;
import View.LoginView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.util.regex.*;

public class CreateAccountController {

    private CreateAccountView createAccountView;
    private Stage stage;

    public CreateAccountController(CreateAccountView createAccountView, Stage stage) {
        this.createAccountView = createAccountView;
        this.stage = stage;
        setup();
    }

    public void setup() {
        //Action on click "Create Account" for new account sends to LoginController
        createAccountView.register.setOnAction((ActionEvent event) -> {
            if (validUsername() && validPassword() && validNames()) {
                User newUser = new User(createAccountView.getFirstName(), createAccountView.getLastName(), createAccountView.getUsername(),
                        createAccountView.getPassword());
                UserTable.addUser(newUser);

                new HomeView(stage);
            }
        });
    }

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


