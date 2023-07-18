//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int A[], int N)
    {
        // your code here
        return binarySearch(A, N);
    }
    public static int binarySearch(int A[] , int N){
        if(N == 1){
            return A[0];
        } else if(A[0] != A[1]){
            return A[0];
        } else if(A[N-1] != A[N-2]){
            return A[N-1];
        } else {
            int start = 1;
            int end = N-2;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(A[mid] != A[mid-1] && A[mid] != A[mid + 1]){
                    return A[mid];
                } else if((mid % 2 == 0 && A[mid] == A[mid-1])||(mid % 2 == 1 && A[mid] == A[mid+1])){
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}