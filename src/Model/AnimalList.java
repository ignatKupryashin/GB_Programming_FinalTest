package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimalList {
    private HashMap<Integer, Animal> list;
    private int maxId;

    public AnimalList(HashMap<Integer, Animal> list) {
        this.list = list;
    }
    StringBuilder stringBuilder;

    public AnimalList() {
        this.list = new HashMap<>();
        stringBuilder = new StringBuilder();
    }

    public HashMap<Integer, Animal> getList() {
        return list;
    }

    public void setList(HashMap<Integer, Animal> list) {
        this.list = list;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public void addAnimal(Animal animal){
        refreshMaxId(maxId + 1);
        this.list.put(this.maxId, animal);
    }

    public  Animal getAnimal(int id){
        return list.get(id);
    }


    public void addAnimal(int id, Animal animal) throws RuntimeException{
        if (!this.list.containsKey(id)){
            this.list.put(id, animal);
            refreshMaxId(id);
        }
        else {
            throw new RuntimeException("Животное с таким id уже есть");
        }
    }

    private void refreshMaxId(int newId){
        if (newId >= maxId){
            maxId = newId;
        }
    }

    public ArrayList<String> takeAnimalListArray(){
        ArrayList<String> data = new ArrayList<>();
        for (int id: list.keySet()
             ) {
            data.add(String.format("%d - %s\n", id, list.get(id).toString()));
        }
        return data;
    }


}
