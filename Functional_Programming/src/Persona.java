import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String Name;
private List<Travel> travels=new ArrayList<>();

    public Persona(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void addTravel(Travel travel){
        travels.add(travel);
    }
    public List<Travel> getTravels(){
        return travels;
    }
}
