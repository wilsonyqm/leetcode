package leetcode;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        ListNode node=head;
        ListNode prev=new ListNode(-1);
        prev.next=head;
        if(head.next==null && n==1) return null;
		while(n>0){
			temp=temp.next;
			n--;
        }
        if(temp==null) {
            prev.next=node.next;// quite important for the case of n is the length of the list.
            //so we have to deal with the head properly.
        }
        else{
		    while(temp.next!=null){
    			temp=temp.next;
    			node=node.next;
		    }
		    node.next=node.next.next;
		}
		return prev.next;
    }
}
