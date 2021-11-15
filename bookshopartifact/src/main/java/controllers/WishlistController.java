package controllers;

import models.Book;
import models.WishList;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
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
}
