package Lamda.ExcerseWithJava7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class UnitExcercise {
  public static void main(String[] args) {

    List<Person> people =
        Arrays.asList(
            new Person("Gauta1", "Singh", 21),
            new Person("Gauta2", "Rawat2", 22),
            new Person("Gauta3", "Caot", 23),
            new Person("Gauta4", "Rawat4", 24));

    // sort list by lastname
        sortListByLastName(people);

    //print all elements
      printAll(people);

      //print People with lastName starting with 'C'
      printPeopleWithLastNameC(people);

  }

    private static void printPeopleWithLastNameC(List<Person> people) {
      for (Person p : people) {
          if(p.getLastName().startsWith("C"))
          {
        System.out.println(p);
          }

      }
    }

    private static void printAll(List<Person> people) {
      for (Person p : people) {
      System.out.println(p.toString());
      }
    }

    private static void sortListByLastName(List<Person> people) {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
    }
}