package exercise;

import java.util.Arrays;

public class GoalSum {
	boolean dfs(int[] nums,int target,int index) {
		if(index == nums.length) {
			return target == 0;
		}
		return dfs(nums, target - nums[index], index + 1)
		|| dfs(nums, target + nums[index], index + 1);	
	}
	public boolean goalSum(int[] nums,int target) {
		Arrays.sort(nums);
		return dfs(nums, target, 0);
	}
	public static void main(String[] args) {
		int[] nums = {2,1,2,4};
		int target = 1;
		System.out.println(new GoalSum().goalSum(nums, target));
	}
}
