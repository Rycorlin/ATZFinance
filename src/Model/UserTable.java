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
    private ArrayList<User> userList;
    
    public UserTable()
    {
        userList = new ArrayList<User>();
    }
    
    public void addUser(User user)
    {
        userList.add(user);
    }
    
    public User getUser(int i)
    {
        return userList.get(i);
    }
    
    public int getSize()
    {
        return userList.size();
    }
   
    // Returns an observable list of persons
    public static ObservableList<User> getPersonList() { 
        
 
        Customer u0 = new Customer("Ryan", "Milici", "Myliu", 12312412, false);
        Customer u1 = new Customer("Ted", "Tedson", "Tdawg", 223412, true);
        Customer u2 = new Customer("John", "Johnson", "Jman", 00123, false);
        Customer u3 = new Customer("Rick", "Roll", "MrLate", 2232114, true);

        ArrayList<Customer> customerList = new ArrayList<>();

        ArrayList<Customer> lateCustomers = new ArrayList<>();
        

        customerList.add(u0);
        customerList.add(u1);
        customerList.add(u2);
        customerList.add(u3);

        for (Customer u : customerList) {
            if (u.isLatePayment() == true) {
                lateCustomers.add(u);
            }
        }

        Iterator<Customer> iter = lateCustomers.iterator();

        while (iter.hasNext()) {
            Customer element = iter.next();
            System.out.println(element.getFirstName() + " " + element.getLastName() + " -- Late!!");
        }
        System.out.println();

        lateCustomers.addAll(FXCollections.observableArrayList());
        
        //return userList.addAll(FXCollections.observableArrayList());
        return FXCollections.<User>observableArrayList(u0, u1, u2, u3);
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

}
