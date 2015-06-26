package leetcode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode cur=head;
        while(cur!=null && cur.next!=null){
            ListNode next=cur.next;
            prev.next=next;
            cur.next=next.next;
            next.next=cur;
            prev=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}
