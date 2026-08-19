class Solution {
    public int search(int[] nums, int target) {
        int s=0, e=nums.length-1;
        while(s<e){
            int m = s + (e-s)/2;
            if(nums[m]>nums[e]){
                s=m+1;
            }else{
                e=m;
            }
        }

        int pivot = s;
        int res = bS(nums, target, 0, pivot-1);
        if(res!=-1){
            return res;
        }
        return bS(nums,target, pivot, nums.length-1);
    }

    public int bS(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
