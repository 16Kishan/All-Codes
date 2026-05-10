class Solution {
    public int solve(int idx, int[] dp, int[] nums, int target) {
        if (idx == nums.length - 1) return 0;

        if (dp[idx] != -1) return dp[idx];

        int res = Integer.MIN_VALUE;
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] - nums[idx] <= target && nums[i] - nums[idx] >= -target) {
                res = Math.max(res, 1 + solve(i, dp, nums, target));
            }
        }

        return dp[idx] = res;
    }

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = solve(0, dp, nums, target);
        return ans < 0 ? -1 : ans;
    }
}