package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word){
        return trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public int size() {
        return trie.size();
    }
}
