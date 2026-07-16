class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num,0) + 1);
        }

        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.get(nums[i])-1);
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j = i+1;j<nums.length;j++){
                mp.put(nums[j],mp.get(nums[j])-1);
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int target = -(nums[i]+nums[j]);
                if(mp.getOrDefault(target,0)>0){
                    res.add(Arrays.asList(nums[i],nums[j],target));
                }
            }
            for(int j = i+1;j<nums.length;j++){
                mp.put(nums[j],mp.get(nums[j])+1);
            }
        }
        return res;
    }
}
