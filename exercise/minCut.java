package exercise;

import java.util.Arrays;
import java.util.List;

public class minCut {
	private int[][] dp;//表示s(i,j)子字符串分割后的最少数量，比分割次数多1
    private int n;
    public int minCut1(String s) {
        n = s.length();
        dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], 1);
        }
        for(int i = n - 2;i >= 0;i--){
            for(int j = i + 1;j < n;j++){
                dp[i][j] = Math.min(dp[i + 1][j],dp[i][j - 1]) + 1;
                System.out.println(dp[i][j]);
                if(i + 1 < j && dp[i][j - 1] == dp[i + 1][j - 1] && dp[i + 1][j] == dp[i + 1][j - 1]) {
                    dp[i][j]--;
                }
                System.out.println(s.charAt(i) == s.charAt(j));
                if(s.charAt(i) == s.charAt(j) && (i + 1 == j || dp[i + 1][j - 1] == 1)){
                    dp[i][j] = 1;
                }
            }
        }
        return dp[0][n - 1] - 1;
    }
    public static void main(String[] args) {
    	long startTime = System.nanoTime();
		String s = "sfdssfsfsdsadasd";
		int n = new minCut().minCut1(s);
		System.out.println(n);
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime) / 1000000000.0);
	}
}
