package leetcode;
import java.util.*;
public class NQueen {
    private void search(int n, ArrayList<Integer> cols, ArrayList<String[]> result) {
    	if(cols.size()==n) {
    		result.add(drawChessboard(cols));
    		return;
    	}
    		for(int j=0;j<n;j++){
    			if(!isValid(cols,j)){
    				continue;
    			}
    			cols.add(j);
    			search(n,cols,result);
    			cols.remove(cols.size()-1);
    		}
    }
    
    private String[] drawChessboard(ArrayList<Integer> cols) {
    	int size=cols.size();
    	String[] string=new String[size];
    	for(int i=0;i<size;i++){
    		StringBuilder str=new StringBuilder();
    		int index=cols.get(i);
    		for(int j=0;j<size;j++){
    			if(j==index) str.append('Q');
    			else str.append(".");
    		}
    		string[i]=str.toString();
    	}
    	return string;
    }
	private boolean isValid(ArrayList<Integer> cols, int col) {
    	int row=cols.size();
    	for(int i=0;i<row;i++){
    		if(cols.get(i)==col) return false;
    		if(i-cols.get(i)==row-col) return false;//this can be simplified with an absolute value 
    		if(i+cols.get(i)==row+col) return false;
    	}
    	return true;
    }
    public ArrayList<String[]> solveNQueens(int n) { 
    	ArrayList<String[]> result=new ArrayList<String[]>();
    	if(n<=0) return result;
        ArrayList<Integer> cols=new ArrayList<Integer>();
        search(n,cols,result);
        return result;
    }
    public int totalNQueens(int n) { //for NQUEEN for only number, u can use only an array and override every time, so don't have to remove.
    	//also, only count the sum would be fine.
    	ArrayList<String[]> result=new ArrayList<String[]>();
    	if(n<=0) return 0;
        ArrayList<Integer> cols=new ArrayList<Integer>();
        search(n,cols,result);
        return result.size();
    }
    public static void main(String args[]){
    	NQueen queen=new NQueen();
    	ArrayList<String[]> result=queen.solveNQueens(5);
    	for(String[] str:result){
    		for(String string:str){
    			System.out.println(string);
    		}
    		System.out.println("");
    	}
    	return;
    }
}
