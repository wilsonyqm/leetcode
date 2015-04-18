package leetcode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head){
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(-1);
		dummy.next=head;
		ListNode unsort=head.next;//head next here
		head.next=null;//since we r constructing a new list here, so the old list should be deleted.
		while(unsort!=null){
			ListNode pos=dummy;
			ListNode cur=unsort;
			unsort=unsort.next;//determine ahead which node to insert
			while(pos.next!=null  && pos.next.val<cur.val) pos=pos.next;
			//find the position node been inserted
			//insert cur into position
			//better to use next for iteration here, in order to get rid of null in next line of code
			cur.next=pos.next;
			pos.next=cur;
		}
		return dummy.next;
    }
    //most important is first cut the list to two parts with head and the other list,
    //iterate the list and insert into the head list by order.
}
