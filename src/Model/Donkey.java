package Model;

import java.util.Date;

public class Donkey extends PackAnimal {
    public Donkey(String name, Date birthday) {
        super(name, birthday);
        super.type = "Осёл";
    }
}
