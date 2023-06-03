package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class API {
    AnimalList animalList;
    Counter counter;
    DateFormat dateFormat;


    public API() {
        animalList = new AnimalList();
        counter = new Counter();
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    }

    public void createAnimal(String name, String birthdayString, String animalType) throws RuntimeException{
        Animal newAnimal;
        try {
            Date birthday = dateFormat.parse(birthdayString);
            switch (animalType) {
                case "Cat": {
                    newAnimal = new Cat(name, birthday);
                    break;
                }
                case "Dog": {
                    newAnimal = new Dog(name, birthday);
                    break;
                }
                case "Hamster": {
                    newAnimal = new Hamster(name, birthday);
                    break;
                }
                case "Horse": {
                    newAnimal = new Horse(name, birthday);
                    break;
                }
                case "Camel": {
                    newAnimal = new Camel(name, birthday);
                    break;
                }
                case "Donkey": {
                    newAnimal = new Donkey(name, birthday);
                    break;
                }
                default: {
                    throw new RuntimeException("Введен некорректный тип животного");
                }
            }
            animalList.addAnimal(newAnimal);
            counter.add();
        }
        catch (ParseException e) {
            throw new RuntimeException("Дата введена некорректно");
        }
    }


    public ArrayList <String> takeAnimalList() {
        return animalList.takeAnimalListArray();
    }

    public void trainCommand(int id, String newCommand) {
        animalList.getAnimal(id).addCommand(newCommand);
    }

    public String getAnimalName(int id){
        return animalList.getAnimal(id).getName();
    }

    public ArrayList <String> takeCommandList(int id) {
        if (animalList.getList().containsKey(id)){
          return new ArrayList<String>(animalList.getAnimal(id).getCommands());
        }
        else {
            throw new RuntimeException("Животного с данным id нет");
        }
    }

    private Date parseDate(String inputString) throws ParseException {
        return dateFormat.parse(inputString);
    }
}
