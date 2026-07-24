class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";

        StringBuilder res = new StringBuilder();

        for(String str : strs){
            res.append(str.length());
            res.append(",");
        }
        res.append("#");

        for(String str : strs){
            res.append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        int i=0;

        while(str.charAt(i)!='#'){
            if(str.charAt(i)!=','){
                char sz = str.charAt(i);
                sizes.add(Integer.parseInt(String.valueOf(sz)));
            }
            i++;
        }

        i++;

        for(int sz : sizes){
            res.add(str.substring(i,i+sz));
            i+=sz;
        }
        return res;
    }
}
