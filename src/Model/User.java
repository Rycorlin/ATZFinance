/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * A class that contains user information.
 */
public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    

    /**
     *
     * @param firstName First name of the user
     * @param lastName Last name of the user
     * @param userName User name of the user account
     * @param socialSecuritynumber Social security number of the suer
     */
    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;

    }
    
    
    /*------------------------------------FACTORY METHOD FOR UPGRADING THE "USER" TYPE TO A SPECIFIC USER TYPE.-----------------------------------------*/
    //Bret Easley
    public User upgradeUser(User previousUser, String userType)
    {
        if(userType == "Customer")
        {
            //Customer newCustomer = new Customer(previousUser.firstName,previousUser.lastName,previousUser.userName,previousUser.socialSecurityNumber, false);       //Ryan M. added Boolean just to keep moving along my code must fix later
           // return newCustomer;
        }
        
        if(userType == "TechSupport")
        {
           // TechSupport newTS = new TechSupport(previousUser.firstName,previousUser.lastName,previousUser.userName,previousUser.socialSecurityNumber);
           // return newTS;
        }
        
        if(userType == "LoanOfficer")
        {
           // int employeeID = 0; //This will likely be a sequential number in the future, just leaving it as zero to properly create the factory method.
          //  LoanOfficer newLO = new LoanOfficer(employeeID,previousUser.firstName,previousUser.lastName,previousUser.userName,previousUser.socialSecurityNumber);
            
        }
        return null;
    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    
    /**
     * Returns the first name of the user
     *
     * @return A string returning the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user
     *
     * @param firstName Sets the first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the user
     *
     * @return A string returning the first name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user
     *
     * @param lastName Sets the last name of the user
     *
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the social security number of the user
     *
     * @return An integer returning the social security number of the user
     */


    /**
     * Returns the user name for the user
     *
     * @return Returns the user name for the user account
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name for the user
     *
     * @param userName Sets the user name for the user account
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
