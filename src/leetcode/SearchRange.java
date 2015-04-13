package leetcode;

public class SearchRange {
	//this method has more complexity
	public int[] searchRange(int[] A, int target) {
        int left=0;
        int right=A.length-1;
        int[] res=new int[]{-1,-1};
        int mid=left+(right-left)/2;
        while(left+1<right){
        	mid=left+(right-left)/2;
        	if(A[mid]<=target){
        		left=mid;
        	}
        	else{
        		right=mid;
        	}
        }
        if(A[left]!=target && A[right]!=target) return res;
        if(A[left]==target) mid=left;
        else mid=right;
        int i=0;
        while(mid-i>=0 && A[mid]==A[mid-i]) i++;
        int j=0;
        while(mid+j<A.length && A[mid]==A[mid+j]) j++;
        res[0]=mid-i+1;
        res[1]=mid+j-1;
        return res;
	}
	//this method below is the better solution
    public int[] searchRange1(int[] A, int target) {
        int start, end, mid;
        int[] bound = new int[2]; 
        
        // search for left bound
        start = 0; 
        end = A.length - 1;
        //this is the standard divide and conquer method in NineChapter!
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;//go left
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;//go right;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
    }

}
