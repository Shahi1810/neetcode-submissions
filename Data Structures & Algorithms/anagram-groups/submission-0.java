class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String str = new String(temp);
            
            if(!mp.containsKey(str)){
                mp.put(str, new ArrayList<>());
            }
            mp.get(str).add(strs[i]);
        }

        return new ArrayList<>(mp.values());
    }
}
