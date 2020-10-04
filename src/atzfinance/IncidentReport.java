package atzfinance;

/**
 *
 * A class that generates reports
 */
public class IncidentReport {

    private User user;
    private String message;
    
    public IncidentReport(){

    }
    
    public IncidentReport(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public void setUser(User u){
        this.user = u;
    }
    
    public User getUser() {
        return user;
    }

    public void setMessage(String m){
        this.message = m;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void printReport(){
        System.out.println(this.message);
    }
    
}
