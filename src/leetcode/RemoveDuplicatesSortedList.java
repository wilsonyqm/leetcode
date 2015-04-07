package leetcode;

public class RemoveDuplicatesSortedList {//second question
	public ListNode deleteDuplicates(ListNode head) {
		//needs three pointer: prev,first,curr.
		//prev for the while loop prev node to record the value to compare
		//curr is the iteration pointer
		//first is the helper node which helps to find the root
		ListNode first=new ListNode(-1);
		first.next=head;
		ListNode prev=first;
		ListNode curr=head;
		while(curr!=null){
			while(curr.next!=null && prev.next.val==curr.next.val){
				curr=curr.next;
			}
			if(curr==prev.next)
				prev=curr;//this is for keeping the connections// no disconnection, but just move pointer
			else
				prev.next=curr.next;//this is for disconnecting the connections by changing next and not move pointer
			curr=curr.next;
		}
		return first.next;
    }	
	public static void main(String args[]){
		RemoveDuplicatesSortedList test= new RemoveDuplicatesSortedList();
		ListNode root=new ListNode(1);
		root.insert(1);
		root.insert(1);
		root.insert(1);
		root.insert(2);
		root.insert(2);
		root.insert(3);
		root=test.deleteDuplicates(root);
		if(root==null) {
			System.out.println("NULL");
			return;
		}
		while(root.next!=null){
			System.out.print(root.val+"->");
			root=root.next;
		}
		System.out.println(root.val);
		return;
	}
}
