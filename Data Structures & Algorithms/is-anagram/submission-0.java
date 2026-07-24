class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return true;
        }

        char[] first=s.toCharArray();
        char[] second=t.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        String firstSorted = new String(first);
        String secondSorted = new String(second);

        return firstSorted.equals(secondSorted);
    }
}
