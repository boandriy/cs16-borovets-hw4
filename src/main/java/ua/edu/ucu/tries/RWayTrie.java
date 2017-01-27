package ua.edu.ucu.tries;

public class RWayTrie implements Trie {
    public Tree tree;
    public RWayTrie(){

    }

    public class Node{
        public char data;
        public int value;
        private Node[] childrens;
    }
    class Tree{
        public Node root = new Node();
    }


    @Override
    public void add(Tuple t) {
        String word = t.term;
        Node[] arr = new Node[word.length()];// nodes ('a','p','p','l','e')
        if (this.tree.root.childrens.length == 0) {
            tree.root.childrens = new Node[1];
            for (int i = 0; i < word.length(); i++) {
                Node n = new Node();
                n.data = word.charAt(i);
                arr[i] = n;
            }
            tree.root.childrens[0] = arr[0];

            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    arr[i].value = word.length();
                    break;
                }
                arr[i].childrens = new Node[1];
                arr[i].childrens[1] = arr[i + 1];
                arr[i].value = 0;
            }
        } else {
            int index = -1;
            for (int i = 0; i < tree.root.childrens.length; i++) {
                if (tree.root.childrens[i].data == t.term.charAt(0)) {
                    index = i;
                }
            }
            if (index >= 0) {
                Node n = tree.root.childrens[index];
                int count = 0;
                while (n.data == t.term.charAt(count)) {
                    count++;
                    n = n.childrens[1];
                }
                for (int i = 0; i < word.length(); i++) {
                    Node node = new Node();
                    node.data = word.charAt(i);
                    arr[i] = node;
                }
                Node[] temparr = new Node[n.childrens.length+1];
                int c = 0;
                for(Node node : n.childrens){
                    temparr[c] = node;
                    c++;
                }
                n.childrens = temparr;
                for(int j=0;j<arr.length - count+1;j++){
                    index++;
                    n.childrens[c] = new Node();
                    n.childrens[c].data = t.term.charAt(index);
                    n = n.childrens[c];
                    c = 0;
                }
            }else{
                Node[] newArr = new Node[tree.root.childrens.length+1];
                int count = 0;
                for(Node i : tree.root.childrens){
                    newArr[count] = i;
                    count++;
                }
                tree.root.childrens = newArr;
                for(int i =0;i<t.term.length();i++){
                    Node n = new Node();
                    n.data = t.term.charAt(i);
                    arr[i] = n;                 // ("a",'b','c')
                }
                Node n = arr[0];
                n.childrens[tree.root.childrens.length]= arr [0];
                for(int i=1;i<t.term.length();i++){
                    n.childrens = new Node[1];
                    n.childrens[0] = arr[i];
                }
            }
        }
    }

    @Override
    public boolean contains(String word){

        return false;

    }

    @Override
    public boolean delete(String word) {
        if(this.contains(word)) {
            Tuple[] arr = new Tuple[size() - 1];
            int count = 0;
            for(Tuple i: this.arr){
                if(i.term == word){
                    continue;
                }else{
                    arr[count] = i;
                    count++;
                }
            }
            this.arr = arr;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Iterable<String> words() {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        return arr.length;
    }

}
