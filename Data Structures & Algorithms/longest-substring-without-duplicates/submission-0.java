class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0) return 0;
        
        HashSet<Character> setR = new HashSet<>();
        int l=0,r=1,maxLength=1;
        
        while(l<s.length() && r<s.length()){
            if(s.charAt(l) != s.charAt(r) && !setR.contains(s.charAt(r))){
                setR.add(s.charAt(r));
                maxLength = Math.max(maxLength, r-l+1);
                r++;
            }else{
                setR.clear();
                l=r;
                r++;
            }
        }
        return maxLength;
    }
}
