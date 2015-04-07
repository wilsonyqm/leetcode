package leetcode;

public class SortList {
    private ListNode findMiddle(ListNode head) {
    	if(head.next==null||head==null) return head;
    	ListNode fast=head.next;//this is a classical method
    	ListNode slow=head;
    	while(fast!=null&&fast.next!=null){
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	return slow;
    }
    private ListNode merge(ListNode head1, ListNode head2) {
    	ListNode dummy=new ListNode(-1);
    	ListNode temp=dummy;
    	while(head1!=null && head2!=null){
    		if(head1.val<head2.val){
    			temp.next=head1;
    			head1=head1.next;
    		}
    		else{
    			temp.next=head2;
    			head2=head2.next;
    		}
    		temp=temp.next;//really need this dummy node for connecting.
    	}
    	//needs to connect the rest code
    	if(head1!=null) temp.next=head1;//temp is the last node now, so it connects to the latter node
    	if(head2!=null) temp.next=head2;
    	
    	return dummy.next;
    }
    public ListNode sortList(ListNode head) {
    	if(head==null || head.next==null) return head;
    	ListNode mid=findMiddle(head);
    	ListNode right=sortList(mid.next);
    	mid.next=null;//disconnect middle so there will only sort the first half;
    	ListNode left=sortList(head);
    	return merge(left,right);
    }
    public static void main(String args[]){
		SortList test=new SortList();
		ListNode root= new ListNode(6);
		root.insert(5);
		root.insert(13);
		root.insert(23);
		root.insert(2);
		root.insert(1);
		root.printNode();
		ListNode temp=test.sortList(root);
		temp.printNode();
    }
}
