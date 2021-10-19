package book.rating;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

/**
 *
 * @author derro
 */
public class BookRating {

    /**
     * @param args the command line arguments
     */   
    Scanner scan = new Scanner(System.in);
    private String pBook;
    private int pRate;
    private int pNOfR;
    private double pRateAvg;
    //private String pCom;

    private BookRating (String pBook, int pRate, int pNOfR, double pRateAvg) {
        this.pBook = pBook;
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

            System.out.println("Your rating for \"" + pBook + "\" is: " + pRate + "\n");

            System.out.println("Now \"" + pBook + "\" has a rating of " + pRateAvg + " out of " + pNOfR + " rating(s) at " + dtf.format(now));
            
            System.out.println("Would also like to leave a comment about said book?");
            System.out.println("(Please type \"yes\" or \"no\")");
            c = scan.nextLine();
            switch (c) {
                case "yes": case "Yes": case "YES":
                    //c = true;
                    System.out.println("\nPlease enter your comment\n");
                    comment = scan.nextLine();
                    System.out.println("");
                    System.out.println("Your comment for \"" + pBook +"\" is: \"" + comment + "\", at" + dtf.format(now) + "\n");
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

    public static class Numbers {
        private String pBook;
        private int pRate;
        private int pNOfR;
        private double pRateAvg;

        public Numbers setpBook (String pBook) {
            this.pBook = pBook;
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
            return new BookRating(pBook, pRate, pNOfR, pRateAvg);
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
