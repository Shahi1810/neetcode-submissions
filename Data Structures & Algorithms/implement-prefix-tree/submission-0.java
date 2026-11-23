class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    public Node(){

    }

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void put(char ch, Node node){
        links[ch-'a']=node;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}

class PrefixTree {
    private static Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
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
        Node node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        if(node.isEnd()) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }
}
