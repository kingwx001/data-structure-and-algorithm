package exercise;

import java.util.ArrayList;

public class numDistinct {
	
	public int numDistinct2(String s, String t) {
        int n = t.length();
        ArrayList<Integer>[] hash = new ArrayList[56];
        for(int i = 0;i < n;i++){
            if(hash[t.charAt(i) - 'A'] == null)
                hash[t.charAt(i) - 'A'] = new ArrayList<Integer>();
            hash[t.charAt(i) - 'A'].add(i + 1);
        }
        int[][] dp = new int[s.length() + 1][n + 1];
        for(int i = 0;i < s.length();i++){
            dp[i][0] = 1;
            ArrayList<Integer> arrlist = hash[s.charAt(i) - 'A'];
            for(int k = 0;k < n + 1;k++){
                dp[i + 1][k] = dp[i][k];
            }
            if(arrlist == null) continue;
            for(int j = 0;j < arrlist.size();j++)
                dp[i + 1][arrlist.get(j)] = dp[i][arrlist.get(j) - 1] + dp[i][arrlist.get(j)];  
        }
        return dp[s.length()][n];
    }
	public static void main(String[] args) {
		String s = "ffraeat",t = "rat";
		System.out.println('z' - 'A');
		System.out.println(new numDistinct().numDistinct2(s, t));
	}
}
