public class MyHashTable <K, V>{
    private static class HashNode <K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode (K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return "{" + key + " " + value + "}" ;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;


    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable (int M){
        this.M = M;
        this.chainArray = new HashNode[M];
        size = 0;
    }

    public int size(){
        return size;
    }

    private int hash(K key){
        return key.hashCode() % M;
    }

    public void put(K key, V value){
        int hash = hash(key);
        HashNode<K, V> newnode = new HashNode<>(key, value);

        if(chainArray[hash] == null){
            chainArray[hash] = newnode;
        }
        else{
            HashNode<K, V> current = chainArray[hash];
            while(current.next != null){
                current = current.next;
            }
            current.next = newnode;
        }
        size++;
    }

    public V get (K key){
        int hash = hash(key);
        HashNode<K, V> current = chainArray[hash];
        while (current.next != null){
            if(((Comparable)current.key).compareTo(key) > 0){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key){
        int hash = hash(key);
        HashNode<K, V> current = chainArray[hash];
        HashNode<K, V> prev = null;
        while (current.next != null){
            if(((Comparable)current.key).compareTo(key) > 0){
                if (prev == null){
                    chainArray[hash] = current.next;
                }
                else{
                    prev.next = current.next;
                }
                size++;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(V value){
        for (HashNode <K, V> node : chainArray){
            HashNode <K, V> current = node;
            while (current.next != null) {
                if (((Comparable) current.value).compareTo(value) > 0) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey (V value){
        for (HashNode <K, V> node : chainArray){
            HashNode <K, V> current = node;
            while (current.next != null) {
                if (((Comparable) current.value).compareTo(value) > 0) {
                    return node.key;
                }
                current = current.next;
            }
        }
        return null;
    }

}
