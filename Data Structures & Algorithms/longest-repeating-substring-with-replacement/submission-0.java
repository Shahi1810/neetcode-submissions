class Solution {
    public int characterReplacement(String s, int k) {
         HashMap<Character,Integer> count = new HashMap<>();

         int l=0, res=0, maxf=0;
         for(int i=0;i<s.length();i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i),0)+1);
            maxf=Math.max(count.get(s.charAt(i)),maxf);

            while((i-l+1)-maxf>k){
                count.put(s.charAt(l),count.get(s.charAt(l))-1);
                l++;
            }
            res=Math.max((i-l+1), res);
         }
         return res; 
    }
}
