class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int maxCons = 1, cons = 1;
        HashSet<Integer> set = new HashSet<>();

        for( int i = 0;i<nums.length; i++){
            set.add(nums[i]);
        }

        for(int i =0 ;i<nums.length; i++){
            if(!set.contains(nums[i]-1)){
                while(set.contains(nums[i] + cons)){
                    cons++;
                }
                maxCons = Math.max(cons,maxCons);
                cons = 1;
            }
        }
        return maxCons;
    }
}
