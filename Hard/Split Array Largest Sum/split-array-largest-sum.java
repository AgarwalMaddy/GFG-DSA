//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int result = minLargestSum(arr, N , K);
        return result;
    }
    public static int minLargestSum(int[] arr, int N , int K){
        int start = 0;
        int end = 0;
        for(int num : arr){
            start = Math.max(num , start);
            end += num;
        }
        
        while(start < end){
            int pieces = 1;
            int sum = 0;
            int mid = start + (end - start)/2;
            for(int num : arr){
                if(num + sum > mid){
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            
            if(pieces > K){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
};