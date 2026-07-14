class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1) return true;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<s.length();i++){
            int value = s.charAt(i);
            if((value>=48 && value<=57) ||
                (value>=65 && value<=90) ||
                (value>=97 && value<=122)){
                    sb.append(s.charAt(i));
                }
        }

        int l=0,r=sb.length()-1;
        while(l<=r){
            if(Character.toLowerCase(sb.charAt(l)) == Character.toLowerCase(sb.charAt(r))){
                l++;
                r--;
            }else return false;
        }
        return true;
    }
}
