import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class StreamFromOtherDataSources {
    public static void main(String[] Args){
        String[] idiomas=new String[]{"Hola", "Bojour","Hello", "Hallo"};
       Arrays.stream(idiomas).forEach(muestra->System.out.println(muestra));
     
        try{
            Path path2=Paths.get("add.txt");
            Files.lines(path2).forEach(l->System.out.println(l));
            }catch(IOException exception)
            {
                System.out.println(exception);
            }


            String resultb ="No se encontro";
           
            try{
                int count=0;
                String linea="";
                Boolean bandera=false;
                List<String> lines = Files.readAllLines(Paths.get("add.txt"));
                for (String line : lines) {
                    if(!bandera){
                        count++;
                    }
                    if (line.contains("API")) {
                        linea=line;
                        resultb="Se encontro";
                        bandera=true;
                    }
                }
                if (resultb=="No se encontro"){
                    System.out.println("No se encontro");
                }
                else{
                    System.out.println("La palabra Document se encontra en la linea "+count +"\n "+linea +"\n"+resultb);
                }
               
                }catch(IOException exception)
                {
                    System.out.println(exception);
                }
    } 
}
