package leetcode;

public class LinkedListCycle {
	public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
        }
        if(fast!=slow) return null;//has to add base case for head=fast=slow
        while(head!=slow){
            head=head.next;
            slow=slow.next;
        }
        return head;
    }
}
