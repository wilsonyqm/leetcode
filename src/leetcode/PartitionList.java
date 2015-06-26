package leetcode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode leftdummy=new ListNode(0);
        ListNode rightdummy=new ListNode(0);
        ListNode left=leftdummy;
        ListNode right=rightdummy;
        //leftdummy will connect by itself.
        
        while(head!=null){
            if(head.val<x){
                left.next=head;
                left=left.next;
            }
            else{
                right.next=head;
                right=right.next;
            }
            head=head.next;
        }
        right.next=null;//you have to assign here otherwise it will be a self loop
        left.next=rightdummy.next;
        return leftdummy.next;
    }
}
