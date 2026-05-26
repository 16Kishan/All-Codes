class Pair{
    int serial;
    int index;
    public Pair(int serial,int index){
        this.serial=serial;
        this.index=index;
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.serial,a.serial));
        for(int i=0;i<score.length;i++){
            pq.add(new Pair(score[i],i));
        }
        String[] arr=new String[score.length];
        int i=0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if(i==0){
                arr[curr.index]="Gold Medal";
                i++;
            }
            else if(i==1){
                arr[curr.index]="Silver Medal";
                i++;
            }
            else if(i==2){
                arr[curr.index]="Bronze Medal";
                i++;
            }
            else{
                arr[curr.index]=""+(i+1);
                i++;
            }
        }
        return arr;
    }
}