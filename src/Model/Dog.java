package Model;

import java.util.Date;

public class Dog extends DomesticAnimal {
    public Dog(String name, Date birthday) {
        super(name, birthday);
        super.type = "Собака";
    }
}
