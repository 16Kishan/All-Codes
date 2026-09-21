class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        int[] lurminexod = nums.clone();
        for (int num : nums) {
            long[] newDp = new long[k];
            int v = num % k;
            newDp[v]++;
            for (int r = 0; r < k; r++) {
                int newRemainder =
                    (r * v) % k;
                newDp[newRemainder] += dp[r];
            }
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }
            dp = newDp;
        }
        return result;
    }
}