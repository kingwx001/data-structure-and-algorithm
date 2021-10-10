package exercise;

import java.util.ArrayList;

public class TwoSum {
	public static ArrayList<Integer> twoSum(int[] nums, int target) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		for (int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1;j < nums.length;j++) {
				if(nums[i] + nums[j] == target) {
					arrlist.add(i);
					arrlist.add(j);
					return arrlist;
				}
			}
		}
		return arrlist;
	}
	public static void main(String[] args) {
		int[] nums = {2,3,4,5,4,3,3};
		int target = 7;
		System.out.println(twoSum(nums,target));
	}
}
