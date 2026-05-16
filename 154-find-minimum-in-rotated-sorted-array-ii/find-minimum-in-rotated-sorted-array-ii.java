class Solution {
    public int findMin(int[] nums) {
         return bs(nums, 0, nums.length-1);
    }
    	public static int bs(int[] arr, int l, int r) {
		
		 if(l>=r) return arr[l];
		 
		 int m = l + (r-l)/2;
		// System.out.println(l+" "+r+"  mid = "+m);
		 if(arr[m] > arr[r])
			 return bs(arr,m+1,r);
		 else if(arr[m]==arr[r] && arr[m]==arr[l])
			 {
				  int res=Integer.MAX_VALUE;
		 for(int i:arr) {
			 if(i<res)
				 res=i;
		 }
		 return res;
			 }
		 else
			 return bs(arr,l,m);
		 
	 }
	 
	

}