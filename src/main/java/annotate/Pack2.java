package annotate;

/**
 * @author LvSheng
 * @date 2020/2/26
 **/
public class Pack2 {
	
	// 动态规划求解
	public int count(int[] weight, int[] price, int W) {
		int number = weight.length;
		if (number == 0) return 0;
		
		int dp[][] = new int[number][W + 1];
		
		// 初始化第0行，仅考虑能否装下第0号位的物品
		for (int i = 0; i <= W; i++) {
			if (weight[i] <= i) dp[0][i] = price[i];
		}
		
		for (int i = 1; i < number; i++) {
			for (int j = 0; j <= W; j++) {
				dp[i][j] = dp[i - 1][j];
				
				if (j > weight[i]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + price[i]);
				}
			}
		}
		
		return dp[number - 1][W];
	}
	
}
