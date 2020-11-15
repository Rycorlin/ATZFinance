package Model;

import java.io.Serializable;

public class LoanApplication implements Serializable {

    private String fName, lName, loanType, loanAmount, addressLine1, addressLine2, city, state, zipCode;
    
    public LoanApplication(String fName, String lName, String loanType, String loanAmount, String add1, String add2, String city, String state, String zip) {
        this.fName = fName;
        this.lName = lName;
        this.addressLine1 = add1;
        this.addressLine2 = add2;
        this.city = city;
        this.state = state;
        this.zipCode = zip;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
    }

    public LoanApplication() {

    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }
    
    public String getAddress1() {
        return addressLine1;
    }

    public String getAddress2() {
        return addressLine2;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public void setAddressLine1(String address1) {
        this.addressLine1 = address1;
    }
    
    public void setAddressLine2(String address2) {
        this.addressLine2 = address2;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
       
    public void setState(String state) {
        this.state = state;
    }
    
    public void setZipCode(String zip) {
        this.zipCode = zip;
    }
    
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }
}
