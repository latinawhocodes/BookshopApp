package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Book {
	private String ISBN;
	private String Name;
	private String Description;
	private double Price;
	private String Author;
	private String Genre;
	private String Publisher;
	private int YearPublished;
	private int CopiesSold;
	
	public Book () {
		
	}
	
	public Book (String ISBN, String Name, String Description, double Price, String Author, String Genre, String Publisher, int YearPublished, int CopiesSold) {
		this.ISBN = ISBN;
		this.Name = Name;
		this.Description = Description;
		this.Price = Price;
		this.Author = Author;
		this.Genre = Genre;
		this.Publisher = Publisher;
		this.YearPublished = YearPublished;
		this.CopiesSold = CopiesSold;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public int getYearPublished() {
		return YearPublished;
	}

	public void setYearPublished(int yearPublished) {
		YearPublished = yearPublished;
	}

	public int getCopiesSold() {
		return CopiesSold;
	}

	public void setCopiesSold(int copiesSold) {
		CopiesSold = copiesSold;
	}
	
    public static ArrayList<Book> GetAllBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        Database.SetConnection();
        ResultSet resultSet = Database.ExecuteSQL("SELECT ISBN\r\n"
                                                    + "    , Name\r\n"
                                                    + "    , Description\r\n"
                                                    + "    , Price\r\n"
                                                    + "    , Author\r\n"
                                                    + "    , Genre\r\n"
                                                    + "    , Publisher\r\n"
                                                    + "    , YearPublished\r\n"
                                                    + "    , CopiesSold\r\n"
                                                    + "FROM Book");
        try {
            while (resultSet.next ()) {
                Book book = new Book(resultSet.getString("ISBN"), resultSet.getString("Name"), resultSet.getString("Description"), resultSet.getDouble("Price"), resultSet.getString("Author"), resultSet.getString("Genre"), resultSet.getString("Publisher"), resultSet.getInt("YearPublished"), resultSet.getInt("CopiesSold"));
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

}
