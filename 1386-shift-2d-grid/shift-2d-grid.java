class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m*n;
        int big = total*100;
        List<List<Integer>> res= new ArrayList<>();
        int[] a = new int[total];

        for(int i = 0;i<total;i++){
            a[i] = grid[i/n][i%n];
        }

        for(int i = 0;i<m;i++) {
            List<Integer> r= new ArrayList<>();
            for(int j =0;j<n;j++) {
                r.add(a[(i*n+j+big - k) % total]);
            }
            res.add(r);
        }

        return res;
    }
}