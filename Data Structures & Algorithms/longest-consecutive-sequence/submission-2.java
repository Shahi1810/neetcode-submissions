class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int cons = 0, l=0, r=0;
        for(int i=0; i<nums.length; i++){
            mp.put(nums[i],i);
        }

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            list.add(entry.getKey());
        }
        
        Collections.sort(list);

        for(int i=1; i<list.size();i++){
            if(list.get(i-1) == list.get(i)-1){
                r=i;
                cons = Math.max(cons,(r-l+1));   
            }else{
                l=i;
                r=i;
            }
        }
        return cons;
    }
}
