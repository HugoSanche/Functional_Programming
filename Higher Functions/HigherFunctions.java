interface I{
    public abstract int m1();
} 
interface J{
    public abstract int m2();
}
interface A{
    public abstract void m4();
}
interface K{
    public abstract A  m3(I obj1, J obj2); //regresa A 
}
public class HigherFunctions{
    public static void main (String[] Args){
        I obj1 = ()->{return 111;};
        J obj2=()->{return 222;};

        //checa que recibe 2 objectos
        K obj3 =(I x, J y)->{
            System.out.println(x.m1()+y.m2());
            A obj4=()->{
                System.out.println("m4()");   
            };
            return obj4; // regresa un objecto que es una funcion
        };
        //Checa como mandas 2 funciones 
      A retorno=  obj3.m3(obj1,obj2);
      retorno.m4();  //K retorna una funcion, aqui puedes ver el valor de dicha funcion
    }
}
