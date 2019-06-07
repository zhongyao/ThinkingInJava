package com.example.arithmetic.queue.catanddog;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhongyao on 2019-06-07.
 * 猫狗队列：
 * 将猫狗入列之后，可以选择性获取猫或者狗按入列的顺序出列：
 *
 * 具体方法如下：
 * add方法
 * pollAll
 * pollDog
 * pollCat
 * isEmpty
 * isDogEmpty
 * isCatEmpty
 */
public class DogCatQueue {

    private Queue<PetEnter> dogQueue;
    private Queue<PetEnter> catQueue;

    public DogCatQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void add(PetEnter petEnter) {
        if (petEnter.getPet() instanceof Dog) {
            dogQueue.add(petEnter);
        } else {
            catQueue.add(petEnter);
        }
    }

    public PetEnter pollAll() {
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                return dogQueue.poll();
            } else {
                return catQueue.poll();
            }
        } else if (!dogQueue.isEmpty()) {
            return dogQueue.poll();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll();
        } else {
            throw new RuntimeException("DogCatQueue is Empty");
        }
    }

    public PetEnter pollDog() {
        if (!dogQueue.isEmpty()) {
            return dogQueue.poll();
        } else {
            throw new RuntimeException("DogQueue is Empty");
        }
    }

    public PetEnter pollCat() {
        if (!catQueue.isEmpty()) {
            return catQueue.poll();
        } else {
            throw new RuntimeException("CatQueue is Empty");
        }
    }

    public boolean isEmpty() {
        if (catQueue.isEmpty() && dogQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isDogEmpty() {
        if (dogQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isCatEmpty() {
        if (catQueue.isEmpty()) {
            return true;
        }
        return false;
    }
}
