package Controller;

import Model.LoanApplication;
import View.CreateAccountView;
import View.HomeView;
import View.LoginView;
import Model.Customer;
import Model.User;
import Model.UserTable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController {

    private String user = "";
    private String pw = "";
    private LoginView loginView;
    private HomeView hv;
    private CreateAccountView newAccount;
    private Stage stage;

    //Launches the LoginView view
    public LoginController(String[] args) {
        Application.launch(LoginView.class, args);
    }
    
    //Accepts a view and a stage for LoginController
    public LoginController(LoginView loginView, Stage stage) {
        this.loginView = loginView;
        this.stage = stage;

        //read users from save and update UserTable
        try {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("users.ser"));
            UserTable.setUserList((ArrayList<User>)oin.readObject());
            oin = new ObjectInputStream(new FileInputStream("usernames.ser"));
            UserTable.setUsernameSet((HashSet<String>)oin.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //The method for a user logging in with credentials 
    public boolean login(String username, String password, Stage primaryStage) {
        //Error if no users exist
        if (UserTable.getSize() < 1) {
            loginView.getLblMessage().setText("Incorrect user or pw.");
            loginView.getLblMessage().setTextFill(Color.RED);
        }

        for(User user : UserTable.getUsers()) {
            if (user.getUserName().equalsIgnoreCase(loginView.getCheckUser()) && user.getPassword().equals(loginView.getCheckPw())) {
                loginView.getLblMessage().setTextFill(Color.GREEN);
                hv = new HomeView(primaryStage);

                return true;
            } else {
                loginView.getLblMessage().setText("Incorrect user or pw.");
                loginView.getLblMessage().setTextFill(Color.RED);
            }
        }

        loginView.getTxtUserName().setText("");
        loginView.getPf().setText("");
        return false;
    }

    public boolean login(String username, String password) {
        return username.equalsIgnoreCase(user) && password.equals(pw);
    }

    
    //From loginview open up new CreateAccountView UI when creating new account
    public void createAccount(Stage primaryStage) throws Exception {
        newAccount = new CreateAccountView();
        newAccount.start(primaryStage);
    }
}
