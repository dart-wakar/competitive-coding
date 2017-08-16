import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UncommonCharacters {

 public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
      Scanner in = new Scanner(System.in);
      int N = Integer.parseInt(in.nextLine());
      String rs[] = new String[N];
      String S[] = new String[N];
      String X[] = new String[N];
      char sc[][] = new char[N][];
      char xc[][] = new char[N][];
      char rsc[][] = new char[N][];
      char lrsc[][] = new char[N][];
      for(int i=0;i<N;i++) {
           S[i] = in.nextLine();
           sc[i] = S[i].toCharArray();
           Arrays.sort(sc[i]);
           X[i] = in.nextLine();
           xc[i] = X[i].toCharArray();
           Arrays.sort(xc[i]);
      }
      for(int i=0;i<N;i++) {
          sc[i] = removeDuplicates(sc[i]);
          xc[i] = removeDuplicates(xc[i]);
          rs[i] = String.valueOf(sc[i])+String.valueOf(xc[i]);
          rsc[i] = rs[i].toCharArray();
          Arrays.sort(rsc[i]);
          lrsc[i] = removeRepeatingCharacters(rsc[i]);
      }
      for(int i=0;i<N;i++) {
          System.out.println(String.valueOf(rsc[i]));
          System.out.println(String.valueOf(lrsc[i]));
      }
 }

 private static char[] removeRepeatingCharacters(char[] a) {
     char c[] = new char[a.length];
     int b = 0;
     c[b] = a[0];
     for(int j=1;j<a.length;j++) {
         if(c[b] == a[j]) {
             c[b] = Character.MIN_VALUE;
         } else if(c[b] != a[j]) {
             b++;
             c[b] = a[j];
         }
     }
     return c;
 }

 private static char[] removeDuplicates(char[] a) {
     int b = 0;
     char c[] = new char[a.length];
     c[b] = a[0];
     for(int j=0;j<a.length;j++) {
         if(c[b] != a[j]) {
             b++;
             c[b] = a[j];
         }
     }
     return c;
 }
}