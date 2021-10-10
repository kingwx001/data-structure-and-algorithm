package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SpilarOrder2 {
	private class toRight implements Runnable{
        public void run(){
            synchronized(SpilarOrder2.class){
                
                while(true){
                if(res.size() == m * n) return;
                if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]){
                j--;
                notify();
            }
                visited[i][j] = true;
                res.add(matrix[i][j]);
                j++;
            } 
        }
        }
    }
    private class toBottom implements Runnable{
        public void run(){
            synchronized(SpilarOrder2.class){
                while(true){
                if(res.size() == m * n) return;
                if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]){
                i--;
               
               
            }
                visited[i][j] = true;
                res.add(matrix[i][j]);
                i++;
            } 
        }
        }
    }
    private class toLeft implements Runnable{
        public void run(){
            
            synchronized(SpilarOrder2.class){
                while(true){
                if(res.size() == m * n) return;
                if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]){
                j++; 
                notify();
            }
                visited[i][j] = true;
                res.add(matrix[i][j]);
                j--;
            } 
        }
        }
    }
    private class toTop implements Runnable{
        public void run(){
            synchronized(SpilarOrder2.class){
                while(true){
                if(res.size() == m * n) return;
                if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]){
                i++;
                notify();
            }
                visited[i][j] = true;
                res.add(matrix[i][j]);
                i--;
            } 
        }
        }
    }
    private int m;
    private int n;
    private int i = 0;
    private int j = 0;
    private boolean[][] visited;
    private int[][] matrix;
    private List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        visited = new boolean[m][n];
        new Thread(new toRight()).start();
        new Thread(new toBottom()).start();
        new Thread(new toLeft()).start();
        new Thread(new toTop()).start();
        return res;
    }
    public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		List<Integer> list = new SpilarOrder2().spiralOrder(matrix);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
