package com.silent.factory;

/**
 * Author liutao
 * Date 2019/12/3 9:50 上午
 * Description:
 * Version: 1.0
 **/
public class AnimalFactoryTest {


    //  factory + prototype   工厂模式+原型模式
    public static void main(String[] args) {

//        Animal animal=AnimalFactory.createAnimal("CAT");
//        animal.eat();
//        Animal animal1=AnimalFactory.createAnimal("PIG");
//        animal1.eat();
        Animal pig=AnimalFactory.getAnimal("PIG");
        pig.eat();

        Animal pig1=AnimalFactory.getAnimal("PIG");
        pig.eat();

        Animal pig2=AnimalFactory.getAnimal("PIG");
        pig.eat();

    }
}
