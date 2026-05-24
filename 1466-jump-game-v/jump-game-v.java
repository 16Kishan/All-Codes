class Solution {

public int maxJumps(int[] arr, int d) {
    int n = arr.length, res = 0, top = 0;
    int[] dp = new int[n], stack = new int[n];
    for(int i = 0; i <= n; i++) {
        while(top > 0 && (i == n || arr[stack[top - 1]] < arr[i])) {
            int r = top - 1, l = r - 1;
            while(l >= 0 && arr[stack[l]] == arr[stack[r]]) l--;
            for(int j = l + 1; j <= r; j++) {
                if(l >= 0 && stack[j] - stack[l] <= d) dp[stack[l]] = Math.max(dp[stack[l]], 1 + dp[stack[j]]);
                if(i < n && i - stack[j] <= d) dp[i] = Math.max(dp[i], 1 + dp[stack[j]]);
            }
            top -= r - l;
        }
        stack[top++] = i;
    }
    for(int i = 0; i < n; i++) res = Math.max(res, dp[i]);
    return res + 1;
} 
    }
