package exercise;

import java.util.Arrays;

public class findReverse {
	int res = 0;
    private void mergeSort(int[] nums,int l,int r){
        if(l >= r) return;
        int mid = l + ((r - l) >> 1);
        mergeSort(nums,l,mid);
        mergeSort(nums,mid + 1,r);
        int[] aux =  Arrays.copyOfRange(nums,l,r + 1);
        int i = l,j = mid + 1,k = l;
        if(nums[mid] < nums[mid + 1])
            return;
        while(i <= mid && j <= r){
            if(aux[i - l] > aux[j - l]){
                nums[k++] = aux[j++ - l];
            }else{
                nums[k++] = aux[i++ - l];
                res += k - i;
            }
        }
        while(i <= mid){
            nums[k++] = aux[i++ - l];
            res += k - i;
        }
        while(j <= r) nums[k++] = aux[j++ - l];

    }
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length - 1);
        return res;
    }
    public static void main(String[] args) {
    	int[] nums = {7,5,6,4};
		System.out.println(new findReverse().reversePairs(nums));
	}
}
