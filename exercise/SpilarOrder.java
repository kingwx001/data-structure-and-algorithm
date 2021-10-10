package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpilarOrder {
	    private int m;
	    private int n;
	    private int k = 0;
	    private boolean[][] visited;
	    private List<Integer> res = new ArrayList<>();
	    int[][] next = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
	    boolean dfs(int[][] matrix,int i,int j){
	        if(res.size() == m * n) return true;
	        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
	            return false;
	        visited[i][j] = true;
	        res.add(matrix[i][j]);
	        if(!dfs(matrix,i + next[k][0],j + next[k][1])){
	            k = (k + 1) % 4;
	            dfs(matrix,i + next[k][0],j + next[k][1]);
	        }
	        return true;
	    }
	    public List<Integer> spiralOrder(int[][] matrix) {
	        m = matrix.length;
	        n = matrix[0].length;
	        visited = new boolean[m][n];
	        dfs(matrix,0,0);
	        return res;
	    }
    public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		List<Integer> list = new SpilarOrder().spiralOrder(matrix);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
