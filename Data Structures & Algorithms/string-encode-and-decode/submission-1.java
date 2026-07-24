class Solution {

    public String encode(List<String> strs) {
            String encoded ="";
            for(String i : strs){
                //creating delimeter
                String deli = i.length() + "meow";
                encoded+=deli+i;
            }
            return encoded;
        }
        public List<String> decode(String str) {
            List<String> decoded = new ArrayList<>();

            for (int i = 0; i < str.length(); i++) {
                //check for delimeter
                if(Character.isDigit(str.charAt(i)) && str.regionMatches(i+1,"meow",0,4)){
                    int length=str.charAt(i)-'0';
                    int startIndex = i+5;
                    decoded.add(str.substring(startIndex,startIndex+(length)));
                }
            }
            return decoded;
        }
}
