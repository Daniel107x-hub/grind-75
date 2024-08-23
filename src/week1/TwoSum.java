package week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
        int[] nums = new int[]{3, 2, 4};
        int[] result = withMap(nums, 6);
        for(int e : result) System.out.println(e + " ");
    }

    public static int[] withArrayTraverse(int[] nums, int target){
        if(nums.length < 2) return new int[2];
        for(int idx1 = 0; idx1 < nums.length - 1 ; idx1++){
            for(int idx2 = idx1 + 1 ; idx2 < nums.length ; idx2++){
                if(nums[idx1] + nums[idx2] == target) return new int[]{idx1, idx2};
            }
        }
        return new int[2];
    }

    public static int[] withMap(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) map.put(nums[i], i);
        for(int i = 0 ; i < nums.length ; i++){
            Integer j = map.get(target - nums[i]);
            if(j != null && i != j) return new int[]{i, j};
        }
        return new int[2];
    }
}
