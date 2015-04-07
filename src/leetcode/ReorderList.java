package leetcode;

public class ReorderList {
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
	    	int index=0;
	    	while(head1!=null && head2!=null){
	    		if(index%2==0){
	    			temp.next=head1;
	    			head1=head1.next;
	    		}
	    		else{
	    			temp.next=head2;
	    			head2=head2.next;
	    		}
	    		index++;
	    		temp=temp.next;//really need this dummy node for connecting.
	    	}
	    	//needs to connect the rest code
	    	if(head1!=null) temp.next=head1;//temp is the last node now, so it connects to the latter node
	    	if(head2!=null) temp.next=head2;
	    	
	    	return dummy.next;
	    }
	    private ListNode reverse(ListNode head){
	    	if(head==null || head.next==null) return head;
	    	
	    	ListNode prev=new ListNode(0);
	    	prev=head;
	    	head=head.next;
	    	prev.next=null;//this is necessary or it will a infinite loop// if pre=new null we don't need this
	    	while(head!=null){
	    		ListNode temp=head.next;
	    		head.next=prev;
	    		prev=head;
	    		head=temp;
	    	}
	    	return prev;
	    }
	    public void reorderList(ListNode head) {
	    	if(head==null || head.next==null) return;
	    	ListNode mid=findMiddle(head);
	    	ListNode right=reverse(mid.next);
	    	mid.next=null;
	    	merge(head,right);
	    }
	    public static void main(String args[]){
			ReorderList test=new ReorderList();
			ListNode root= new ListNode(6);
			root.insert(5);
			root.insert(13);
			root.insert(23);
			root.insert(2);
			root.insert(1);
			root.printNode();
			test.reorderList(root);
			root.printNode();
	    }
}
