Problem:
Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.
Solution:
/*package whatever //do not write package name here */


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static int checkValid(String str, int len) {
        int c=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<len;i++) {
            char ch=str.charAt(i);
            if(ch=='(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if(!stack.isEmpty())  
                    c=Math.max(c,i-stack.peek());
                else 
                    stack.push(i);
            }
        }
        return c;
    }
    
	public static void main (String[] args) {
	   Scanner sc=new Scanner(System.in);
	   int t=sc.nextInt();
	   while(t-->0) {
	       String str=sc.next();
	       System.out.println(checkValid(str,str.length()));
	   }
	}
}