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

    private LoginView loginView;
    private CreateAccountView createAccountView;
    private Stage stage;
    private UserTable uTable;

    public CreateAccountController(CreateAccountView createAccountView, Stage stage, UserTable uTable) {
        this.createAccountView = createAccountView;
        this.stage = stage;
        this.uTable = uTable;
        setup();
    }

    public void setup() {
        //Action on click "Create Account" for new account sends to LoginController
        createAccountView.register.setOnAction((ActionEvent event) -> {
            if(passwordCheck()) {

                User newUser = new User(createAccountView.getFirstName(), createAccountView.getLastName(), createAccountView.getUsername(),
                        createAccountView.getPassword());

                uTable.addUser(newUser);

                //System.out.println(newUser.getFirstName());
                //System.out.println(newUser.getLastName());
                //System.out.println(newUser.getUserName());
                //this.login(uTable.getUser(0).getUserName(), uTable.getUser(0).getPassword(), primaryStage); //Do we setup auto login after register or send them to LoginView to login
                // hv = new HomeView(primaryStage);
                new HomeView(stage);
            } else {
            }
        });
    }

    private boolean passwordCheck() {
        String p1 = createAccountView.getPassword();
        String p2 = createAccountView.getConfirmPassword();

        if(p1 == null || p2 == null) {
            return false;
        }

        if(!p1.equals(p2)) {
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

}


