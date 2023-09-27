//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    static String reverseWords(String S)
    {
        // code here 
        String[] words = S.split("[.]");
        String result = "";
        for(int i = words.length - 1;  i >= 0 ; i--){
            if(i == 0){
                result += words[i];
            }else{
                result += words[i] + ".";
            }
            
        }
        
        return result;
    }
}