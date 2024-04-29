public class BST <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node (K key, V val){
            this.key = key;
            this.val = val;
        }
    }



    public void put(K key, V val){
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val){
        if (node == null){
            return new Node (key, val);
        }

        int c = key.compareTo(node.key);
        if(c < 0){
            node.left = put(node.left, key, val);
        }
        else if(c > 0){
            node.right = put(node.right, key, val);;
        }
        else{
            node.val = val;
        }
        return node;
    }




    public V get(K key){
        Node node = root;
        while(node != null){
            int c = key.compareTo(node.key);
            if(c < 0){
                node = node.left;
            }
            else if(c > 0){
                node = node.right;
            }
            else{
                return node.val;
            }
        }
        return null;
    }



    public void delete(K key){
        root = delete(root, key);
    }

    public Node delete(Node node, K key){
        if (node == null){
            return null;
        }

        int c = key.compareTo(node.key);
        if(c < 0){
            node.left = delete(node.left, key);
        }
        else if(c > 0){
            node.right = delete(node.right, key);;
        }
        else{
            Node temp = node;
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            node.right = deleteM(temp.right);
            node.left = temp.left;
        }
        return node;
    }
    private Node deleteM(Node node){
        if (node.left == null) return node.right;
        node.left = deleteM(node.left);
        return node;
    }


    public Iterable<K> iterator(){

    }
}
