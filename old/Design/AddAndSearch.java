class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root = new TrieNode();
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] wa = word.toCharArray();
        TrieNode node = root;
        for(int i=0; i<wa.length; i++) {
            node = node.append(wa[i]);
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word==null) return false;
        return search(word.toCharArray(), 0, root);
    }
    
    private boolean search(char[] wa, int pos, TrieNode node) {
        if(pos==wa.length) return node.isWord;
        if (wa[pos] == '.') {
            for(int i=0; i<26; i++) {
                if (node.nexts[i] != null && search(wa, pos+1, node.nexts[i])) {
                    return true;
                } 
            }
        } else {
            return node.nexts[wa[pos]-'a'] != null && search(wa, pos+1, node.nexts[wa[pos]-'a']);
        }
        return false;
    }
}


class TrieNode {
    boolean isWord;
    TrieNode[] nexts = new TrieNode[26];
    TrieNode append(char ch) {
        if (nexts[ch-'a']!=null) {
            return nexts[ch-'a'];
        }
        nexts[ch-'a'] = new TrieNode();
        return nexts[ch-'a'];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */