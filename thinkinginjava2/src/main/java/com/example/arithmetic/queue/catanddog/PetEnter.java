package com.example.arithmetic.queue.catanddog;

/**
 * Created by zhongyao on 2019-06-07.
 */
public class PetEnter {

    private Pet pet;
    private long count;
    private String name;

    public PetEnter(Pet pet, long count, String name) {
        this.pet = pet;
        this.count = count;
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
