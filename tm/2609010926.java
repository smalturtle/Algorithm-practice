/**
 * 
 * 前缀树，又称字典树，是一种树形数据结构，用于存储字符串集合，常用于字符串的查找、插入和删除操作。
 * 每个节点代表一个字符，从根节点到叶子节点，路径上组成的字符串就是集合中的一个字符串。
 * 力扣208，实现Trie（前缀树）
 * 
 *     
 */

class Trie {
    static class Node{
        Node[] children;
        boolean isLast;
        public Node(){
            children = new Node[26];
            isLast = false;
        }
    }
    public Trie() {
        head = new Node();
    }
    Node head;
    public void insert(String word) {
        Node cur = head;
        for(int i=0;i<word.length();i++){
            int k = word.charAt(i)- 'a';
            if(cur.children[k] == null){
                cur.children[k] = new Node();
            }
            cur = cur.children[k];
        }
        cur.isLast = true;
    }
    
    public boolean search(String word) {
        Node cur = searchNode(word);
        return cur != null && cur.isLast;
    }
    
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    public Node searchNode(String s){
        Node cur = head;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int index= ch - 'a';
            if(cur.children[index] == null){
                return null;
            }
            cur = cur.children[index];
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */