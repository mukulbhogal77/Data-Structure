Problem : There are two singly linked lists of size N and M in a system. But, due to some programming error the end node of one of the linked list got linked into one of the node of second list, forming a inverted Y shaped list. Write a program to get the point where two linked lists intersect each other.

Solution:
 
 int intersectPoint(Node headA, Node headB)
{
         Node temp1=headA;int x=0;
         Node temp2=headB;int y=0;
         int finaldata=0;int diff=0;
         while(temp1 != null) {
             x++;
             temp1=temp1.next;
         }
         while(temp2 != null) {
             y++;
             temp2=temp2.next;
         }
         if(x>y){
            diff=(x-y);
            for(int i=0;i<diff;i++){
                headA=headA.next;
            }   
         }
         if(y>x){
            diff=(y-x); 
            for(int i=0;i<diff;i++){
                headB=headB.next;
            }   
         }
         while(headA!=null && headB!=null) {
             if(headA.next == headB.next) {
                 finaldata=headA.next.data;
                 break;
             }
             headA=headA.next;
             headB=headB.next;
         }
         return finaldata;
}
