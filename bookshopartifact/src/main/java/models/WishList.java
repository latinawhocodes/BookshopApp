package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import models.Book;

public class WishList {
	private String WishListName;
	private String Username;
    //private String BookName;
    private List <Book> books;

	private String isbn;
//	private String BookName;
//	private String BookAuthor;
	
	public WishList () {
		
	}

    public WishList (String wishlistName, String username) {
        //System.out.println("used constructor 1");
		this.WishListName = wishlistName;
		this.Username = username;
        //this.BookName = bookName;
        books = new ArrayList <Book>();
        this.isbn = null;
		//this.ISBN = ISBN;
		//this.BookName = BookName;
		//this.BookAuthor = BookAuthor;
	}
	
	//public WishList (String WishListName, String Username, String ISBN, double BookName, String BookAuthor) {
    public WishList (String WishListName, String Username, List<Book> book) {
       // System.out.println("used constructor 2");
		this.WishListName = WishListName;
		this.Username = Username;
        this.books = book;
        this.isbn = null;
        //this.BookName = BookName;
		//this.ISBN = ISBN;
		//this.BookName = BookName;
		//this.BookAuthor = BookAuthor;
	}

    public WishList (String wishlistName, String username, String isbn) {
       // System.out.println("used constructor 3");
		this.WishListName = wishlistName;
		this.Username = username;
        this.isbn = isbn;
       // this.books = book;
       List <Book> books = Book.GetAllBooks();
	   List <Book> bookToAdd = new ArrayList <Book> ();
		    for (Book b : books) {
			    if (b.getISBN ().equals(isbn)) {
				    bookToAdd.add(b);			
                    this.books = bookToAdd;
			    }
            }
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

    public String getisbn() {
		return isbn;
	}


    /*public String getBookName() {
		return BookName;
	}*/

	public void setBookISBN(String isbn) {
		this.isbn = isbn;
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

    public WishList createWishlist(WishList wlist) throws SQLException {
        //WishList wl = new WishList(wishlist, username);
       // Database db = new Database();
       // db.SetConnection();
       Database.SetConnection();
       Connection con = Database.connection;

        String sql = "INSERT INTO WishLists VALUES (?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, wlist.getWishListName());
        pstmt.setString(2, wlist.getUsername());
        pstmt.setString(3, null);
        System.out.println(wlist.getWishListName());
        System.out.println(wlist.getUsername());       
        System.out.println(pstmt);

        pstmt.executeUpdate();
        pstmt.close();
        return wlist;
    }

    public WishList addBooktoWishlist(WishList wlist) throws SQLException {
        //WishList wl = new WishList(wishlist, username);
       // Database db = new Database();
       // db.SetConnection();
       Database.SetConnection();
       Connection con = Database.connection;

        String sql = "INSERT INTO WishLists VALUES (?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, wlist.getWishListName());
        pstmt.setString(2, wlist.getUsername());
        pstmt.setString(3, wlist.getisbn());
        System.out.println(wlist.getWishListName());
        System.out.println(wlist.getUsername());  
        System.out.println(wlist.getisbn());     
        System.out.println(pstmt);

        pstmt.executeUpdate();
        pstmt.close();
        return wlist;
    }

    public WishList removeBookFromWL(WishList wlist) throws SQLException {
        //WishList wl = new WishList(wishlist, username);
       // Database db = new Database();
       // db.SetConnection();
       Database.SetConnection();
       Connection con = Database.connection;

        String sql = "DELETE FROM WishLists WHERE WishListName = ? AND Username = ? and ISBN = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, wlist.getWishListName());
        pstmt.setString(2, wlist.getUsername());
        pstmt.setString(3, wlist.getisbn());
        System.out.println(wlist.getWishListName());
        System.out.println(wlist.getUsername());  
        System.out.println(wlist.getisbn());     
        System.out.println(pstmt);

        pstmt.executeUpdate();
        pstmt.close();
        return wlist;
    }


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
                //String name = resultSet.getString("BookName");
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
