package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class SplitArray {
	int[] preSum;
    int[][] cache;
    private int dfs(int[] nums,int l,int r,int m){
        if(m == 0) return preSum[r + 1] - preSum[l];
        if(l > r) return Integer.MAX_VALUE;
        if(cache[l][m] != 0) return cache[l][m];
        int min = Integer.MAX_VALUE;
        for(int i = l; i <= r;i++){
            int leftSum = preSum[i + 1] - preSum[l];
            int rightSum = dfs(nums,i + 1,r,m - 1);
            min = Math.min(Math.max(leftSum,rightSum),min);
        }
       cache[l][m] = min;
       return min;
    }
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        cache = new int[n][m];
       
        preSum = new int[n + 1];
        for(int i = 0;i < n;i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        return dfs(nums,0,n - 1,m - 1);

    }
	public static void main(String[] args) {
		int n = 100;
		int m = 15;
		int[] arr = new int[n];
		Random random = new Random();
	   
	    for(int i = 0;i < n;i++){
	        arr[i] = random.nextInt(n);
	    }
	  System.out.println(Arrays.toString(arr));
	  System.out.println(new SplitArray().splitArray(arr, m));
	} 
}