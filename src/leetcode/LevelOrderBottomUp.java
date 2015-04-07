package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottomUp {
	public ArrayList<List<Integer>> levelOrder(TreeNode root){
		ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root==null) return result;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			List<Integer> level=new LinkedList<Integer>();
			int size=queue.size();
			for(int i=0;i<size;i++){
				TreeNode newnode= queue.poll();
				level.add(newnode.val);
				if(newnode.left!=null) queue.offer(newnode.left);
				if(newnode.right!=null) queue.offer(newnode.right);
			}
			result.add(0,level);
		}
		return result;
	}
	public static void main(String args[]){
		LevelOrderBottomUp test=new LevelOrderBottomUp();
		TreeNode root=new TreeNode(9);
		root.insert1(3);
		root.insert1(1);
		root.insert1(15);
		root.insert1(13);
		root.insert1(20);
		ArrayList<List<Integer>> result= test.levelOrder(root);
		for(List<Integer> i: result){
			for(Integer j:i){
				System.out.println(j+" ");
			}
		}
	}
}
