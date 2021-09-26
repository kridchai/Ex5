import java.util.*;
import java.io.*;
public class OneCard {
    private int score; // 0-51
    private String suit; // clubs, diamonds, hearts, spades
    private  String rank; // ace, 2-10, jack, queen, king
    public OneCard(int sc) { 
        score = sc;
         String []suit = {"clubs","diamonds","hearts","spades"};
        String []rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int row,colum;
        row = sc /13;
        colum = sc %13;
        this.suit = suit[row];
        this.rank = rank[colum];
        
    }
    public int getScore() { return score; }
    public String getSuit() { return suit; }
    public String getRank() { return rank; }
} // end OneCard


