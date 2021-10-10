package exercise;

import java.util.Deque;
import java.util.LinkedList;

public class Find132pattern {
	class SubSeq{
        int min;
        int max;
    }
    Deque<SubSeq> dq = new LinkedList<>();
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        SubSeq ss = new SubSeq();
        ss.min = nums[0];
        ss.max = nums[0];
        dq.offerLast(ss);
        for(int i = 1;i < nums.length;i++){
            SubSeq s = dq.peekLast();
            if(nums[i] < s.max && nums[i] > s.min)
                return true;
            else if(nums[i] > s.max){
                s.max = nums[i];
                while( !dq.isEmpty() && dq.peekLast().min >= s.min && dq.peekLast().max <= s.max)
                {  
                	dq.pollLast();
                	if(!dq.isEmpty() && dq.peekLast().min < nums[i] && dq.peekLast().max > nums[i])
                        return true;
                }
                dq.offerLast(s);
            }
            else if(nums[i] < s.min){
                SubSeq s1 = new SubSeq();
                 if(s.min == s.max){
                     dq.pollLast();
                 }
                s1.min = nums[i];
                s1.max = nums[i];
                dq.offerLast(s1);
            }
        }
        return false;
    }
    public static void main(String[] args) {
		int[] nums = new int[] {3,5,0,3,};
		System.out.println(new Find132pattern().find132pattern(nums));
	}
}
