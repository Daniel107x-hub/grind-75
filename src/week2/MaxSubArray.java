package week2;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int num : nums){
            curr = Math.max(num, curr + num);
            if(curr > max) max = curr;
        }
        return max;
    }
}
