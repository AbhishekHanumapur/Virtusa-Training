package DAY2;
 class  one{
     void fun1(){
         System.out.println("hello");
     }
 }
 class two extends one{
     void fun2(){
         fun1();
         System.out.println("abhi");
     }
 }
public class InheritanceExample {
    public static void main(String[] args) {
        one o=new one();
        // o.fun2(); - is not possible
        two t= new two();
        t.fun2();

    }
}
