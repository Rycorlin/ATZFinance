package atzfinance;

/**
 *
 * A class that generates reports
 */
public class ErrorReport {

    private User user;
    private String message;

    public ErrorReport(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
