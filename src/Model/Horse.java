package Model;

import java.util.Date;

public class Horse extends PackAnimal {
    public Horse(String name, Date birthday) {
        super(name, birthday);
        super.type = "Лошадь";
    }
}
