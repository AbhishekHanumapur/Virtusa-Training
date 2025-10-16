package DAY2;
class one1{
    void t(){
        System.out.println("hello");
    }
}
class two2 extends one1{
    void t1(){
        t();
        System.out.println("hii");
    }
}
class  three extends two2{
    void t3(){
        t1();
        t();
        System.out.println("yes");
    }
}

public class Singleinheritance {
    public static void main(String[] args) {
        three a= new three();
        a.t3();
    }
}
