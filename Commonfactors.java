import java.io.*;
import java.util.*;

class Commonfactors {
    public static void main(String args[] ) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String[] numbers;
        numbers = str.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        System.out.println(numOfCommondivisor(num1,num2));
    }
    
    public static int numOfCommondivisor(int n1,int n2){
        int n = gcd(n1,n2);
        int result = 0;
        
        for(int i=1;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                if(n/i == i) {
                    result+=1;
                } else {
                    result+=2;
                }
            }
        }
        return result;
    }
    
    public static int gcd(int a,int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a,a);
    }
}