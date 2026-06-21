class Solution {
    public int numPrimeArrangements(int n) {
        final long MOD = 1_000_000_007L;
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isPrime[i] = true;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
        int primeCount = 0;
        for (int i = 2; i <= n; i++) if (isPrime[i]) primeCount++;
        long result = 1;
        for (int i = 1; i <= primeCount; i++) {
            result = (result * i) % MOD;
        }
        for (int i = 1; i <= n - primeCount; i++) {
            result = (result * i) % MOD;
        }

        return (int) result;
    }
}