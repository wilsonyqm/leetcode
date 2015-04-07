package leetcode;

public class ReverseLinkedList {
	public ListNode reverse(ListNode root){
		//Not necessary if(root==null||root.next==null) return root;
		//if prev= new ListNode(-1) then the sentence above is necessary and need remove head and prev one step further.
		ListNode prev=null;
		while(root!=null){
			ListNode next=root.next;
			root.next=prev;
			prev=root;
			root=next;
		}
		return prev;
	}
	
	
	public ListNode reverse(ListNode head,int m,int n){//reverse start from m and end at n;
		ListNode prev=new ListNode(-1);//dummy node to avoid null pointer on line 44
		prev.next=head;
		ListNode first=prev;//dummy code for remembering the first node, has to consider m==1 so the head will change.
		ListNode start_front=null;//since start_front=prev latter so its also a dummy code
		ListNode start_back=null;
		for(int i=0;i<m-1;i++){
			prev=head;
			head=head.next;
		}
		//record the chain break point before and after node 1->2, if change from 2 then it is import to remember both 1 and 2
		
		start_front=prev;
		start_back=head;
		
		//move forward one step which is convenient for reverse in a range.
		prev=head;
		head=head.next;
		//start to reverse
		for(int j=0;j<n-m;j++){
			ListNode next=head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		//so 4->5 is the break point then prev is 4 and head is 5;
		//so start to connect start and end;
		start_front.next=prev;
		start_back.next=head;
		return first.next;
	}
	//One of the Import rules is as follwing:
	//  prev<-root  next
	//        prev  root  next
	//every iteration, u have to have a new next and assign the root.next to be prev
	//prev to be null at first;
	//iteration stops at root is null and return prev which is the end of the list
	public static void main(String args[]){
		ReverseLinkedList test=new ReverseLinkedList();
		ListNode root= new ListNode(6);
		root.insert(5);
		root.insert(4);
		root.insert(3);
		root.insert(2);
		root.insert(1);
		root.printNode();
		ListNode temp=test.reverse(root);
		temp.printNode();
		test.reverse(temp,2,4).printNode();
	}
}
