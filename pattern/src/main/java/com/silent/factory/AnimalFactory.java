package com.silent.factory;

import java.util.HashMap;

/**
 * Author liutao
 * Date 2019/12/3 9:46 上午
 * Description:
 * Version: 1.0
 **/
public class AnimalFactory {

    private static HashMap<String, Animal> animalHashMap = new HashMap<>();

    public static Animal createAnimal(String type) {

        if ("CAT".equals(type)) {
            return new Cat();
        }
        if ("DOG".equals(type)) {
            return new Dog();
        }
        if ("PIG".equals(type)) {
            return new Pig();
        }
        return null;
    }

    public static Animal getAnimal(String animalName) {
        if (animalHashMap.size() == 0) {
            loadAnimal();
            System.out.println("初始化 animal");
        }
        Animal animal = animalHashMap.get(animalName);
        return (Animal) animal.clone();
    }

    public static void loadAnimal() {
        animalHashMap.put("CAT", new Cat());
        animalHashMap.put("DOG", new Dog());
        animalHashMap.put("PIG", new Pig());
    }


}
