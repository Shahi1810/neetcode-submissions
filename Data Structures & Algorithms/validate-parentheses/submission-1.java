class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ']'){
                if(!st.isEmpty() && st.pop() == '[') continue;
            }else if(c == ')'){
                if(!st.isEmpty() && st.pop() == '(') continue;
            }else if(c == '}'){
                if(!st.isEmpty() && st.pop() == '{') continue;
            }
            st.push(c);
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
