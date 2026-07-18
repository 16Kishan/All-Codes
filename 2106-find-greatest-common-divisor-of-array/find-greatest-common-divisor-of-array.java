class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        int gcd=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<mini){
                mini=nums[i];
            }else{
                maxi=nums[i];
            }
        }
        for(int i=1;i<=mini && i<=maxi;i++){
            if(mini%i==0 && maxi%i==0){
                gcd=i;
            }
        }
        return gcd;
    }
}