package ru.sbt;

import ru.sbt.model.Person;
import ru.sbt.model.Wocker;
import ru.sbt.utils.BeanUtils;

public class Main {
    public static void main(String[] args) {
        BeanUtils.assign(new Person("Peter", 22), new Wocker("Bob", 21, "Risk", 1));
    }
}
