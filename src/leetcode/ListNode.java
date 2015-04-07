package leetcode;

public class ListNode {
		  int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	      public void insert(int value){
	    	  ListNode node=new ListNode(value);
	    	  ListNode cur=this;
	    	  while(cur.next!=null){
	    		  cur=cur.next;
	    	  }
	    	  cur.next=node;
	    	  return;
	      }
	      public void printNode(){
	    	  ListNode node=this;
	    	  System.out.print(node.val);
	    	  while(node.next!=null){
	    		  System.out.print("->"+node.next.val);
	    		  node=node.next;
	    	  }
	    	  System.out.println();
	    	  return;
	      }
}
