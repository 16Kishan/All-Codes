class Solution {
    public int maxSelectedElements(int[] arr) {
        
        Arrays.sort(arr); 
        int dp[][] = new int[arr.length][];
        
        for (int i = 0; i < dp.length; i++)
            dp[i] = new int[]{1, 1};
        
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] + 1 == arr[i + 1]) {
                dp[i][0] = 1 + dp[i + 1][0];
                dp[i][1] = 1 + dp[i + 1][1];
            }
            
            
            if (arr[i] + 2 == arr[i + 1]) {
                dp[i][1] = 1 + dp[i + 1][0];
            }
            
            if (arr[i] == arr[i + 1]) {
                
                dp[i][0] = 1 + dp[i + 1][1];
                
                dp[i][0] = Math.max(dp[i][0], dp[i + 1][0]);
                dp[i][1] = Math.max(dp[i][1], dp[i + 1][1]); 
            }
        }
        
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i][0]);
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }
}