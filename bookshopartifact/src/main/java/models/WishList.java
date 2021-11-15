package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import models.Book;

public class WishList {
	private String WishListName;
	private String Username;
    private List <Book> books;

//	private String ISBN;
//	private String BookName;
//	private String BookAuthor;
	
	public WishList () {
		
	}
	
	//public WishList (String WishListName, String Username, String ISBN, double BookName, String BookAuthor) {
    public WishList (String WishListName, String Username, List<Book> book) {
		this.WishListName = WishListName;
		this.Username = Username;
        this.books = book;
		//this.ISBN = ISBN;
		//this.BookName = BookName;
		//this.BookAuthor = BookAuthor;
	}

    public void addBook(Book b) {
        books.add(b);
    }

    public List<Book> getBookList() {
        return books;
    } 

	public String getWishListName() {
		return WishListName;
	}

	public void setWishListName(String wishListName) {
		WishListName = wishListName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	
  /*  public static ArrayList<WishList> GetAllWishLists() {
        ArrayList<WishList> wishList = new ArrayList<WishList>();
        Database.SetConnection();
        ResultSet resultSet = Database.ExecuteSQL("SELECT WishListName\r\n"
                                                    + "    , Username\r\n"
                                                    + "    , ISBN\r\n"
                                                    + "    , BookName\r\n"
                                                    + "    , BookAuthor\r\n"
                                                    + "FROM WishLists");
        try {
            while (resultSet.next ()) {
                WishList wishList = new WishList(resultSet.getString("WishListName"), resultSet.getString("Username"), resultSet.getString("ISBN"), resultSet.getDouble("BookName"), resultSet.getString("BookAuthor"));
                wishList.add(wishList);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return wishList;
    }
*/

    public static ArrayList<WishList> GetAllWishLists() {
        ArrayList<WishList> wishList = new ArrayList<WishList>();
        Database.SetConnection();
        ResultSet resultSet = Database.ExecuteSQL("SELECT WishListName\r\n"
                                                    + "    , Username\r\n"
                                                    + "    , ISBN\r\n"
                                                    + "FROM WishLists");
        try {
            while (resultSet.next ()) {

                String wln = resultSet.getString("WishListName");
                String un = resultSet.getString("Username");
                String isbn = resultSet.getString("ISBN");
                int i = 0;

                //if there is already a wishlist for that username & wishlist name, just add book to it , otherwise create new wishlist
                for (WishList w : wishList) {
                    if(w.getWishListName().equals(wln)) {
                        i = 1;				
                        List <Book> books = Book.GetAllBooks();
                        for (Book b : books) {
			                if (b.getISBN ().equals(isbn)) {
				                w.addBook(b);
			                }
                        }
                    }
                }
                if (i==0) {
                    List <Book> books = Book.GetAllBooks();
		            List <Book> booksToAdd = new ArrayList <Book> ();
		            for (Book b : books) {
			            if (b.getISBN ().equals(isbn)) {
				            booksToAdd.add(b);		
                            WishList singleWishList = new WishList(wln, un, booksToAdd);
                            wishList.add(singleWishList);		
			            }
                    }  
                }
            /*   List <Book> books = Book.GetAllBooks();
		        List <Book> booksToAdd = new ArrayList <Book> ();
		        for (Book b : books) {
			        if (b.getISBN ().equals(isbn)) {
				        booksToAdd.add(b);		
                        WishList singleWishList = new WishList(wln, un, booksToAdd);
                        wishList.add(singleWishList);		
			        }
                }*/  
		    }     
       } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return wishList;
    }


}
