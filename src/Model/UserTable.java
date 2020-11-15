/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author rycor
 */
public class UserTable {

    private static ArrayList<User> userList = new ArrayList<User>();

    public  UserTable() {
        //userList = new ArrayList<User>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(int i) {
        return userList.get(i);
    }

    public int getSize() {
        return userList.size();
    }

    // Returns an observable list of persons
    public static ObservableList<User> getPersonList() {

        //return userList.addAll(FXCollections.observableArrayList());
        return FXCollections.<User>observableArrayList(getUserList());
    }

    // Returns User First Name TableColumn
    public static TableColumn<User, String> getFirstNameColumn() {
        TableColumn<User, String> fNameCol = new TableColumn<>("First name");
        PropertyValueFactory<User, String> fNameCellValueFactory = new PropertyValueFactory<>("firstName");
        fNameCol.setCellValueFactory(fNameCellValueFactory);
        return fNameCol;
    }
    // Returns Last Name TableColumn

    public static TableColumn<User, String> getLastNameColumn() {
        TableColumn<User, String> lastNameCol = new TableColumn<>("Last name");
        PropertyValueFactory<User, String> lastNameCellValueFactory = new PropertyValueFactory<>("lastName");
        lastNameCol.setCellValueFactory(lastNameCellValueFactory);
        return lastNameCol;
    }

    // Returns user name column
    public static TableColumn<User, String> getUserNameColumn() {
        TableColumn<User, String> userNameColumn = new TableColumn<>("User name");
        PropertyValueFactory<User, String> userNameCellValueFactory = new PropertyValueFactory<>("userName");
        userNameColumn.setCellValueFactory(userNameCellValueFactory);
        return userNameColumn;
    }

    // Returns social security TableColumn
    public static TableColumn<User, Integer> getSocialSecurityColumn() {
        TableColumn<User, Integer> socialCol = new TableColumn<>("Social security number");
        PropertyValueFactory<User, Integer> socialCellValueFactory = new PropertyValueFactory<>("socialSecurityNumber");
        socialCol.setCellValueFactory(socialCellValueFactory);
        return socialCol;
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }
    
    public ArrayList<User> getUsers()
    {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
    

}
