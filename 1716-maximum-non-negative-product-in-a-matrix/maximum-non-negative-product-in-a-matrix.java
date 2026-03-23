class Solution {
   	public int maxProductPath(int[][] grid) {
        
        long[][] gridMax = new long[grid.length][grid[0].length];
        long[][] gridMin = new long[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                gridMax[i][j] = grid[i][j];
                gridMin[i][j] = grid[i][j];
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(i == 0 && j == 0)
                    continue;
                
                long prodMin = Long.MAX_VALUE;
                long prod = Long.MIN_VALUE;
                if(i-1 >= 0){
                    prod = Math.max(prod, gridMax[i-1][j] * gridMax[i][j]);
                    prod = Math.max(prod, gridMin[i-1][j] * gridMax[i][j]);
                    prodMin = Math.min(prodMin, gridMax[i-1][j] * gridMax[i][j]);
                    prodMin = Math.min(prodMin, gridMin[i-1][j] * gridMax[i][j]);
                }
                
                if(j-1 >= 0){
                    prod = Math.max(prod, gridMax[i][j-1] * gridMax[i][j]);
                    prod = Math.max(prod, gridMin[i][j-1] * gridMax[i][j]);
                    prodMin = Math.min(prodMin, gridMax[i][j-1] * gridMax[i][j]);
                    prodMin = Math.min(prodMin, gridMin[i][j-1] * gridMax[i][j]);
                }
                                
                gridMax[i][j] = prod;
                gridMin[i][j] = prodMin;
            }
        }
        
        if(gridMax[grid.length-1][grid[0].length-1] < 0)
            return -1;
        
        return (int) (gridMax[grid.length-1][grid[0].length-1] % 1000000007);
    }
}