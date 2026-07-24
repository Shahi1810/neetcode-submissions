class Solution {

    public String encode(List<String> strs) {
        String encoded = String.join(",", strs);
            return encoded;
    }

    public List<String> decode(String str) {
        List<String> list = Arrays.asList(str.split(","));
        return list;
    }
}
