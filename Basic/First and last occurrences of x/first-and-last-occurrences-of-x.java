//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    public static ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        ArrayList<Long> resultArray = new ArrayList<>();
        int start = startIndex(arr,n,x);
        int end = endIndex(arr,n,x);
        resultArray.add((long)start);
        resultArray.add((long)end);
        return resultArray;
    }
    public static int startIndex(long arr[] , int n , int x){
        int start = 0;
        int end = n-1;
        int result = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == x){
                result = mid;
                end = mid - 1;
            } else if(arr[mid] > x){
                end = mid - 1;
            } else {
                start = mid  + 1;
            }
        }
        return result;
    }
    
    public static int endIndex(long arr[] , int n , int x){
        int start = 0;
        int end = n-1;
        int result = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == x){
                result = mid;
                start = mid + 1;
            } else if(arr[mid] > x){
                end = mid - 1;
            } else {
                start = mid  + 1;
            }
        }
        return result;
    }
    
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends