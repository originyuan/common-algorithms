package yuan.tree;

/**
 * @author liuyiyuan
 * @description
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;  //键
        private Value val;  //值
        private Node left, right;  //左右子树
        private int N;  //以该节点为根的子树中的结点总数

        Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        if (cmp > 0) return get(x.right, key);
        return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x == null) return x;
        return min(x.left);
    }

    public Key max() {
        return min(root).key;
    }

    private Node max(Node x) {
        if (x == null) return x;
        return max(x.right);
    }

    //查找排名k的键
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        if (t < k) return select(x.right, k - (t + 1));
        return x;
    }

    //查找键的排名
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        if (cmp > 0) return rank(x.right, key) + size(x.left) + 1;
        return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) return root.right;
        root.left = deleteMin(root.left);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node root, Key key) {
        if(root == null) return null;
        int cmp = key.compareTo(root.key);
        if(cmp < 0) root.left = delete(root.left, key);
        else if (cmp > 0 ) root.right = delete(root.right, key);
        else {
            if(root.right == null) return root.left;
            if(root.left == null) return root.right;
            Node t = root;
            root = min(root.right);
            root.right = deleteMin(root.right);
            root.left = t.left;
        }
        root.N = size(root.left) + size(root.right)+1;
        return root;
    }


    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        bst.put("234", 123);
        bst.put("232", 123);
        bst.put("233", 123);
        bst.put("236", 123);
        bst.put("23", 123);
        System.out.println(bst.size());
        System.out.println(bst.get("23"));
        bst.put("23", 345);
        System.out.println(bst.size());
        System.out.println(bst.get("23"));

        System.out.println(bst.select(2));
        System.out.println(bst.rank("23"));
    }

}
