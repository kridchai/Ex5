
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class CardThread extends Thread {
    private PrintWriter out;
    private ArrayList<OneCard> randomCards;
    public CardThread(String n) {
        super(n);
        randomCards = new ArrayList<OneCard>();
    }
    public void reset() { randomCards.clear(); }
    public void run() {
        int check = 0,round = 0;
        int []PickCard = {55,56,57,58};
        Random random = new Random();
        int r;
        String name = super.getName() + ".txt";
        try{ out = new PrintWriter(Thread.currentThread().getName()+".txt");
        int count = 0;
        while(check==0){
            while(count<4){
                r = random.nextInt(52);
                if(find(PickCard,r)==false){
                    PickCard[count] = r;
                    OneCard card = new OneCard(r);
                    randomCards.add(card);
                    count++;
                }
            }
            PickCard = reset(PickCard);
            round ++;
            out.printf("Round   %d : ",round);
            out.flush();
            for(int i = 0;i<randomCards.size();i++){
                out.printf("%s of %s \t",randomCards.get(i).getRank(),randomCards.get(i).getSuit());
            }
            out.println();
            if(checkSame(randomCards))
                check = 1;
            else{
                count = 0;
                this.reset();
            }
        }
        out.close();
        System.out.printf("Thread %s finishes in %d rounds\n",Thread.currentThread().getName(),round);
        }
        catch(Exception e){System.err.println(e);}
       
    }
    private static boolean find(int[]f,int n){
        for(int i = 0;i<f.length;i++){
            if(n==f[i])
                return true;
        }
        return false;
    }
    
    private static int[] reset(int []n){
        for(int i = 0;i<n.length;i++){
            n[i] = -1;
        }
        return n;
    
    }
    private static boolean checkSame(ArrayList<OneCard> ai){
        int c = 0;
       for(int i = 0;i<ai.size()-1;i++){
            if((ai.get(i).getSuit().equals(ai.get(i+1).getSuit())==false) )
            {   c = 1; 
                break;
            }
            
        }
        if(c==0)
            return true;
        for(int i = 0;i<ai.size()-1;i++){
            if( (ai.get(i).getRank().equals(ai.get(i+1).getRank())==false))
                return false;
        }
        return true;
    } 
} // end CardThread
