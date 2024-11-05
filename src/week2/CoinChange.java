package week2;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        System.out.println(coinChange(coins, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for(int i = 1 ; i <= amount ; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int c : coins){
                if(i - c < 0) break;
                if(dp[i - c] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
