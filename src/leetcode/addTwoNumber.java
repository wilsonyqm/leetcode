package leetcode;

public class addTwoNumber {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        int num=0,val=0;
        ListNode prev=new ListNode(-1);
        ListNode head=prev;
        while(l1!=null || l2!=null || carry!=0){
        	if(l1==null && l2!=null) 
            	num=l2.val+carry;
        	else if(l2==null && l1!=null) 
            	num=l1.val+carry;
        	else if(l2==null && l1==null) 
        		num=carry;
        	else 
        		num=l1.val+l2.val+carry;
        	
        	//there is a simple way to write this 
        	//            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
//niu bi
        	val=num%10;
        	carry=num/10;
        	ListNode tmp=new ListNode(-1);
        	tmp.val=val;
        	head.next=tmp;
        	head=head.next;
        	l1 = (l1==null) ? l1:l1.next;
        	
        	l2 = (l2==null) ? l2:l2.next;
        }
        return prev.next;
    }
	public static void main(String args[]){
		addTwoNumber test=new addTwoNumber();
		ListNode l1=new ListNode(1);
		l1.insert(9);
		l1.insert(9);
		ListNode l2=new ListNode(1);
		l2.insert(9);
		l2.insert(9);		
		l1.printNode();
		l2.printNode();
		test.addTwoNumbers(l1, l2).printNode();
	}
}
