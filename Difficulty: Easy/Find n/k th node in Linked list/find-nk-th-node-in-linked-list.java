//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class LinkedList {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            Solution ob = new Solution();
            int res = ob.fractional_node(head, k);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public static int fractional_node(Node head, int k) {
        // Your code here
        Node temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        temp = head;
        int index = 0;
        if(length % k != 0){
            index = length/k + 1;
        }else{
            index = length / k;
        }
        int count = 0;
        int result = 0;
        while(temp != null){
            count++;
            if (count == index){
                result = temp.data;
            }
            temp = temp.next;
        }
        
        return result;
    }
}
