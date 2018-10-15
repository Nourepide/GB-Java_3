package net.nourepide.learning.lessonOne.additional;


import net.nourepide.learning.lessonOne.ArraysUtils;
import net.nourepide.learning.lessonOne.additional.fruit.Apple;
import net.nourepide.learning.lessonOne.additional.fruit.Fruit;
import net.nourepide.learning.lessonOne.additional.fruit.Orange;

import java.util.List;

class Box<T extends Fruit> {
    private ArrayList<T> storage;

    @SafeVarargs
    Box(T... storage) {
        this.storage = ArraysUtils.arrayConverter(storage);
    }

    float getWeight() {
        float weight = -1f;

        if (storage.get(0) instanceof Apple) weight = storage.size() * 1.0f;
        if (storage.get(0) instanceof Orange) weight = storage.size() * 1.5f;

        return weight;
    }

    boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    private void add(T value) {
        storage.add(value);
    }

    void fill(Box<T> box) {
        for (int i = 0; i <= box.storage.size(); i++) {
            add(box.storage.remove(0));
        }
    }
}
