import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinimumNumberOfSquares {

    private int getMinimumNumberOfSquares(int N){
        int dp[] = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int j = 4;j <= N;j++){
            dp[j] = j;
            for(int k = 1;k <= j;k++){
                int temp = k*k;
                if(temp > j){
                    break;
                } else {
                    dp[j] = Math.min(dp[j],1+dp[j-temp]);
                }
            }
        }
        return dp[N];
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int queries[] = new int[T];
        for(int i = 0;i < T;i++){
            queries[i] = in.nextInt();
        }
        MinimumNumberOfSquares minsq = new MinimumNumberOfSquares();
        int results[] = new int[T];
        for(int i = 0;i < T;i++){
            results[i] = minsq.getMinimumNumberOfSquares(queries[i]);
        }
        for(int i = 0;i < T;i++){
            System.out.println(results[i]);
        }
    }
}