package week1;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
    }

    public static int search(int[] nums, int target){
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int target, int left, int right){
        int middle = left + (right - left) / 2;
        if (target == nums[middle]) return middle;
        if (left == right) return -1;
        if (target < nums[middle]) return binarySearch(nums, target, left, middle);
        else return binarySearch(nums, target, middle + 1, right);
    }
}
