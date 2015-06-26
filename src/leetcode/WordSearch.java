package leetcode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        char[] w= word.toCharArray();
        boolean[][] b=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(back(board,w,i,j,0,b))
                    return true;
            }
        }
        return false;
    }
    public boolean back(char[][]board, char[] word, int i,int j,int k,boolean[][] b){
        if(word[k]!=board[i][j]) return false;
        if(k==word.length-1) return true;
        b[i][j]=true;
        //amazon interview if can stay at the same point.
        //up
        if(i>0&&b[i-1][j]==false&& back(board,word,i-1,j,k+1,b)) return true;
        //down
        if(i<board.length-1&&b[i+1][j]==false&& back(board,word,i+1,j,k+1,b)) return true;
        //left
        if(j>0&&b[i][j-1]==false&&back(board,word,i,j-1,k+1,b)) return true;
        //right
        if(j<board[0].length-1 && b[i][j+1]==false&&back(board,word,i,j+1,k+1,b)) return true;
        b[i][j]=false; ///set all the path unvisited!!!!!!!!!!!!!!!!!!!!!!!!!!
       return false; 
    }
}
