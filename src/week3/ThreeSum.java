package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        for(List<Integer> triplet : threeSum(nums)){
            for(Integer num : triplet) System.out.print(num + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int main = 0;
        while(main < nums.length - 2){
            int target = -nums[main];
            List<List<Integer>> indexes = twoSum(nums, target, main + 1);
            for(List<Integer> pairs : indexes) result.add(List.of(nums[main], nums[pairs.get(0)], nums[pairs.get(1)]));
            do {
                main++;
            } while(main < nums.length && nums[main] == nums[main - 1]);
        }
        return result;
    }

    public static List<List<Integer>> twoSum(int[] array, int target, int leftLimit){
        List<List<Integer>> result = new ArrayList<>();
        int left = leftLimit;
        int right = array.length - 1;
        while(left < right){
            int sum = array[left] + array[right];
            if(sum > target) right--;
            else if(sum < target) left++;
            else{
                result.add(List.of(left, right));
                do{
                    left++;
                } while(left < array.length && array[left] == array[left - 1]);
            }
        }
        return result;
    }
}
