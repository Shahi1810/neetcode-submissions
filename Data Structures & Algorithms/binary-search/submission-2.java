class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return (nums[0] == target) ? 0 : -1;
        }
        int s = 0, e = nums.length - 1;
        int m = s + (e-s)/2;

        while(e >= s){
            
            if(target > nums[m]){
                s = m+1;
            }else if(target < nums[m]){
                e = m-1;
            }else if(target == nums[m]){
                return m;
            }
            m = s + (e-s)/2;
        }
        return -1;
    }
}
