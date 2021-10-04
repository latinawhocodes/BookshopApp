package models;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Users {
    private int userId; 
    private String userName; 
    public String password; 
    public String homeAddress; 

    
    public Users (int userId, String userName, String password) {
        /* Constructor if a username and password only are given */
        this.userId = userId; 
        this.userName = userName; 
        this.password = password; 
    }

public Users ()  {/* Default constructor */}

    public Users (int userId, String userName, String password, String homeAddress) {
        /* Constructor if all fields, including optional ones are given */
        this.userId = userId; 
        this.userName = userName; 
        this.password = password; 
        this.homeAddress = homeAddress;
    }

    public int getUserId() { return this.userId;}

    public void setUserId(int userId) {this.userId = userId; }

    public String getUserName() { return this.userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return this.password;}

    public void setPassword(String password) {this.password = password;}

    public String getHomeAddress() {return this.homeAddress;}

    public void setHomeAddress(String homeAddress) {this.homeAddress = homeAddress;}

}
