package exercise;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	    private int[][] dp;
	    private List<List<String>> res;
	    private int n;
	    private int isPalindrome(String s,int l,int r){
	        if(l < 0 || r >= n || s.charAt(l) != s.charAt(r)) return 2;
	        if(l == r || l == r - 1) dp[l][r] = 1;
	        if(dp[l][r] != 0){
	            return dp[l][r];
	        }
	        dp[l][r] = isPalindrome(s,l + 1,r - 1);
	        return dp[l][r];
	    }
	    private void dfs(String s,int i,ArrayList<String> list){
	        if(i == n) {
	            res.add((ArrayList<String>)list.clone());
	            //list = new ArrayList<>();
	            return;
	        }
	        for(int j = i;j < n;j++){
	            if(dp[i][j] == 1){
	                list.add(s.substring(i,j + 1));
	                dfs(s,j + 1,list);
	                list.remove(list.size() - 1);
	             }
	        }
	    }
	    public List<List<String>> partition(String s) {
	        n = s.length();
	        dp = new int[n][n];
	        res = new ArrayList<>();
	        ArrayList<String> list = new ArrayList<>();
	        for(int i = 0;i < n;i++){
	            for(int j = i;j < n;j++){
	                isPalindrome(s,i,j);
	            }
	        }
	        dfs(s,0,list);
	        return res;
	    }
	    public static void main(String[] args) {
	    	long startTime = System.nanoTime();
			String s = "sdadsad";
			List<List<String>> list = new PalindromePartitioning().partition(s);
			for(int i = 0;i < list.size();i++) {
				for(int j = 0;j < list.get(i).size();j++) {
					System.out.print(list.get(i).get(j) + " ");
				}
				System.out.println();
			}
			long endTime = System.nanoTime();
			System.out.println((endTime - startTime) / 1000000000.0);
		}
}
