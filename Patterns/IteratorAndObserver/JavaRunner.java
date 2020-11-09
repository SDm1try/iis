package IteratorAndObserver;

import java.util.Iterator;

public class JavaRunner {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Hibernate", "Git", "Maven"};

        Car car = new Car("Simba", skills);

        Iterator iterator = car.getIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Car implements Collection{
    private final String name;
    private final String[] skills;

    public Car(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    @Override
    public Iterator<String> getIterator() {
        return new CarIterator();
    }

    private class CarIterator implements Iterator<String>{
        private int index;
        @Override
        public boolean hasNext() {
            return index < skills.length;
        }

        @Override
        public String next() {
            return skills[index++];
        }
    }
}

interface Collection {
    Iterator<String> getIterator();
}