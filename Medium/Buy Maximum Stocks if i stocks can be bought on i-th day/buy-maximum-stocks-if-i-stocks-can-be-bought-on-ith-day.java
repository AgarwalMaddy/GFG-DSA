//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        long[] array = new long[n];
        
        for(int i = 0 ; i < n ; i++){
            array[i] = price[i] * 100000 + (i+1);
        }
        
        Arrays.sort(array);
        
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            int cost = (int)array[i] / 100000;
            int quantity = (int)array[i] % 100000;
            
            if(cost * quantity > k){
                count += k / cost;
                k = k - cost * (k / cost);
            }else{
                count = count + quantity;
                k = k - cost * quantity;
            }
        }
        
        return count;
    }
}
        
