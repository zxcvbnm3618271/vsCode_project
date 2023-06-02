package org.example.Trie;

import java.util.TreeMap;

/**
 * trie树
 */
public class TrieSearch {
    //trie节点
    static class TrieNode{
        //字符
        char c;
        //统计单词重复次数
        int occurency = 0;
        //散列表构建trie树
        TreeMap<Character,TrieNode> children;
        public TrieNode(){}
        public TrieNode(char c){
            this.c =c;
        }
    }
    TrieNode root;

    public TrieSearch(){
        root = new TrieNode();
    }

    public void insert(String word){
        insert(word,root,0);
    }
    private void insert(String word,TrieNode root,int index){
        //索引必须要满足小于单词长度大于-1
        assert index < word.length() && index > -1;
        //获取当前单词对应索引字符
        char cur = word.charAt(index);
        //构建trie树下一个索引节点
        TreeMap<Character,TrieNode> children = root.children;
        if (children == null){
            children = new TreeMap<Character,TrieNode>();
            root.children = children;
        }
        if (!children.containsKey(cur)){
            children.put(cur,new TrieNode(cur));
        }
        if (index ==word.length()-1){
            children.get(cur).occurency++;
            return;
        }
        insert(word,children.get(cur),index+1);
    }

}
