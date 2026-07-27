class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        HashMap<Character,Integer> window = new HashMap<Character,Integer>();
        HashMap<Character,Integer> mapT = new HashMap<Character,Integer>();
        
        int resLen = Integer.MAX_VALUE, have=0, l=0;
        int[]res = {-1,-1};
        for(char c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c,0)+1);
        }

        int need = mapT.size();
        for(int r =0; r<s.length();r++){
            
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+1);

            if(mapT.containsKey(c) && window.get(c).equals(mapT.get(c))){
                have++;
            }

            while(have == need){
                if((r-l+1) < resLen){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);

                if(mapT.containsKey(leftChar) && mapT.get(leftChar) > window.get(leftChar)){
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);

    }
}
