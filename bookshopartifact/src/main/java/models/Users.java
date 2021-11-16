package models;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.xml.crypto.Data;
import java.util.ArrayList;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Users {
    private int userId; 
    private String userEmail; 
    public String name;
    public String password; 
    public String homeAddress; 

    
    public Users (int userId, String userEmail, String password) {
        /* Constructor if a userEmail and password only are given */
        this.userId = userId; 
        this.userEmail = userEmail; 
        this.password = password; 
    }

public Users ()  {/* Default constructor */}

    public Users (int userId, String userEmail, String password, String name, String homeAddress) {
        /* Constructor if all fields, including optional ones are given */
        this.userId = userId; 
        this.userEmail = userEmail; 
        this.password = password; 
        this.homeAddress = homeAddress;
        this.name = name;
    }

    public int getUserId() { return this.userId;}

    public void setUserId(int userId) {this.userId = userId; }

    public String getUserEmail() { return this.userEmail;}

    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

    public String getPassword() {return this.password;}

    public void setPassword(String password) {this.password = password;}

    public String getHomeAddress() {return this.homeAddress;}

    public void setHomeAddress(String homeAddress) {this.homeAddress = homeAddress;}

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public static void saveUser(Users user) {
         try {
        Database.SetConnection();
     
            String query = "Insert INTO users ( name, userEmail, password, homeAddress) VALUES (?,?,?,?)";
        
        PreparedStatement pstmt = Database.connection.prepareStatement(query);
        
       pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getUserEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getHomeAddress());
            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        

    }

        public static void updateSingleUser(Users user) {
         try {
        Database.SetConnection();
     
            String query = "UPDATE users SET  password = ? , homeAddress = ? WHERE userEmail = ?" ;
        
        PreparedStatement pstmt = Database.connection.prepareStatement(query);
        
       
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getHomeAddress());
            pstmt.setString(3, user.getUserEmail());
            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        

    }

    public static Users getUser(String userEmail) {
        Database.SetConnection();
        try {
        String query = "SELECT * FROM users WHERE userEmail = ?";
        
        PreparedStatement pstmt = Database.connection.prepareStatement(query);
         pstmt.setString(1, userEmail);
         ResultSet resultSet = pstmt.executeQuery();
            resultSet.next ();

                Users user = new Users(resultSet.getInt("userId"), resultSet.getString("userEmail"), resultSet.getString("password"), resultSet.getString("name"),resultSet.getString("homeAddress"));
                return user;
              
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Users updateUser(Users user) {
        Users old_user = getUser(user.getUserEmail());
        old_user.setHomeAddress(user.getHomeAddress());
        old_user.setName(user.getName());
        old_user.setPassword(user.getPassword());
        Users.updateSingleUser(old_user);
        return old_user;
    }

    public static void addCreditCardToUser(int user_id, CreditCard creditCard) {
        try {
            Database.SetConnection();
         
                String query = "Insert INTO credit_cards ( user_id, card_no, cvc_code, card_holder_name, expiration_date) VALUES (?,?,?,?,?)";
            
            PreparedStatement pstmt = Database.connection.prepareStatement(query);
            
           pstmt.setInt(1, user_id);
            pstmt.setString(2, creditCard.card_no);
                pstmt.setString(3, creditCard.cvc_code);
                pstmt.setString(4, creditCard.card_holder_name);
                pstmt.setString(5, creditCard.expiration_date);

                pstmt.executeUpdate();
    
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
    }

    public static ArrayList<CreditCard> getCreditCards(String userEmail) {
        Database.SetConnection();
        ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
        try {
        String query = "SELECT  cs. id, cs.user_id, cs.card_no, cs.cvc_code, cs.card_holder_name, cs.expiration_date FROM users left join credit_cards cs on (users.userid = cs.user_id) WHERE userEmail = ?";
        
        PreparedStatement pstmt = Database.connection.prepareStatement(query);
         pstmt.setString(1, userEmail);
         ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next ()){

                CreditCard card = new CreditCard(resultSet.getInt("id"),resultSet.getInt("user_id"), resultSet.getString("card_no"), resultSet.getString("cvc_code"), resultSet.getString("card_holder_name"),resultSet.getString("expiration_date"));
                cards.add(card);
            }
              
              
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cards;
    }

}
