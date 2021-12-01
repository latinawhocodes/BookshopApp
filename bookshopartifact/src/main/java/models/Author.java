package models;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
 
import javax.xml.crypto.Data;
 
import org.springframework.boot.autoconfigure.domain.EntityScan;
 
@EntityScan
public class Author {
    public String authorFirstName; 
    public String authorLastName;
    public String authorBiography; 
    public String authorPublisher; 
 
    
    public Author (String authorFirstName, String authorLastName) {
        /* Constructor if authorFirstName and authorLastName only are given */
        this.authorFirstName = authorFirstName; 
        this.authorLastName = authorLastName; 
        
    }
 
public Author ()  {/* Default constructor */}
 
    public Author (String authorFirstName, String authorLastName, String authorBiography, String authorPublisher) {
        /* Constructor if all fields, including optional ones are given */
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorBiography = authorBiography;
        this.authorPublisher = authorPublisher;
    }
 
    public String getAuthorFirstName() { return this.authorFirstName; }
 
    public void setAuthorFirstName(String authorFirstName) {this.authorFirstName = authorFirstName; }
 
    public String getAuthorLastName() { return this.authorLastName;}
 
    public void setAuthorLastName(String authorLastName) {this.authorLastName = authorLastName;}
 
    public String getAuthorBiography() {return this.authorBiography;}
 
    public void setAuthorBiography(String authorBiography) {this.authorBiography = authorBiography;}
 
    public String getAuthorPublisher() {return this.authorPublisher;}
 
    public void setAuthorPublisher(String authorPublisher) {this.authorPublisher = authorPublisher;}
 
 
    public static void saveAuthor(Author author) {
         try {
        Database.SetConnection();
     
            String query = "Insert INTO authors (authorFirstName, authorLastName, authorBiography, authorPublisher) VALUES (?,?,?,?)";
        
        PreparedStatement pstmt = Database.connection.prepareStatement(query);
        
       pstmt.setString(1, author.getAuthorFirstName());
        pstmt.setString(2, author.getAuthorLastName());
            pstmt.setString(3, author.getAuthorBiography());
            pstmt.setString(4, author.getAuthorPublisher());
            pstmt.executeUpdate();
 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        
 
    }

    public static ArrayList<Author> GetAllAuthors() {
        ArrayList<Author> authors = new ArrayList<Author>();
        Database.SetConnection();
        ResultSet resultSet = Database.ExecuteSQL("SELECT authorFirstName\r\n"
                                                    + "    , authorLastName\r\n"
                                                    + "    , authorBiography\r\n"
                                                    + "    , authorPublisher\r\n"
                                                    + "FROM author");
        try {
            while (resultSet.next ()) {
                Author author = new Author(resultSet.getString("authorFirstName"), resultSet.getString("authorLastName"), resultSet.getString("authorBiography"), resultSet.getString("authorPublisher"));
                Author.saveAuthor(author);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return authors;
    }
 
}
