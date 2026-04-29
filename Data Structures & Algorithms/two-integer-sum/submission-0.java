class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2){
            return new int[]{0,1};
        }
        
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int rem = target - nums[i];
            if(mp.containsKey(rem)){
                if( i < mp.get(rem)){
                    return new int[]{i,mp.get(rem)};
                }else return new int[]{mp.get(rem),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
