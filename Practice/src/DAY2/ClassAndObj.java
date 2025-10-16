package DAY2;

public class ClassAndObj
{
    String name; //class variable
    int age;
    static  String col="DBIT";

    //default constructor- compiler will automatically provide a default constructor

    ClassAndObj(String name,int age) // parameterised constructor
    {
        this.name=name;
        this.age=age;
    }

    ClassAndObj(ClassAndObj e) //copy constructor
    {
        name= e.name;
    }
    void met()
    {
        String name1; //local variable
        System.out.println("hello"+" : "+col);
    }

    public static void main(String[] args)
    {
        ClassAndObj n=new ClassAndObj("abhi",23);
        System.out.println(n.name);
        ClassAndObj n1= new ClassAndObj(n);
        n1.met();
        ClassAndObj.col="RV";
        n1.met();
    }
}
