//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		array[i] = sc.nextInt();
        	}
        	int target = sc.nextInt();

            Solution ob = new Solution();
			System.out.println(ob.Search(array,target));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int Search(int array[], int target)
	{
	    // code here
	    int pivot = pivotElement(array);
	    if(pivot == -1){
	        return binarySearch(array , target , 0 , array.length - 1);
	    }
	    
	    if(array[pivot] == target){
	        return pivot;
	    }
	    if(target >= array[0]){
	        return binarySearch(array , target , 0 , pivot - 1);
	    }
	    return binarySearch(array , target , pivot + 1 , array.length - 1);
	}
	
	static int binarySearch(int[] array , int target , int start , int end){
	    while(start <= end){
	        int mid = start + (end - start)/ 2;
	        if(array[mid] == target){
	            return mid;
	        } else if(array[mid] > target){
	            end = mid - 1;
	        } else {
	            start = mid + 1;
	        }
	    }
	    return -1;
	}
	
	static int pivotElement(int[] array){
	    int start = 0;
	    int end = array.length - 1;
	    while(start <= end){
	        int mid = start + (end - start)/2;
	        if(mid < end && array[mid] > array[mid + 1]){
	            return mid;
	        } else if(mid > start && array[mid] < array[mid - 1]){
	            return mid - 1;
	        } else if(array[mid] >= array[start]){
	            start = mid + 1;
	        } else {
	            end = mid - 1;
	        }
	    }
	    return -1;
	}
} 

