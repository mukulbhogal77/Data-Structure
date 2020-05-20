Problem:
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 

Solution:
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void span(int arr[], int n) {
        int res[]=new int[n];
        Stack<Integer> s=new Stack<>();
        s.push(arr[0]);
        res[0]=1;
        for(int i=1;i<n;i++) {
            if(arr[i]<s.peek()) {
                res[i]=1;
                s.push(arr[i]);
            }
            else {
                res[i]=1;
                Stack<Integer> s1=new Stack<>();
                while(!s.isEmpty()) {
                    res[i]+=1;
                    s1.push(s.pop());
                    if(!s.isEmpty() && s.peek()>arr[i]) 
                        break;    
                }
                while(!s1.isEmpty()) {
                    s.push(s1.pop());
                }
                s.push(arr[i]);
            }
        }
        for(int i=0;i<n;i++) {
            System.out.print(res[i]+" ");
        }
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    span(arr,n);
		    System.out.println();
		}
	}
}