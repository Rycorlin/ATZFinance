package Model;

import java.io.Serializable;

public class LoanApplication implements Serializable {

    private String fName, lName, loanType, loanAmount;

    public LoanApplication(String fName, String lName, String loanType, String loanAmount) {
        this.fName = fName;
        this.lName = lName;
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

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }
}
