package models;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.crypto.Data;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Users {
    private int userId; 
    private String userEmail; 
    public String userName;
    public String password; 
    public String homeAddress; 

    
    public Users (int userId, String userEmail, String password) {
        /* Constructor if a userEmail and password only are given */
        this.userId = userId; 
        this.userEmail = userEmail; 
        this.password = password; 
    }

public Users ()  {/* Default constructor */}

    public Users (int userId, String userEmail, String password, String userName, String homeAddress) {
        /* Constructor if all fields, including optional ones are given */
        this.userId = userId; 
        this.userEmail = userEmail; 
        this.password = password; 
        this.homeAddress = homeAddress;
        this.userName = userName;
    }

    public int getUserId() { return this.userId;}

    public void setUserId(int userId) {this.userId = userId; }

    public String getUserEmail() { return this.userEmail;}

    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

    public String getPassword() {return this.password;}

    public void setPassword(String password) {this.password = password;}

    public String getHomeAddress() {return this.homeAddress;}

    public void setHomeAddress(String homeAddress) {this.homeAddress = homeAddress;}

    public String getUserName() {return this.userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public static void saveUser(Users user) {
         try {
        Database.SetConnection();
     
            String query = "Insert INTO users ( userName, userEmail, password, homeAddress) VALUES (?,?,?,?)";
        
        PreparedStatement pstmt = Database.connection.prepareStatement(query);
        
       pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getHomeAddress());
            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        

    }

}
