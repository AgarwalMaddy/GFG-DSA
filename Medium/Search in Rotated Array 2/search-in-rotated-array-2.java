//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine().trim());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int Key;
            Key = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            boolean res = obj.Search(N, A, Key);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean Search(int N, int[] nums, int target) {
        // code here
        int pivot = pivotElement(nums);
        int result = -2;
        if(pivot == -1){
            result = binarySearch(nums , target , 0 , N - 1);
            if(result != -1){
                return true;
            }
            return false;
        }
        
        if(nums[pivot] == target){
            return true;
        }
        if(target >= nums[0]){
            result = binarySearch(nums , target , 0 , pivot - 1);
            if(result != -1){
                return true;
            }
            return false;
        }
        
        result = binarySearch(nums , target, pivot+1 , N - 1);
        if(result != -1){
            return true;
        }
        return false;
    }
    public static int binarySearch(int[] nums , int target , int start , int end){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public static int pivotElement(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            } else if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                if(mid > start && nums[start] > nums[start + 1]){
                    return start;
                }
                start++;
                if(mid < end && nums[end] < nums[end - 1]){
                    return end - 1;
                }
                end--;
            } else if(nums[start] < nums[mid] || nums[start] == nums[mid] && nums[mid] > nums[end]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}
        
