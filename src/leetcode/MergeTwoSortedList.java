package leetcode;

public class MergeTwoSortedList {
	//Bottom Up
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1==null) return l2;
		else if(l2==null) return l1;
		else{
			if(l1.val<l2.val){
				l1.next=mergeTwoLists(l1.next,l2);
				return l1;
			}
			else{
				l2.next=mergeTwoLists(l1,l2.next);
				return l2;
			}
		}
	}
	public static void main(String args[]){
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		l1.insert(3);
		l1.insert(5);
		l1.insert(7);
		l1.insert(9);
		l1.insert(11);
		
		l2.insert(4);
		l2.insert(6);
		l2.insert(8);
		l2.insert(10);
		l2.insert(12);
		MergeTwoSortedList test=new MergeTwoSortedList();
		test.mergeTwoLists(l1, l2).printNode();
		return;
	}
}
