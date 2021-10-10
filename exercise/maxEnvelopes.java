package exercise;

import java.util.Arrays;
import java.util.Comparator;

public class maxEnvelopes {
	
    public int maxEnvelope(int[][] envelopes) {
    	Arrays.sort(envelopes,new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) 
                return o1[1] - o2[1];
            return o1[0] - o2[0];
            }
        });
    	for(int i = 0;i < envelopes.length;i++) {
    		for(int j = 0;j < envelopes[0].length;j++) {
    			System.out.print(envelopes[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for(int i = 1;i < envelopes.length;i++){
            for(int j = 0;j < i;j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                	dp[i] = Math.max(dp[j] + 1,dp[i]);
                if(envelopes[i][0] == envelopes[j][0] && envelopes[i][1] == envelopes[j][1])
                	dp[i] = dp[j];
            }
        }
        Arrays.sort(dp);
        return dp[envelopes.length - 1];
    }
    public static void main(String[] args) {
    	int[][] envelopes = {{1,3},{3,5},{6,7},{6,8},{8,4},{9,1}};
    	System.out.println(new maxEnvelopes().maxEnvelope(envelopes));
	}
}
