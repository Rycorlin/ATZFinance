/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author rycor
 */
public class UserTable {

    private static Map<String, User> userMap = new HashMap<>();

    public static void addUser(User user) {
        userMap.put(user.getUserName(), user);

        //update stored data
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("users.ser"));
            ous.writeObject(userMap);
            ous.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getSize() { return userMap.size(); }

    // Returns an observable list of persons
    public static ObservableList<User> getPersonList() {
        return FXCollections.<User>observableArrayList(new ArrayList<>(getUserMap().values()));
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

    public static Map<String, User> getUserMap() {
        return userMap;
    }

    public static void setUserMap(Map<String, User> userMap) {
        UserTable.userMap = userMap;
    }
}
