package leetcode;
//首先从head开始跑，直到最后一个节点，这时可以得出链表长度len。然后将尾指针指向头指针，
//将整个圈连起来，接着往前跑len – k%len，从这里断开，就是要求的结果了。
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
//		Given 1->2->3->4->5->NULL and k = 2,
//				return 4->5->1->2->3->NULL.
	        if(k==0) return head;
			ListNode fast=head;
			int len=1;
			if(head==null) return null;
			while(fast.next!=null){
				fast=fast.next;
				len++;
			}
			fast.next=head;
			k=len-k%len;
			while(--k>0) head=head.next;
			ListNode dummy=head.next;
			head.next=null;
			return dummy;
	    
    }
	public static void main(String args[]){
		RotateList test=new RotateList();
		ListNode root=new ListNode(1);
		root.insert(2);
		root.insert(3);
		root.insert(4);
		root.insert(5);
		
		test.rotateRight(root, 3).printNode();
		
	}
}
