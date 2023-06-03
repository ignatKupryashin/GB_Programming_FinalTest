package Model;

import java.util.Date;

public class Cat extends DomesticAnimal {
    public Cat(String name, Date birthday) {
        super(name, birthday);
        super.type = "Кот";
    }
}
