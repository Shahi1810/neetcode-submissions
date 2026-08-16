class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1) return search(matrix[0], target) == -1 ? false : true;

        for(int i=0;i<matrix.length;i++){
            if(search(matrix[i], target) != -1) return true;
        }
        return false;
        
    }
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
