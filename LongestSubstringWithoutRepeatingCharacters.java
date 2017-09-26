import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestSubstringWithoutRepeatingCharacters {

    private int lengthOfLongestSubstring(String s){
        int n = s.length(),result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0,i = 0;j < n;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String queries[] = new String[T];
        for(int i = 0;i < T;i++){
            queries[i] = in.next().toString().trim();
        }
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        for(int i = 0;i < T;i++){
            int res = lswrc.lengthOfLongestSubstring(queries[i]);
            System.out.println(res);
        }
    }
}