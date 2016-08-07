package ru.sbt;

import ru.sbt.model.Person;
import ru.sbt.model.Wocker;
import ru.sbt.utils.BeanUtils;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Peter", 22);
        Wocker wocker = new Wocker("Bob", 21, "sklad", 1);
        System.out.println(person);
        System.out.println(wocker);
        BeanUtils.assign(person, wocker);
        System.out.println("----------------------------------");
        System.out.println(person);
        System.out.println(wocker);
    }
}
