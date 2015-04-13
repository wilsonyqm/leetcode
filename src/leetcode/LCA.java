package leetcode;

public class LCA {
	public TreeNode LCAMethod(TreeNode root,TreeNode p,TreeNode q){
		if(root==null||p.val==root.val||q.val==root.val) return root;
		else{
		
		TreeNode left=LCAMethod(root.left,p,q);
		//there didn't use root.left=LCAMethod(root.left,p,q) and if we use this method,
		//it will be a bottom up trace for constructing a tree;
		// with getting a new node, we can easily compare;
		//System.out.println("HI 1 ");
		TreeNode right=LCAMethod(root.right,p,q);
		//System.out.println("HI 2");
		if(left!=null&&right!=null) return root;
		if(left!=null) return left;
		else return right;
		}
	}
		
	//insert is used for tests;
	//recursion call is better;
	public void insert(TreeNode root,int element){
	    if(root == null){
	        root = new TreeNode(element);
	        return;
	    }
	    TreeNode runner = root;
	    while (runner.val!= element){
	        if(runner.val > element){
	            if(runner.left== null){
	                runner.left= new TreeNode(element);
	                return;
	            }
	            runner = runner.left;
	        } else {
	            if(runner.right== null){
	                runner.right= new TreeNode(element);
	                return;
	            }
	            runner = runner.right;
	        }
	    }
	}
	//this code below won't work, it is a bottom up process and will always insert for the first node, which is not good.
	//the improvement is the
	
	
	public static void main(String args[]){
		LCA tree= new LCA();
		TreeNode root1=new TreeNode(10);
		int[] arrs= new int[]{5,7,1,3,6,4,9,12,11,13,14};
		for(int arr:arrs){
			root1.insert1(arr);
			System.out.println("Insert Node: "+arr);
		}
		
		TreeNode p=new TreeNode(4);
		TreeNode q=new TreeNode(9);
		System.out.println(root1.left.val+"For Node:"+p.val+" Node: "+q.val);
		TreeNode res=tree.LCAMethod(root1,p,q);
		System.out.println("LCA is "+res.val);
	}
}
