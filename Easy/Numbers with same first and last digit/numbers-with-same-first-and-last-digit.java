//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int L=Integer.parseInt(inp[0]);
            int R=Integer.parseInt(inp[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numbersInRange(L,R));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int numbersInRange(int L, int R){
        // code here
        int numberCount = 0;
        for(int i = L ; i <= R; i++){
            if(i <= 9){
                numberCount++;
            }else{
                if(sameDigits(i)){
                    numberCount++;
                }
            }
        }
        
        return numberCount;
    }
    
    static boolean sameDigits(int N){
        int lastDigit = N % 10;
        int firstDigit = 0;
        while(N != 0){
            firstDigit = N % 10;
            N = N / 10;
        }
        
        if(firstDigit == lastDigit){
            return true;
        }
        
        return false;
    }
}