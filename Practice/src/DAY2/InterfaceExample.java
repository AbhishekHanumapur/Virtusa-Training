package DAY2;

 interface  a{
     public void add();
 }
 interface b{
     public void sub();

 }
  class c implements a,b{
      @Override
      public void add() {
          int a=10,b=20;
          System.out.println(a+b);
      }

      @Override
      public void sub() {
          int a=10,b=5;
          System.out.println(a-b);
      }
  }
public class InterfaceExample {
    public static void main(String[] args) {
        c c1=new c();
        c1.add();
        c1.sub();
    }
}
