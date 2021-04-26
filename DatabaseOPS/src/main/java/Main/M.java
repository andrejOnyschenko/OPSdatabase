package Main;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class M {
    static ArrayList<Main> animals = new ArrayList<>();

    public ArrayList<Main> getAnimal(){
        return animals;
    }
}