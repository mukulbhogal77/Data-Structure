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
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<len;i++) {
            char ch=str.charAt(i);
            if(ch=='(') {
                stack.push(ch);
            }
            else {
                if(!stack.isEmpty())  
                    if(stack.peek()=='(') {
                        c++;
                        stack.pop();
                    }
            }
        }
        return c*2;
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