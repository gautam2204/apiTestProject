package Lamda.collectionLamdaExamples;

import Lamda.ExcerseWithJava7.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachIteration {
  public static void main(String[] args) {
      List<Person> people =
              Arrays.asList(
                      new Person("Gauta1", "Singh", 21),
                      new Person("Gauta2", "Rawat2", 22),
                      new Person("Gauta3", "Caot", 23),
                      new Person("Gauta4", "Rawat4", 24));
      for (Person person:people ) {
      System.out.println(person);
      }

    people.forEach(System.out::println);


  }
}
