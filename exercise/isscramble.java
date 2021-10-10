package exercise;

public class isscramble {
	public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n];
            for(int j = 0;j < n;j++){
                for(int k = 0;k < n;k++){
                    if(s1.charAt(j) == s2.charAt(k)){
                        dp[j][j][k] = true;
                    }
                }
            }
   
        for(int i = n - 1;i >= 0;i--){
            for(int j = i;j < n;j++){
                int length = j - i + 1;
                for(int k = 0;k < n - length + 1;k++){
                    for(int l = 0;l < length - 1;l++){
                        if(dp[i][i + l][k] && dp[i + l + 1][j][k + l + 1] || dp[i][i + l][k + length - l - 1] && dp[i + l + 1][j][k]){
                           dp[i][j][k] = true;
                           break;
                        }
                    } 
                }
            }
        }
        return dp[0][n - 1][0];
    }
	public static void main(String[] args) {
		String s1 = "aattt";
		String s2 = "tatat";
		System.out.println(new isscramble().isScramble(s1,s2));
	}
}
