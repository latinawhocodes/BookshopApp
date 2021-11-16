package models;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.xml.crypto.Data;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class CreditCard {
    public int id; 
    public int user_id; 
    public String card_no; 
    public String cvc_code;
    public String card_holder_name; 
    public String expiration_date; 

    public CreditCard (int id, int user_id, String card_no, String cvc_code, String card_holder_name, String expiration_date) {
        /* Constructor if a userEmail and password only are given */
        this.id = id; 
        this.user_id = user_id; 
        this.card_no = card_no; 
        this.cvc_code = cvc_code; 
        this.card_holder_name = card_holder_name; 
        this.expiration_date = expiration_date; 
    }
}
