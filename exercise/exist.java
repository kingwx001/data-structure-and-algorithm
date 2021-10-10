package exercise;

public class exist {
	boolean[][] visited;
    int x,y;
    int[][] direction;
    boolean isExist;


    private boolean inArea(int i,int j){
        return i < x && i >= 0 && j < y && j >= 0;
    }


    private void dfs(char[][] board,String word,int index,int i,int j){
   
        if(index == word.length() - 1 && board[i][j] == word.charAt(index)){
            isExist = true;
            return;
        }
        for(int k = 0;k < 4;k++){
        	visited[i][j] = true;
        	System.out.println(i + direction[k][0] + "\t" + (j + direction[k][1]));
        	System.out.println(i + "\t" + j);
        	System.out.println(index);
            if(inArea(i + direction[k][0],j + direction[k][1]) && !visited[i+ direction[k][0]][j + direction[k][1]] && board[i][j] == word.charAt(index)){
            	if(board[i + direction[k][0]][j + direction[k][1]] == word.charAt(index + 1))
            	dfs(board,word,index + 1,i + direction[k][0],j + direction[k][1]);
            }
            //visited[i][j] = false;
        }
    }
    public boolean exist2(char[][] board, String word) {
        x = board.length;
        y = board[0].length;
        visited = new boolean[x][y];
        isExist = false;
        direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0;i < x;i++) {
        	for(int j = 0;j < y;j++) {
        		if(board[i][j] == word.charAt(0)) {
        			dfs(board,word,0,i,j);
        			if(isExist) break;
        		}
        	}
        	if(isExist) break;
        }
        
        return isExist; 
    }
    public static void main(String[] args) {
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "CECS";
		System.out.println(new exist().exist2(board,word));
		}
}
