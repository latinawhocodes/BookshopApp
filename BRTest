package models;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* public class Book {
	private String ISBN;
	private String Name;
	private String Description;
	private double Price;
	private String Author;
	private String Genre;
	private String Publisher;
	private int YearPublished;
	private int CopiesSold;
	private double Rating; */
/**
 *
 * @author derro
 */
public class Book {

    /**
     * @param args the command line arguments
     */   
    Scanner scan = new Scanner(System.in);
    private String Name;
    private String Author;
    private String Genre;
    private int pRate;
    private int pNOfR;
    private double pRateAvg;
    //private String pCom;

    private Book (String Name, String Author, String Genre, int pRate, int pNOfR, double pRateAvg) {
        this.Name = Name;
        this.Author = Author;
        this.Genre = Genre;
        this.pRate = pRate;
        this.pNOfR = pNOfR;
        this.pRateAvg = pRateAvg;
        int rating = 0;
        String c;
        String comment;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if (pRate == 0 || pRate < 0) {
            System.out.println("Sorry, but the number you have entered is too low.\nPlease try again later.");
        }else if (pRate > 0 && pRate < 6) {
            pNOfR++;
            
            rating += pRate;

            pRateAvg = (double)rating/pNOfR;

            System.out.println("Your rating for \"" + Name + "\" by " + Author + " is: " + pRate + "\n");

            System.out.println("Now \"" + Name + "\" by " + Author " has a rating of " + pRateAvg + " out of " + pNOfR + " rating(s) at " + dtf.format(now));
            
            System.out.println("Would also like to leave a comment about said book?");
            System.out.println("(Please type \"yes\" or \"no\")");
            c = scan.nextLine();
            switch (c) {
                case "yes": case "Yes": case "YES":
                    //c = true;
                    System.out.println("\nPlease enter your comment\n");
                    comment = scan.nextLine();
                    System.out.println("");
                    System.out.println("Your comment for \"" + Name +"\" by " + Author + " is: \"" + comment + "\", at " + dtf.format(now) + "\n");
                case "no": case "No": case "NO":
                    //c = false;
                    break;
                default: 
                    //c = false;
                    break;
            }

        }else {
            System.out.println("Sorry, but the number you have entered is too high.\nPlease try again later.");
        }
        
    }

     public static ArrayList<Book> GetBooksWithRatingAndHigher(int rating) {
        ArrayList<Book> books = new ArrayList<Book>();
        Database.SetConnection();
        ResultSet resultSet = Database.ExecuteSQL("SELECT B.ISBN\r\n"
                                                    + "    , B.Name\r\n"
                                                    + "    , B.Description\r\n"
                                                    + "    , B.Price\r\n"
                                                    + "    , B.Author\r\n"
                                                    + "    , B.Genre\r\n"
                                                    + "    , B.Publisher\r\n"
                                                    + "    , B.YearPublished\r\n"
                                                    + "    , B.CopiesSold\r\n"
                                                    + "    , AVG(R.Rating) AverageRating\r\n"
                                                    + "FROM Book B\r\n"
                                                    + "JOIN Ratings R\r\n"
                                                    + "    ON R.ISBN = B.ISBN\r\n"
                                                    + "GROUP BY B.ISBN\r\n"
                                                    + "    , B.Name\r\n"
                                                    + "    , B.Description\r\n"
                                                    + "    , B.Price\r\n"
                                                    + "    , B.Author\r\n"
                                                    + "    , B.Genre\r\n"
                                                    + "    , B.Publisher\r\n"
                                                    + "    , B.YearPublished\r\n"
                                                    + "    , B.CopiesSold\r\n"
                                                    + "HAVING AVG(R.Rating) >= " + rating);
        try {
            while (resultSet.next ()) {
                Book book = new Book(resultSet.getString("ISBN"), resultSet.getString("Name"), resultSet.getString("Description"), resultSet.getDouble("Price"), resultSet.getString("Author"), resultSet.getString("Genre"), resultSet.getString("Publisher"), resultSet.getInt("YearPublished"), resultSet.getInt("CopiesSold"));
                book.Rating = resultSet.getDouble("AverageRating");
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    public static class Numbers {
        private String Name;
        private String Author;
        private String Genre;
        private int pRate;
        private int pNOfR;
        private double pRateAvg;

        public Numbers setName (String Name) {
            this.Name = Name;
            return this;
        }
        public Numbers setAuthor (String Author) {
            this.Author = Author;
            return this;
        }
        public Numbers setGenre(String Genre) {
            this.Genre = Genre;
            return this;
        }
        public Numbers setpRate(int pRate) {
            this.pRate = pRate;
            return this;
        }
        public Numbers setpNOfR (int pNOfR) {
            this.pNOfR = pNOfR;
            return this;
        }
        public Numbers setpRateAvg (double pRateAvg) {
            this.pRateAvg = pRateAvg;
            return this;
        }
        public BookRating build() {
            return new BookRating(Name, Author, Genre, pRate, pNOfR, pRateAvg);
        }
    }



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int rating = 0;
        int numOfRates = 0;
        double rateAvg = 0;

        System.out.println("What book would you like to rate?\n");
        
        String bookTitle = scan.nextLine();

        System.out.println("");
     
        System.out.println("What would you rate \"" + bookTitle + "\"?\n(Please enter a whole number between 1 and 5)\n");
        
        int userRate = scan.nextInt();

        System.out.println("");

        BookRating.Numbers num = new BookRating.Numbers();
            BookRating bR = num
              .setpBook(bookTitle)
              .setpRate(userRate)
              .setpNOfR(numOfRates)
              .setpRateAvg(rateAvg)
              .build();
    }
}
