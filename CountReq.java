import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountReq {
     
     private int getCount(int N){
          if(N/100 == 0 || N ==100){
               if(N>55){
                    return 30;
               } else {
                    if(N%10<=5){
                         int res = (N/10)*5+N%10;
                         return res;
                    }
                    int res = ((N/10)+1)*5;
                    return res;
               }
          } else {
               if(N>555){
                    return 155;
               } else {
                    if((N/10)%10 >5){
                         int res = 30+(((N/100)-1)*25);
                         return res;
                    } else {
                         if(N%10<=5){
                              int res = 30 + (((N/100)-1)*25) + ((((N/10)%10)-1)*5) + N%10;
                              return res;
                         }
                         int res = 30 + (((N/100)-1)*25) + (((N/10)%10)*5);
                         return res;
                    }
               }
          }
     }

 public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int T = in.nextInt();
      int queries[] = new int[T];
      for(int i = 0;i<T;i++){
           queries[i] = in.nextInt();
      }
      CountReq sol = new CountReq();
      for(int i = 0;i<T;i++){
           int result = sol.getCount(queries[i]);
           System.out.println(result);
      }
 }
}