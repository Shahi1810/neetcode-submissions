class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            int rem=target-nums[i];
            if(mp.containsKey(rem)){
                if(mp.get(rem)<=i){
                    ans[0] = mp.get(rem);
                    ans[1] = i;
                    return ans;
                }else{
                    ans[0] = i;
                    ans[1] = mp.get(rem);
                    return ans;
                }
            }
            mp.put(nums[i],i);
        }
        return new int[]{0,1};
    }
}
