class MyTestingClass{
    String name;
    MyTestingClass (String name){
        this.name = name;
    }
    public int hashCode(){
        int hash = 0;
        for(int i = 0; i < name.length();i++){
            hash = hash * 31 + name.charAt(i);
        }
        return hash;
    }

}
