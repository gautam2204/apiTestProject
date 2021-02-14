package Lamda.ExcerseWithJava8;

import Lamda.ExcerseWithJava7.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class UnitExcerciseWithLamda {

  public static void main(String[] args) {

    List<Person> people =
        Arrays.asList(
            new Person("Gauta1", "Singh", 21),
            new Person("Gauta2", "Rawat2", 22),
            new Person("Gauta3", "Caot", 23),
            new Person("Gauta4", "Rawat4", 24));
    System.out.println("All Names");
    printConditionall(people,(person) ->true);
    // sort list by lastname
    System.out.println("All lastNames starting with c");
    // print with condition if last name starts with c
    printConditionall(people, (Person person) -> person.getLastName().startsWith("C"));
    System.out.println("All last Names ending with t");
    printConditionall(people, (Person person) -> person.getLastName().endsWith("t"));
  }
/*
  This will be updated with in buld lamda usage classes in function module

  private static void printConditionall(List<Person> people, Condition condition) {
    for (Person person:people ) {
        if(condition.getCondition(person))
        {
        System.out.println(person);
        }
    }
  }*/
private static void printConditionall(List<Person> people, Predicate<Person> predicate) {
  for (Person person:people ) {
    if(predicate.test(person))
    {
      System.out.println(person);
    }
  }
}
  private static void printAll(List<Person> people) {
    for (Person p : people) {
      System.out.println(p);
    }
  }
}