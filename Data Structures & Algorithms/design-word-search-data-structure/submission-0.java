class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    public Node(){

    }

    Node get(char ch){
        return links[ch-'a'];
    }

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    boolean isEnd(){
        return flag;
    }

    void setEnd(){
        flag = true;
    }

    void put(char ch, Node node){
        links[ch-'a']=node;
    }
}


class WordDictionary {
    private Node root;
    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int j, Node root){
        Node node = root;

        for(int i=j;i<word.length();i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(Node ref : node.links){
                    if(ref!=null && dfs(word,i+1,ref)){
                        return true;
                    }
                }
                return false;
            }else{
                if(node.get(c) == null){
                    return false;
                }
                node = node.get(c);
            }
        }
        return node.isEnd();
    }
}
