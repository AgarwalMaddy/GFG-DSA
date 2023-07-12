//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int A[], int l, int h, int key)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        int pivot = pivotElement(A);
        if(pivot == -1){
            return binarySearch(A , key , l , h);
        }
        
        if(A[pivot] == key){
            return pivot;
        }
        if(key >= A[0]){
            return binarySearch(A , key , l , pivot - 1);
        } 
        return binarySearch(A , key , pivot + 1 , h);
        
    }
    
    int binarySearch(int A[] , int key , int start , int end){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(A[mid] == key){
                return mid;
            } else if(A[mid] > key){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    int pivotElement(int A[]){
        int start = 0;
        int end = A.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && A[mid] > A[mid + 1]){
                return mid;
            } else if(mid > start && A[mid] < A[mid - 1]){
                return mid - 1;
            } else if(A[mid] >= A[start]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}