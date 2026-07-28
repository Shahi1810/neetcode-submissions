class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1 || nums.length == 1) return nums;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max = Math.max(max,nums[j]);
            }
            list.add(max);
            if(i+k == nums.length) break;
        }
        
        return list.stream()
                             .mapToInt(Integer::intValue)
                             .toArray();
    }
}
