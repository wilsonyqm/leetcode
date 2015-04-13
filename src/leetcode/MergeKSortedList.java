package leetcode;
import java.util.*;
public class MergeKSortedList {
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size()==0) return null;
        return helper(0,lists.size()-1,lists);
    }
	public ListNode helper(int left,int right,List<ListNode> lists){
		if(left>=right) return lists.get(left);
		int mid=left+(right-left)/2;
		ListNode l1=helper(left,mid,lists);
		ListNode l2=helper(mid+1,right,lists);
		return mergeTwoLists(l1,l2);
	}
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val){
			l1.next=mergeTwoLists(l1.next,l2);
			return l1;
		}
		else{
			l2.next=mergeTwoLists(l1,l2.next);
			return l2;
		}
	}
	
	
	//Another Solution with heap. Need to write new comparator and do the iteration push in every lists at the 
	//same time when popping out the element.
//	public ListNode mergeKLists(List<ListNode> lists) {
//        if (lists == null || lists.size() == 0) {
//            return null;
//        }
//        int size = lists.size();
//        // create a heap with Java priority queue, set the initial size
//        Queue<ListNode> heap = new PriorityQueue(size, new NodeComparator());
//        // add all ListNode into the heap
//        for (ListNode node: lists) {
//            if (node != null) {
//                heap.add(node);
//            }
//        }
//        // start to link nodes from smallest to largest
//        ListNode dummy = new ListNode(0);
//        ListNode p = dummy;
//        while (!heap.isEmpty()) {
//            p.next = heap.remove();
//            p = p.next;
//            if (p.next != null) {
//                heap.add(p.next);
//            }
//        }
//        return dummy.next;
//    }
//
//    class NodeComparator implements Comparator<ListNode> {
//        public int compare(ListNode n1, ListNode n2) {
//            return n1.val - n2.val;
//        }
//    }
}
