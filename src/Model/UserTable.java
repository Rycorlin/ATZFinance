/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.list;

import java.util.HashSet;
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

    private static ArrayList<User> userList = new ArrayList<>();
    //so we can check if username is taken using O(1) instead of O(n)
    private static HashSet<String> usernameSet = new HashSet<>();

    public static void addUser(User user) {
        userList.add(user);
        usernameSet.add(user.getUserName());

        //update stored data
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("users.ser"));
            ous.writeObject(userList);
            ous = new ObjectOutputStream(new FileOutputStream("usernames.ser"));
            ous.writeObject(usernameSet);
            ous.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(int i) { return userList.get(i); }

    public static int getSize() { return userList.size(); }

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

    public static ArrayList<User> getUserList() { return userList; }
    
    public static ArrayList<User> getUsers() { return userList; }

    public static void setUserList(ArrayList<User> userList) { UserTable.userList = userList; }

    public static void setUsernameSet(HashSet<String> usernameSet) { UserTable.usernameSet = usernameSet; }

    public static HashSet<String> getUsernameSet() { return usernameSet; }
    
    public static ArrayList<String> getUsernames() 
    { 
      ArrayList<String> userArray = new ArrayList<>();
      for (User user: userList){
          String temp = user.getFirstName() + " "+ user.getLastName() + " (" + user.getUserName() + ")";
          
          userArray.add(temp);
      }
      return userArray;
     }
}
