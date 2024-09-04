package week2;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(boyerMoore(new int[]{1,3,1,1,4,1,1,5,1,1,6,2,2}));
    }

    public static int majorityElement(int[] nums){
        Arrays.sort(nums);
        int count = 0;
        int curr = nums[0];
        for (int num : nums) {
            if (curr == num) count++;
            else {
                curr = num;
                count = 1;
            }
            if (count > nums.length / 2) return curr;
        }
        return -1;
    }

    public static int boyerMoore(int[] nums){
        if(nums.length == 1) return nums[0];
        int count = 0;
        int majority = nums[0];
        for(int num : nums){
            if(num == majority) count++;
            else count--;
            if(count == 0){
                majority = num;
                count = 1;
            };
        }
        return majority;
    }
}
