package controllers;

import models.Book;
import models.Database;
import models.WishList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {
	@GetMapping ("/wishlist/{wishlistname}")
	List <Book> getBooksInWishlist (@PathVariable String wishlistname) {
		List <WishList> wishlists = WishList.GetAllWishLists();
        List <Book> booksInWishlist = new ArrayList <Book> ();

        for (WishList w : wishlists) {
            if (w.getWishListName().equals(wishlistname)) {
                booksInWishlist = w.getBookList();
            }
        }
        return booksInWishlist;
	}

	@PostMapping ("/wishlist")
	WishList createWishlist (@RequestBody WishList wl) throws SQLException {
        WishList wl1 = wl;
        wl1.createWishlist(wl);
        //System.out.println(wl1.getWishListName());
        //System.out.println(wl1.getUsername());
        //System.out.println(wl1.getBookList());
        //Database.SetConnection();
        //Connection con = Database.connection;
        //Statement stmt = con.createStatement();
        //stmt.executeUpdate("INSERT INTO WishLists (WishListName, Username, ISBN) VALUES ('ev', 'test', 'testing1')");
        ResultSet resultSet = Database.ExecuteSQL ("SELECT * FROM WishLists");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(" | ");
                System.out.print(resultSet.getString(i));
            }
            System.out.println("");
        }
        System.out.println("end of function reached");
		return wl1;
	}

    @DeleteMapping ("/removeBookFromWL")
	WishList removeBook (@RequestBody WishList wl) throws SQLException {
        WishList wl1 = wl;
        System.out.println(wl1.getWishListName());
        System.out.println(wl1.getUsername());
        System.out.println(wl1.getisbn());
        wl1.removeBookFromWL(wl);
        ResultSet resultSet = Database.ExecuteSQL ("SELECT * FROM WishLists");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(" | ");
                System.out.print(resultSet.getString(i));
            }
            System.out.println("");
        }
		return wl1;
	}

    @PostMapping ("/addBooktoWL")
	WishList addBook (@RequestBody WishList wl) throws SQLException {
        WishList wl1 = wl;
        System.out.println(wl1.getWishListName());
        System.out.println(wl1.getUsername());
        System.out.println(wl1.getisbn());
        wl1.addBooktoWishlist(wl);
        ResultSet resultSet = Database.ExecuteSQL ("SELECT * FROM WishLists");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(" | ");
                System.out.print(resultSet.getString(i));
            }
            System.out.println("");
        }
		return wl1;
	}






}
