package week8;

import java.util.Arrays;
import java.util.Comparator;

public class MaxProfitInJobScheduling {
    public static void main(String[] args) {
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};
        System.out.println(jobSchedulingWithMemo(startTime, endTime, profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] data = new int[startTime.length][3];
        for(int i = 0 ; i < startTime.length ; i++){
            data[i][0] = startTime[i];
            data[i][1] = endTime[i];
            data[i][2] = profit[i];
        }
        Arrays.sort(data, Comparator.comparingInt(a -> a[0]));
        return getMaxProfit(1, 0, data);
    }

    public static int getMaxProfit(int startTime, int index, int[][] data){
        int maxProfit = 0;
        for(int i = index ; i < data.length ; i++){
            int[] e = data[i];
            if(e[0] < startTime) continue;
            int end = e[1];
            int profit = e[2];
            for(int j = i + 1 ; j <= data.length ; j++){
                int currentProfit = profit + getMaxProfit(end, j, data);
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }
        return maxProfit;
    }

    // Memoized version
    public static int jobSchedulingWithMemo(int[] startTime, int[] endTime, int[] profit) {
        int[][] data = new int[startTime.length][3];
        for(int i = 0 ; i < startTime.length ; i++){
            data[i][0] = startTime[i];
            data[i][1] = endTime[i];
            data[i][2] = profit[i];
        }
        Arrays.sort(data, Comparator.comparingInt(a -> a[0]));
        int[] lastElement = data[data.length - 1];
        int[] memo = new int[lastElement[1]];
        Arrays.fill(memo, -1);
        return getMaxProfitWithMemo(1, 0, data, memo);
    }

    public static int getMaxProfitWithMemo(int startTime, int index, int[][] data, int[] memo){
        int maxProfit = 0;
        if(startTime > data[data.length - 1][0]) return maxProfit;
        if(memo[startTime] != -1) return memo[startTime];
        for(int i = index ; i < data.length ; i++){
            int[] e = data[i];
            if(e[0] < startTime) continue;
            int end = e[1];
            int profit = e[2];
            for(int j = i + 1 ; j <= data.length ; j++){
                int currentProfit = profit + getMaxProfitWithMemo(end, j, data, memo);
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }
        memo[startTime] = maxProfit;
        return maxProfit;
    }

    // DP Version

}
