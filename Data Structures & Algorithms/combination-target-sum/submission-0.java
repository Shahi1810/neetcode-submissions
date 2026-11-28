class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        dfs(nums, ls, target, 0);
        return res;
    }
    private void dfs(int[] nums, List<Integer> ls, int target, int i){
        if(target == 0){
            res.add(new ArrayList(ls));
            return;
        }
        if(target<0 || i>=nums.length){
            return;
        }

        ls.add(nums[i]);
        dfs(nums, ls, target-nums[i], i);
        ls.remove(ls.size()-1);
        dfs(nums, ls, target, i+1);
    }
}
