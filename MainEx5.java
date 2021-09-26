import java.util.*;
import java.util.Scanner;
public class MainEx5 {
    public static void main(String[] args){
        int n ;
        String name;
        ArrayList<CardThread> T = new ArrayList<CardThread>();
        Scanner in = new Scanner(System.in);
        System.out.println(" Number of thread = ");
        n = in.nextInt();
        for(int i = 0;i<n;i++){
            name = "T" + i;
            CardThread c = new CardThread(name);
            T.add(c); 
        }
        for(int i = 0;i<T.size();i++){
            T.get(i).start();
        }
    
    }
}
