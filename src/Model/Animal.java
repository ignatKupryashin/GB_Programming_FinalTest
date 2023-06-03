package Model;

import java.util.Date;
import java.util.HashSet;


/**
 * Класс животного
 */
public abstract class Animal {

    String name;
    Date birthday;
    /**
     * Список команд, которые знает животное
     */
    HashSet<String> commands;
    String family;
    String type;

    /**
     * Общий абстрактный класс для всех животных
     * @param name Имя животного
     * @param birthday Дата рождения животного
     */

    public Animal(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
        this.commands = new HashSet<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public HashSet<String> getCommands() {
        return commands;
    }

    public void setCommands(HashSet<String> commands) {
        this.commands = commands;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addCommand(String newCommand){
        if (this.commands.contains(newCommand)) {
            System.out.println("Животное уже знает эту команду");
        }
        else {
        this.commands.add(newCommand);
        System.out.printf("%s только что выучилось команде %s", this.name, newCommand);
        }
    }

    public String toString(){
        return String.format("%s - %s - %s", name, type, family);
    }
}
