package Model;

import java.util.Date;

public class Camel extends PackAnimal {
    public Camel(String name, Date birthday) {
        super(name, birthday);
        super.type = "Верблюд";
    }
}
