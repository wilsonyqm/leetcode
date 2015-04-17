package leetcode;
import java.util.*;
import java.util.Map.Entry;
public class WandouJiaQuestion1 {
	public int question1(int[] A){
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
        if(A.length<=1) return A.length;
        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i])){
                ArrayList<Integer> temp=map.get(A[i]);
                temp.add(i);
                map.put(A[i],temp);
            }
            else{
                ArrayList<Integer> temp2=new ArrayList<Integer>();
                temp2.add(i);
                map.put(A[i],temp2);
            }
        }
        //find height
        for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey());
            System.out.print("Value = ");
            for(int v:entry.getValue()){
            	System.out.print(" "+ v);
            }
            System.out.println();
        }
        return helper(map,-1);
    }
    
    public int helper(HashMap<Integer,ArrayList<Integer>> map,int k){
        int depth=0;
        if(map.containsKey(k))
            for(int temp:map.get(k)){
                depth=Math.max(depth,helper(map,temp));
            }
        return depth+1;
    }
    public static void main(String args[]){
    	int[] A=new int[]{3, 3 ,3 ,-1, 2, 3, 4, 5, 6};
    	WandouJiaQuestion1 test=new WandouJiaQuestion1();
    	System.out.println(test.question1(A));
    	
    }

}
