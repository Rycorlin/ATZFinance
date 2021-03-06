package Controller;

import View.CreateAccountView;
import View.HomeView;
import View.LoginView;
import Model.User;
import Model.UserTable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * Controller for the LoginView.  Takes information from LoginView and passes it to User and UserList
 */

public class LoginController {

    private String userName = "";
    private String pw = "";
    private LoginView loginView;
    private HomeView hv;
    private CreateAccountView newAccount;
    private Stage stage;
    private User user;

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
                hv = new HomeView(primaryStage, user);
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
        return username.equalsIgnoreCase(userName) && password.equals(pw);
    }

    
    //From loginview open up new CreateAccountView UI when creating new account
    public void createAccount(Stage primaryStage) throws Exception {
        newAccount = new CreateAccountView();
        newAccount.start(primaryStage);
    }
}