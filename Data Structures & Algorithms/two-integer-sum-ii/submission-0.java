class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if(nums.length == 2) return nums;
        
        int l=0,r=nums.length-1;

        while(l<r){
            if(target < (nums[l] + nums[r])){
                r--;
                continue;
            }
            else if(target > (nums[l] + nums[r])){
                l++;
                continue;
            }
            else if(target == (nums[l] + nums[r])){
                return new int[]{nums[l],nums[r]};
            }
        }
        return new int[]{-1,-1};
    }
}
