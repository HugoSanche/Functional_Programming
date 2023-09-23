import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//EXAMPLE OF WORKING WITH .flapMap
public class Test_Travel {
    public static void main(String[] args) {
        Persona persona1=new Persona("Hugo");
        Persona persona2=new Persona("Karina");

        Travel travel1=new Travel("Mexico");
        Travel travel2=new Travel("Canada");
        Travel travel3=new Travel("EU");
        Travel travel4=new Travel("Japan");
        Travel travel5=new Travel("China");

        persona1.addTravel(travel1);
        persona1.addTravel(travel2);
        persona1.addTravel(travel3);

        persona2.addTravel(travel1);
        persona2.addTravel(travel4);
        persona2.addTravel(travel5);

        List<Persona> list=new ArrayList<>();
        list.add(persona1);
        list.add(persona2);

//        for(Persona p:list){
//            System.out.println(p.getName());
//            for(Travel travel: p.getTravels()){
//                System.out.println(travel.getPais());
//            }
//            System.out.println("");
//        }

        //Using Lambda Expression

        //Only names
        list.stream().map(name->name.getName()).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("FIRST");
        list.stream()
                .map(person->person.getTravels())
                .flatMap(travel->travel.stream())
                .map(travel->travel.getPais())
                .forEach(System.out::println);


        System.out.println();
        System.out.println("SECOND");
//        list.stream()
//                .flatMap(person->person.getTravels().stream())
//                .forEach(travel-> System.out.println(travel.getPais()));

        list.stream()
                .peek(x-> System.out.println(x.getName()))
                .map(persona -> persona.getTravels())
                .flatMap(travel ->travel.stream() )
                .map(travel->travel.getPais())
                .forEach(System.out::println);
    }

}
