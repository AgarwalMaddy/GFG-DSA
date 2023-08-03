//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] nums, int n) {
        // code here
        long product = 1;
        long maxProduct = (long)Integer.MIN_VALUE;
        int i = 0;
        while(i < nums.length){
            product *= nums[i];
            if(product > maxProduct){
                maxProduct = product;
            }
            if(product == 0){
                product = 1;
            }
            i++;
        }
        product = 1;
        int j = n - 1;
        while(j > 0){
            product *= nums[j];
            if(product > maxProduct){
                maxProduct = product;
            }
            if(product == 0){
                product = 1;
            }
            j--;
        }
        
        return maxProduct;
    }
}