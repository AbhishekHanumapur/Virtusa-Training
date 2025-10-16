package Pack2;

import pack1.access;
class  demo{

}

public class access2 extends access {
    public static void main(String[] args) {
        demo d=new demo();
        access2 ac=new access2();
        ac.add(1,2);
        ac.sub(2,1);
        //d.sub(2,1);
       // ac.mul(1,2);
    }
}
