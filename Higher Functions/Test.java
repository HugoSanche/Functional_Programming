interface I {
    public abstract  int m1();
}
interface J{
    public abstract int m2();
}
interface A{
    public abstract void m4();
}
interface K{
    public abstract A m3(I obj1, J obj2);
}

public class Test {
    public static void main(String[] Args ){
        I obj1= ()->{
            return 100;
        };
        J obj2=()->{
            return 200;
        };
        K obj3=(I x, J y)->{
            System.out.println(x.m1()+y.m2());
            A obj4=()->{
                System.out.println("\n m4()");
            };
            return obj4;
        };        
        A resultado =obj3.m3(obj1, obj2);
        resultado.m4();
    }
}
