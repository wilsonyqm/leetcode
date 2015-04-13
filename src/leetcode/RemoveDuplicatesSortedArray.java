package leetcode;

public class RemoveDuplicatesSortedArray {
	//this is more complicated in logic
	public int removeDuplicateswithEqual(int[] A){
		int len=A.length;
        if(len<=1) return len;
        int i=0,j=1,res=0;
        while(i<len && j<len){
            while(j<len && A[i]==A[j]){
                j++;
            }
            A[res]=A[i];
            i=j;
            res++;
        }
        return res;
	}
	//this works greater on logic, if the iteration is larger than A[j] than get it replaced and j++;
	public int removeDuplicateswithLarger(int[] A){
		if(A.length==0) return 0;
	    int j=0;
	    for(int i=0;i<A.length;i++){
	        if(A[i]>A[j]) A[++j]=A[i];
	    }
	    return j+1;
	}
}
