package com.example.arithmetic.queue;

import com.example.arithmetic.queue.catanddog.Cat;
import com.example.arithmetic.queue.catanddog.Dog;
import com.example.arithmetic.queue.catanddog.DogCatQueue;
import com.example.arithmetic.queue.catanddog.PetEnter;

/**
 * Created by zhongyao on 2019-06-07.
 */
public class QueueTest {
    public static void main(String[] args) {
        /**
         * 猫狗队列
         */
        DogCatQueue dogCatQueue = new DogCatQueue();

        Dog dog = new Dog();
        PetEnter petEnter = new PetEnter(dog, 1, "豆豆");
        dogCatQueue.add(petEnter);

        Dog dog1 = new Dog();
        PetEnter petEnter1 = new PetEnter(dog1, 2, "欢欢");
        dogCatQueue.add(petEnter1);

        Cat cat = new Cat();
        PetEnter petEnter2 = new PetEnter(cat, 3, "咪咪");
        dogCatQueue.add(petEnter2);

        Dog dog2 = new Dog();
        PetEnter petEnter3 = new PetEnter(dog2, 4, "乐乐");
        dogCatQueue.add(petEnter3);

        Cat cat1 = new Cat();
        PetEnter petEnter4 = new PetEnter(cat1, 5, "妮妮");
        dogCatQueue.add(petEnter4);

        dogCatQueue.isCatEmpty();
        dogCatQueue.isDogEmpty();
        dogCatQueue.isCatEmpty();

        print(dogCatQueue.pollCat());
        print(dogCatQueue.pollAll());
        print(dogCatQueue.pollDog());
    }

    private static void print(PetEnter petEnter) {
        System.out.println("---" + petEnter.getPet().getPetType() + " " + petEnter.getName());
    }
}
