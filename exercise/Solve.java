package exercise;

public class Solve {
	 private boolean[][] visited;
	    private int m,n;
	    int[][] next = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
	    private void dfs(char[][] board,int i,int j){
	        if(i >= m || i < 0 || j >= n || j < 0 || visited[i][j] || board[i][j] == 'X') return;
	        visited[i][j] = true;
	        for(int k = 0;k < 4;k++){
	            dfs(board,i + next[k][0],j + next[k][1]);
	        }
	    }
	
	    public void solve(char[][] board) {
	        m = board.length;
	        n = board[0].length;
	        visited = new boolean[m][n];
	        for(int i = 0;i < m;i++){
	            for(int j = 0;j < n;j++){
	                if(i == 0 ||i == m - 1 || j == 0 || j == n - 1){
	                    if(board[i][j] == '0' && !visited[i][j]){
	                        dfs(board,i,j);
	                    }
	                }
	            }
	        }
	        for(int i = 0;i < m;i++){
	            for(int j = 0;j < n;j++){
	                if(!visited[i][j])
	                    board[i][j] = 'X';
	            }
	        }
	    }
	    public static void main(String[] args) {

			char[][] board = {{'X','X','X','X'},{'X','0','0','X'},{'X','X','0','X'},{'X','0','0','X'}};
			new Solve().solve(board);
			for(int i = 0;i < board.length;i++) {
				for(int j = 0;j < board[0].length;j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
	    }
}
