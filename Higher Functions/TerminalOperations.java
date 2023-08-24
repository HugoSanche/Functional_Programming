import java.util.Arrays;
import java.util.List;

public class TerminalOperations {
    public static void main(String[] Args){
        List<String> nombres=Arrays.asList("Hugo Baltazar", "Karina Lopez", "Veronica Perez", "Guiselle Ramirez");
            nombres.stream()
            .map(list->list.toUpperCase())
            .forEach(nombre->System.out.println(nombre));

            /*************toList********** */
        List<String> upperUserNames=nombres.stream()
        .map(list->list.toUpperCase())
        .toList();
        System.out.println("En lista y mayusculas "+upperUserNames);


        /*********************reduce****************************/

        List<Double> earnings =Arrays.asList(55.23,75.12,68.11,50.00,100.0,15.1,850.41,900.01);
        
        
        //The firts parameter of reduce in this case 0.00 its add to sum values in earnings
        //if you wanth to add a distict value from list you would change the firts parameters of reduce
        //change 0.00 to 20.10 for example
        Double totalEarnings=earnings.stream().reduce(0.00, ((x,y)-> x+y  ));
        System.out.println("El total de venta es "+totalEarnings);
    
        //reduce its a terminal operations because reduce the values of list to a single value
        List<Double> espenses =Arrays.asList(10.00,7.50,2.50,50.00,20.00);

        //reduce the value 100 to the list
        Double expenses=espenses.stream().reduce(100.00, ((x,y)-> x-y  ));
        System.out.println("You still have  $"+expenses);

        List<String> itemsToSell=Arrays.asList("Peras", "Cholates", "PineApple", "Soda","Coffe","Milk" );
        String resultado= itemsToSell.stream().filter(busca->busca.equals("Cream"))
        .findFirst()
        .orElse(null);
        String respuesta= resultado == null ? "No se encuentra" : "Se encuentra";
        System.out.println(respuesta);

        List<Integer> numeros= Arrays.asList(1,1,2,2,2,2,3,4,4,4,4,6,6,6,7,8,8,9,9,9,9,9);

        Long result=numeros.stream().filter(num->num==2).count();

        System.out.println("The number 2 its find "+result+" veces");
    }
}