class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int freq=map.containsKey(1)?map.get(1):0;// count for 1 seperately
        int res=(freq!=0)&&(freq%2==0)?freq-1:freq;// if freq is odd then take it or else take it as freq-1 because we always had peak element in our selected subset(eg [2,4,16,4,2] 16 is peak) 
        for(int n:map.keySet()){
            if(n==1)continue;// if n==1 skip it beacause we already computed it
            int count=0;
            int num=n;
            while(map.containsKey(num)){
                if(map.get(num)>=2) count+=2;// if freq of num >=2 count+=2
                else {
                    count++;// else we reached peak element so just count++ and break it
                    break;
                }
                num=num*num;
            }
            if(count % 2 == 0) count--;
            res=Math.max(count,res);
        }
        return res;
    }
}