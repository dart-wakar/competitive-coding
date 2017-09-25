import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimeSequence {

 public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int T = in.nextInt();
      int req[] = new int[T];
      int max = 0;
      for(int i = 0;i<T;i++){
           req[i] = in.nextInt();
           if(req[i] > max){
                max = req[i];
           }
      }
      int result[] = new int[max+1];
      PrimeSequence sol = new PrimeSequence();
      result = sol.getCompleteSequence(max);
      for(int i = 0;i<req.length;i++){
           System.out.println(result[req[i]-1]);
      }
 }
     
     private int[] getCompleteSequence(int maximum) {
          int res[] = new int[maximum];
          int ind = 0;
          res[ind] = 1;
          ind++;
          for(int i=2;;i++) {
              int n = i;
               while (n%2 == 0) {
                   n /= 2;
               }
               while(n%3 == 0){
                   n /= 3;
               }
               while(n%5 == 0){
                   n /= 5;
               }
               if(n == 1){
                   res[ind] = i;
                   ind++;
               }
               if(ind == maximum){
                   break;
               }
          }
          return res;
     }
}