import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Factorial {
     
     private int fact(int n) {
          if(n == 0){
               return 1;
          }
          return n * fact(n-1);
     }

 public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int N = in.nextInt();
      int result[] = new int[N];
      for(int i=0;i<N;i++){
           int num = in.nextInt();
           Factorial sol = new Factorial();
           result[i] = sol.fact(num);
      }
      for(int i = 0;i<N;i++){
          System.out.println(result[i]);
      }
 }
}