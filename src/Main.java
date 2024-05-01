
public class Main {
    public static void main(String[] args) {
        MyHashTable <MyTestingClass, Student> table = new MyHashTable<>();

        for(int i = 0; i< 10000; i++){
            MyTestingClass key = new MyTestingClass("A" + i);
            Student value = new Student("name" + i);
            table.put(key, value);
        }

        for(int i = 0; i <= table.size(); i++){
            int c = 0;
            MyHashTable.HashNode<MyTestingClass, Student> node = table.chainArray[i];
            while(node != null){
                c++;
                node = node.next;
            }
            System.out.println(i + " : " + c);
        }
    }
}


