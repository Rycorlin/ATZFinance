package Controller;

import Model.User;
import Model.UserTable;
import View.CreateAccountView;
import View.HomeView;
import View.LoginView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

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

            User newUser = new User(createAccountView.getFirstName(), createAccountView.getLastName(), createAccountView.getUsername(),
                    createAccountView.getPassword());

            uTable.addUser(newUser);

            System.out.println(uTable.getUser(0).getFirstName());
            System.out.println(uTable.getSize());

            //System.out.println(newUser.getFirstName());
            //System.out.println(newUser.getLastName());
            //System.out.println(newUser.getUserName());
            //this.login(uTable.getUser(0).getUserName(), uTable.getUser(0).getPassword(), primaryStage); //Do we setup auto login after register or send them to LoginView to login
           // hv = new HomeView(primaryStage);
            new HomeView(stage);
        });
    }

}


