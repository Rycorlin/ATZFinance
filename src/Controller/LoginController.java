package Controller;

import View.CreateAccountView;
import View.HomeView;
import View.LoginView;
import Model.Customer;
import Model.User;
import Model.UserTable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController {

    private String user = "";
    private String pw = "";
    private LoginView loginView;
    private HomeView hv;
    private CreateAccountView newAccount;
    private UserTable uTable = new UserTable();
    Stage stage;
    ArrayList<User> al = new ArrayList();

    public LoginController(String[] args) {

        Application.launch(LoginView.class, args);
    }

    public LoginController(LoginView loginView, Stage stage) {
        this.loginView = loginView;
        this.stage = stage;
    }

    public boolean login(String username, String password, Stage primaryStage) {
        if (username.equalsIgnoreCase(user) && password.equals(pw)) {
            loginView.getLblMessage().setTextFill(Color.GREEN);
            hv = new HomeView(primaryStage);
            return true;
        } else {
            loginView.getLblMessage().setText("Incorrect user or pw.");
            loginView.getLblMessage().setTextFill(Color.RED);
        }
        loginView.getTxtUserName().setText("");
        loginView.getPf().setText("");
        return false;
    }

    public boolean login(String username, String password) {
        return username.equalsIgnoreCase(user) && password.equals(pw);
    }
    
    
    //Done in HomeView atm because cant get button to work from here - RM
   /* public void logoff()
    {
       
       
       hv.logoutButton.setOnAction((ActionEvent event) ->
       {
           System.out.println("Hey");
           loginView.start(stage);
           
           
           
       });
        
    }*/

    //From loginview open up new CreateAccountView UI when creating new account
    public void createAcount(Stage primaryStage) throws Exception {
        newAccount = new CreateAccountView();
        newAccount.start(primaryStage);

        //Action on click "Create Account" for new account sends to LoginController
        newAccount.register.setOnAction((ActionEvent event) -> {

            User newUser = new User(newAccount.getFirstName(), newAccount.getLastName(), newAccount.getUsername(), 10);

            uTable.addUser(newUser);

            System.out.println(uTable.getUser(0).getFirstName());
            System.out.println(uTable.getSize());

            //System.out.println(newUser.getFirstName());
            //System.out.println(newUser.getLastName());
            //System.out.println(newUser.getUserName());
            this.login(user, user, primaryStage); //Do we setup auto login after register or send them to LoginView to login

        });

    }

}
