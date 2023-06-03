package Model;

import java.util.Date;

public abstract class DomesticAnimal extends Animal{
    public DomesticAnimal(String name, Date birthday) {
        super(name, birthday);
        super.family = "Домашнее";
    }
}
