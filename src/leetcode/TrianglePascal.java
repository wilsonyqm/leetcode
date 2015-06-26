package leetcode;
import java.util.*;
//[
// [1],
//[1,1],
//[1,2,1],
//[1,3,3,1],
//[1,4,6,4,1]
//]
public class TrianglePascal {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList(); 
        for(int i=0;i<numRows;i++){
            temp.add(0,1);
            for(int j=1;j<temp.size()-1;j++){
                temp.set(j,temp.get(j)+temp.get(j+1));
            }
            list.add(new ArrayList(temp));//has to add a new arraylist!! Otherwise the result of first row would be [1,1], since it has been referenced with the same local variable
        }
        return list;
    }
}
