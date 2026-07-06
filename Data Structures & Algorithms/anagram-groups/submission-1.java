class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if(!mp.containsKey(sorted)){
                mp.put(sorted,new ArrayList<>());
            }
            mp.get(sorted).add(strs[i]);
        }
        return new ArrayList<>(mp.values());
    }
}
