public class BST <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private int size;
        private Node left, right;
        public Node (K key, V val){
            this.key = key;
            this.val = val;
        }
    }


    public void put (K key, V val){
        Node newnode = new Node(key, val);
        if(root == null){
            root = newnode;
            root.size++;
            return;
        }
        Node current = root;
        while (true){
            if(((Comparable) val).compareTo(current.val) < 0){
                if (current.left == null){
                    current.left = newnode;
                    root.size++;
                    return;
                }
                current = current.left;
            }
            else if (((Comparable) key).compareTo(current.key) > 0) {
                if (current.right == null){
                    current.right = newnode;
                    root.size++;
                    return;
                }
                current = current.right;
            }
            else {
                return;
            }
        }
    }

    public V get(K key){
        Node current = root;
        while (current != null){
            if(((Comparable) key).compareTo(current.key) < 0){
                current = current.left;
            }
            else if (((Comparable) key).compareTo(current.key) > 0){
                current = current.right;
            }
            else {
                return current.val;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node current = root;
        if (root == null) {
            return;
        }
        while (true) {
            if (((Comparable) key).compareTo(current.key) < 0) {
                current = current.left;
            } else if (((Comparable) key).compareTo(current.key) > 0) {
                current = current.right;
            } else {
                current = null;
                root.size--;
            }

        }
    }
    public void inOrder(Node root){
        Node temp = root;
        while (root != null){
            System.out.print(root.val + " ");
            root = root.left;
        }
        root = temp;
        System.out.println();
        while (root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public int size(){
        return root.size;
    }
    public Iterable<K> iterator() {
        Node node;
        node = root;
        while (node != null && node.left != null){
            node = node.left;
        }
        return (Iterable<K>) node.val;
    }
}
