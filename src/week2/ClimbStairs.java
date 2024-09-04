package week2;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n){
        int[] ways = new int[]{1, 2};
        if(n <= 2) return ways[n - 1];
        for(int i = 3 ; i <= n ; i++){
            int current = ways[0] + ways[1];
            ways[0] = ways[1];
            ways[1] = current;
        }
        return ways[1];
    }
}
