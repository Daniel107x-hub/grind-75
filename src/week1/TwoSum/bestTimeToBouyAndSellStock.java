package week1.TwoSum;

public class bestTimeToBouyAndSellStock {
    public static void main(String[] args) {

    }

    public static int usingNestedTraverse(int[] prices){
        int max = 0;
        for(int i = 0 ; i < prices.length - 1 ; i ++){
            for(int j = i + 1 ; j < prices.length ; j++){
                int profit = prices[j] - prices[i];
                if(profit > max) max = profit;
            }
        }
        return max;
    }

    public static int usingTwoPointers(int[] prices){
        if(prices.length <= 1) return 0;
        int max = 0;
        int left = 0;
        int right = 1;
        while(right < prices.length){
            int profit = prices[right] - prices[left];
            if(profit > max) max = profit;
            if(prices[right] < prices[left]) left = right;
            right++;
        }
        return max;
    }
}
