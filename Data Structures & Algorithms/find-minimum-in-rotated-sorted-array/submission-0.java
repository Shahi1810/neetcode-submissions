class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length-1;
        int res = nums[s];
        while(s<=e){
            if(nums[s]<nums[e]){
                res = Math.min(res,nums[s]);
                break;
            }

            int m = s + (e-s)/2;
            res = Math.min(res,nums[m]);
            if(nums[s]<=nums[m]){
                s=m+1;
            }else{
                e = m-1;
            }
        }
        return res;
    }
}
