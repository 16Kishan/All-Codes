class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<trust.length;i++){
            set.add(trust[i][0]);
        }
        int judge=-1;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                judge=i;
            }
        }
        if(judge==-1)
            return -1;
        int c=0;
        for(int i=0;i<trust.length;i++){
            if(trust[i][1]==judge){
                c++;
            }
        }
        if(c==n-1)
        return judge;
        else
        return -1;
    }
}