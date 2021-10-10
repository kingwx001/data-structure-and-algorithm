package exercise;

import java.util.Arrays;

public class purchasePlans {
	    public int purchasePlans1(int[] nums, int target) {
	        Arrays.sort(nums);
	        int res = 0;
	        for(int i = 0;i < nums.length - 1;i++){
	            int l = i + 1,r = nums.length - 1;
	            int num = target - nums[i];
	            if(num <= 0) break;
	            while(l < r){
	                int mid = l + (r - l) / 2;
	                if(nums[mid] > num){
	                    r = mid;
	                }else{
	                    l = mid + 1;
	                }
	            }
	            res = (res + ((nums[l] + nums[i] <= target) ? l + 1 : l) - i - 1) % 1000000007;
	        }
	        return res;
	    }
	    public static void main(String[] args){
	        int[] nums = new int[99999];
	        for(int i = 0;i < 99999;i++ ){
	            nums[i] = i + 1;
	        }
	        int target = 99999;
	        System.out.println(new purchasePlans().purchasePlans1(nums,target));
	    }
}
