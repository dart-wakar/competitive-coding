import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int result = -1;
        int sum1[] = new int[n1];
        Stack stack1 = new Stack();
        for(int h1_i=0; h1_i < n1; h1_i++){
            stack1.push(in.nextInt());
            sum1[h1_i] = stack1.sumOfElements(stack1);
        }
        Stack stack2 = new Stack();
        int sum2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            stack2.push(in.nextInt());
            sum2[h2_i] = stack2.sumOfElements(stack2);
        }
        Stack stack3 = new Stack();
        int sum3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            stack3.push(in.nextInt());
            sum3[h3_i] = stack3.sumOfElements(stack3);
        }
        int minInput = findArrayHavingMinimumsize(n1,n2,n3);
        switch(minInput) {
            case 1:
                result = searchInOtherTwo(sum1,sum2,sum3);
                break;
            case 2:
                result = searchInOtherTwo(sum2,sum1,sum3);
                break;
            case 3:
                result = searchInOtherTwo(sum3,sum1,sum2);
                break;
        }
        if(result == -1) System.out.println("Not possible");
        else System.out.println(result);
    }

    private static int searchInOtherTwo(int a1[],int a2[],int a3[]) {
        boolean b1,b2;
        for(int i=a1.length-1;i>=0;i--) {
            b1 = searchIn(a1[i],a2);
            b2 = searchIn(a1[i],a3);
            if(b1 && b2){
                return a1[i];
            }
        }
        return -1;
    }

    private static boolean searchIn(int key,int array[]) {
        int low = 0,high = array.length-1;
        while(low<=high) {
            int m = low + (high-low)/2;
            if(array[m] == key) {
                return true;
            }
            if(array[m] < key) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return false;
    }

    private static int findArrayHavingMinimumsize(int a1,int a2,int a3) {
        if(a1<=a2 && a1<=a3) {
            return 1;
        } else if(a2<=a1 && a2<=a3) {
            return 2;
        } else {
            return 3;
        }
    }
}

 class Stack{

    private int n=1;
    private int a[]=new int[n];
    public void push(int x){
        if(n==a.length) resize(2*a.length);
        a[n++]=x;
    }
    public void pop(){
        if(a.length==0) throw new NoSuchElementException("Stack underflow");
        int x=a[n-1];
        a[n-1]=0;
        n--;
        if(n>0 && n==a.length/4) resize(a.length/2);
    }
    public int max(Stack st){
        int maximum=1;
        for(int j=0;j<n;j++){
            if(st.a[j]>maximum) maximum=st.a[j];
        }
        return maximum;
    }
    private void resize(int capacity) {
        assert capacity >= n;
        int temp[] =  new int[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public int sumOfElements(Stack st) {
        int sum = 0;
        for (int i = 0;i<n;i++) {
            sum+=st.a[i];
        }
        return sum;
    }

    public int size() {
        return n;
    }
}
