import java.io.*;
import java.util.*;

public class Fibonacci {

    private static int fibo(int n) {
        if(n <= 1) {
            return n;
        }
        return n * fibo(n-1);
    }

    public static void main(String args[]) {
        int result;
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        result = fibo(N);
        System.out.println(result);
    }
}