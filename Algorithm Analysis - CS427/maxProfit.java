public class maxProfit {

   public static void main(String[] args) {
      int arr[] = {45, 35, 1, 0};
      int arr2[] = {15, 2, 1, 6, 8, 3};
      System.out.println("Max Profit 1: " + maxProfit(arr));
      System.out.println("Max Profit 2: " + maxProfit(arr2));
   
   }
   
   // Input: array representing the price fluctuations of a stock over time
   // Output: int representing the maximum profit 
   public static int maxProfit(int[] prices) {
	   int low = Integer.MAX_VALUE; // Lowest Stock Value
	   int high = Integer.MIN_VALUE; // Highest stock value AFTER lowest
	   int buyPoint = 0; // Tracks the lowest value index
	   int sellPoint = 1; // Tracks the highest value index AFTER buyPoint
      
	   for(int i = 0; i < prices.length; i++) {
	   	
         if(prices[i] < low) {
            low = prices[i];
            buyPoint = i;	
		   }
         
		   if(prices[i] > high) {
            high = prices[i];
			   sellPoint = i;
		   }
         
          // To ensure we are getting the sell maximum profit AFTER the lowest cost to buy
		   if(sellPoint < buyPoint) {
			   high = prices[i];
            sellPoint = i;
		   }
      }
		
   // If there is no profit, return 0
	return high - low > 0 ? high - low : 0;
   }
   // Time O(n) - Cycles through each price index once
   // Space O(1) - No additional stack frames or data structures used
}
