//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here
        if(N == 1){
            return 1;
        }
        
        int[] leftCandies = new int[N];
        int[] rightCandies = new int[N];
        
        leftCandies[0] = 1;
        rightCandies[N-1] = 1;
        
        int j = N - 2;
        for(int i = 1; i < N ; i++){
            leftCandies[i] = ratings[i] > ratings[i-1] ? leftCandies[i-1] + 1 : 1;
            rightCandies[j] = ratings[j] > ratings[j+1] ? rightCandies[j+1] + 1 : 1;
            j--;
        }
        
        int totalCandies = 0;
        for(int i = 0 ; i < N; i++){
            totalCandies += Math.max(leftCandies[i], rightCandies[i]);
        }
        
        return totalCandies;
    }
}
