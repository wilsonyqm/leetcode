package leetcode;
import java.util.*;
public class LRU {
	DoubleLinkedList head;
	DoubleLinkedList tail;
	HashMap<Integer,DoubleLinkedList> map;
	int capacity;
	public LRU(int capacity){
		this.capacity=capacity;
		this.head=null;
		this.tail=null;
		this.map=new HashMap<Integer,DoubleLinkedList>();
	}
	public void remove(DoubleLinkedList node){
		if(head==node&&tail==node){
			head=null;
			tail=null;
		}
		else if(node==head){
			head=node.next;
			head.prev=null;
		}
		else if(node==tail){
			tail.prev.next=null;
			tail=tail.prev;
		}else{
			node.prev.next=node.next;
			node.next.prev=node.prev;
		}
		node.prev=null;
		node.next=null;//deal with node separately
	}
	public void sethead(DoubleLinkedList node){
		if(head!=null) head.prev=node;
		if(tail==null) tail=node;
		node.next=head;
		node.prev=null;
		head=node;
	}
	public int get(int key){
		if(!map.containsKey(key)) return -1;
		DoubleLinkedList cur=map.get(key);
		int value=cur.val;
		remove(cur);
		sethead(cur);
		return value;
	}
	public void set(int key,int value){
			if(map.containsKey(key)){
				DoubleLinkedList cur=map.get(key);
				remove(cur);
				cur.val=value;
				sethead(cur);
			}else{
				DoubleLinkedList cur=new DoubleLinkedList(key,value);
				if(map.size()<capacity){
					sethead(cur);
					map.put(key, cur);
				}else{
					map.remove(tail.key);
					remove(tail);
					sethead(cur);
					map.put(key,cur);
				}
			}
	}
	public class DoubleLinkedList{
		DoubleLinkedList prev;
		DoubleLinkedList next;
		int val;
		int key;
		public DoubleLinkedList(int k,int v){
			this.key=k;
			this.val=v;
		}
	}
}
