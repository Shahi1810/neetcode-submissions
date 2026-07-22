class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0) return 0;
        
        HashSet<Character> setR = new HashSet<>();
        int l=0,maxLength=0;

        for(int r=0;r<s.length();r++){
            while(setR.contains(s.charAt(r))){
                setR.remove(s.charAt(l));
                l++;
            }
            setR.add(s.charAt(r));
            maxLength = Math.max(maxLength,r-l+1);
        }
        
        return maxLength;
    }
}
