package dev.gonz.patterns.behavioral.iterable.external;

public class Person {
    final private String name;
    final private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Person(");
        stringBuilder.append("name = ");
        stringBuilder.append(name);
        stringBuilder.append(", age = ");
        stringBuilder.append(age);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
