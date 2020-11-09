package IteratorAndObserver;

import java.util.Iterator;

public class JavaRunner {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Hibernate", "Git", "Maven"};

        JavaDeveloper javaDeveloper = new JavaDeveloper("Simba", skills);

        Iterator<String> iterator = javaDeveloper.getIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class JavaDeveloper implements Collection{
    private final String name;
    private final String[] skills;

    public JavaDeveloper(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    @Override
    public Iterator<String> getIterator() {
        return new DeveloperIterator();
    }

    private class DeveloperIterator implements Iterator<String>{
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