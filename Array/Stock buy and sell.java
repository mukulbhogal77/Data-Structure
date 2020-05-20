Problem:
The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
Solution: 
import java.util.*;
import java.lang.*;
import java.io.*;

class Interval { 
    int buy, sell; 
}

class GFG {
    
    public static void buySell(int arr[], int n) {
        if(n==1)
            return;
        int count=0;
        ArrayList<Interval> list=new ArrayList<Interval>();
        int i=0;
        while(i<n-1) {
            while((i<n-1) && arr[i+1]<=arr[i])
                i++;
                
            if(i==n-1)
                break;
                
            Interval obj=new Interval();
            obj.buy=i++;
            
            while((i<n) && arr[i]>=arr[i-1])
                i++;
                
            obj.sell=i-1;
            list.add(obj);
            count++;
        }
        if(count==0) System.out.print("No Profit");
        else {
                for(int j=0;j<count;j++) {
                System.out.print("("+list.get(j).buy+" "+list.get(j).sell+")"+" ");
            }
        
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
		    buySell(arr,n);
		    System.out.println();
		}
	}
}
