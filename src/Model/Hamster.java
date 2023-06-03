package Model;

import java.util.Date;

public class Hamster extends DomesticAnimal {
    public Hamster(String name, Date birthday) {
        super(name, birthday);
        super.type = "Хомяк";
    }
}
