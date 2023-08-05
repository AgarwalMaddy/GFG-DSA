//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    
		    Complete obj = new Complete();
		    int res = obj.maxPerimeter(arr, sizeOfArray);
		    
		    System.out.println(res);
		}
	}
}


            

// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maxPerimeter (int nums[], int n) {
        //Complete the function
        Arrays.sort(nums);
        int maxPeri = -1;
        int currPeri = 0;
        for(int i = 0 ; i < nums.length - 2 ; i++){
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            
            if(validTriangle(a , b , c)){
                currPeri = a + b + c;
                if(currPeri > maxPeri){
                    maxPeri = currPeri;
                }
            }
        }
        
        return maxPeri;
    }
    
    public static boolean validTriangle(int a , int b , int c){
        return ((a + b > c) && (a + c > b) && (b + c > a)) ;
    }
}


