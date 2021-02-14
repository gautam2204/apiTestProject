package Lamda.ExcerseWithJava8;

import Lamda.ExcerseWithJava7.Person;

@FunctionalInterface
public interface Condition {
    boolean getCondition(Person person);
}
