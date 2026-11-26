class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        dfs(nums,0,ls,res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> ls, List<List<Integer>> res){
        if(i>=nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }

        //add nums[i]
        ls.add(nums[i]);
        dfs(nums,i+1,ls,res);

        //dont add nums[i]
        ls.remove(ls.size()-1);
        dfs(nums,i+1,ls,res);
    }
}
