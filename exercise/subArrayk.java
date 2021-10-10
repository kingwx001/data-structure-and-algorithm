package exercise;

import java.util.Arrays;

public class subArrayk {
	private boolean subArray(int[] arr,int k) {
		int[] dp = new int[k];
		int preSum = 0;
		for(int i = 0;i < arr.length;i++) {
			preSum += arr[i];
			int j = preSum % k;
			if(j == 0 && i > 0) return true;
			if(dp[j] != 0) {
				if(i - dp[j] > 0)
					return true;
			}else
				dp[j] = i + 1;
		}
		return false;
	}
	public static void main(String[] args) {
		int[] arr = {2,4,8};
		int k = 2;
		System.out.println(new subArrayk().subArray(arr, k));
	}
}
