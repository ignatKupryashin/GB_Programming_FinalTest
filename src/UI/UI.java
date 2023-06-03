package UI;

import Model.API;

import java.util.Scanner;

public class UI {
    Scanner scanner;
    API api;


    public UI(API api) {
        this.api = api;
        scanner = new Scanner(System.in);
    }

    public void printMenu(){
        System.out.println(
                "1. Создать новое животное\n" +
                        "2. Получить список животных\n" +
                        "3. Обучить животное новым командам\n" +
                        "4. Получить список команд, которые может выполнять животное\n" +
                        "0. Выход"
        );
    }

    public void run(){
        String command = "";
        boolean flag = true;
        while(flag){
            printMenu();
            System.out.println("Введите команду: ");
            command = scanner.nextLine();
            switch (command) {
                case "1": {
                    createAnimal();
                    break;
                }
                case "2": {
                    takeAnimalList();
                    break;
                }
                case "3": {
                    trainAnimal();
                    break;
                }
                case "4": {
                    takeCommandList();
                    break;
                }
                case "0": {
                    flag = false;
                    System.out.println("До скорых встреч");
                    break;
                }
                default: {
                    System.out.println("Введена неверная комнда");
                    break;
                }
            }
        }
    }

    private void createAnimal(){
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        boolean crFlag = true;
        String animalType = "";
        while (crFlag) {
            System.out.println("1 - Кошка\n" +
                    "2 - Собака\n" +
                    "3 - Хомяк\n" +
                    "4 - Лошадь\n" +
                    "5 - Верблюд\n" +
                    "6 - Осёл\n");
            System.out.println("Введите цифру, соответствующую типу животного:");
            String inputData = scanner.nextLine();
            switch (inputData) {
                case "1":{
                    animalType = "Cat";
                    crFlag = false;
                    break;
                }
                case "2":{
                    animalType = "Dog";
                    crFlag = false;
                    break;
                }
                case "3":{
                    animalType = "Hamster";
                    crFlag = false;
                    break;
                }
                case "4":{
                    animalType = "Horse";
                    crFlag = false;
                    break;
                }
                case "5":{
                    animalType = "Camel";
                    crFlag = false;
                    break;
                }
                case "6":{
                    animalType = "Donkey";
                    crFlag = false;
                    break;
                }
                default: {
                    System.out.println("Введена некорректная цифра");
                }
            }
            System.out.println("Введите дату в формате DD.MM.YYYY");
            String dateString = scanner.nextLine();
            try {
                api.createAnimal(name, dateString, animalType);
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void takeAnimalList(){
        for (String animal:api.takeAnimalList()
             ) {
            System.out.println(animal);
        }
    }

    private void trainAnimal(){
        int id = takeId();
        System.out.println("Введите команду, которой хотите научить животное: ");
        String command = scanner.nextLine();
        api.trainCommand(id, command);
    }

    private Integer takeId(){
        while (true){
            System.out.println("Введите id животного: ");
            String input = scanner.nextLine();
            try {
                int answer = Integer.parseInt(input);
                return answer;
            }
            catch (NumberFormatException e){
                System.out.println("Введено не число");
            }
        }
    }

    private void takeCommandList(){
        int id = takeId();
        System.out.printf("%s умеет следующие команды:", api.getAnimalName(id));
        for (String command:api.takeCommandList(id)
             ) {
            System.out.println(command);
        }
    }



}
