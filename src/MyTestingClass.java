class MyTestingClass{


    String name;
    MyTestingClass (String name){
        this.name = name;
    }
    public int hashCode(){
        int hash = 31;
        hash = hash * 31 + name.length();
        hash = hash * 31 + name.hashCode();
        return hash;
    }

}
