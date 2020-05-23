Problem:
Given a matrix of dimension r*c where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

Solution:

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int dir[]= new int[] {0, 1, 0, -1, 0};
    public static int rottonOranges(int arr[][]) {
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j]==2){
                    q.add(new int[] {i,j});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int size=q.size();
            for(int i=0;i<size;i++) {
                int curr[]=q.poll();
                for(int j=0;j<4;j++) {
                    int x=curr[0]+dir[j];
                    int y=curr[1]+dir[j+1];
                    if(0<=x && 0<=y && x<arr.length && y<arr[0].length && arr[x][y]==1) {
                        arr[x][y]=2;
                        q.add(new int[] {x,y});
                    }
                }
            }
            if(!q.isEmpty()) count++;
        }
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1) return -1;
            }
        }
        return count;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int row=sc.nextInt();
		    int column=sc.nextInt();
		    int arr[][]=new int[row][column];
		    for(int i=0;i<row;i++) {
		        for(int j=0;j<column;j++) {
		            arr[i][j]=sc.nextInt();
		        }
		    }
		    System.out.println(rottonOranges(arr));
		}
	}
}