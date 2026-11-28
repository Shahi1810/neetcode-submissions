class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> ls, int i, int total){
        if(total == target){
            res.add(new ArrayList<>(ls));
            return;
        }

        if(total>target || i>=candidates.length){
            return;
        }

        ls.add(candidates[i]);
        dfs(candidates, target, ls, i+1, total+candidates[i]);
        ls.remove(ls.size()-1);
        while(i+1 < candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        dfs(candidates, target, ls, i+1, total);
    }
}
