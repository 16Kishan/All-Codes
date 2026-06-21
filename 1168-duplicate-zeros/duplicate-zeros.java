class Solution {
    public void duplicateZeros(int[] arr) {
        int[] res=new int[arr.length];
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(k<arr.length){
            if(arr[i]==0){
                res[k]=0;
                if(k!=arr.length-1){
                res[k+1]=0;
                k++;
                }
                k++;
            }
            else{
                res[k]=arr[i];
                k++;
            }
            }

        }

        for(int i=0;i<arr.length;i++){
            arr[i]=res[i];
        }
    }
}