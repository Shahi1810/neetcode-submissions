class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        
        for( int i : nums){
            mp.put(i , mp.getOrDefault(i,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(mp.entrySet());
        
        Collections.sort(list, (i1,i2)->i2.getValue().compareTo(i1.getValue()));

        int [] ans= new int[k];
        for(int i=0;i<k;i++){
            ans[i]=list.get(i).getKey();
        }
        return ans;
    }
}
