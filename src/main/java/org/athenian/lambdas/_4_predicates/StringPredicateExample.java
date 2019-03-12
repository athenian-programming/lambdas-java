package org.athenian.lambdas._4_predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringPredicateExample {

  public static void main(String[] args) {

    // Verbose
    Predicate<String> containsHelloVerbose =
        new Predicate<String>() {
          @Override
          public boolean test(String val) {
            return val.contains("Hello");
          }
        };

    // Better
    Predicate<String> containsHelloMedium = (String val) -> {
      return val.contains("Hello");
    };

    // Terse
    Predicate<String> containsHelloTerse = val -> val.contains("Hello");

    System.out.println(containsHelloTerse.test("Hello"));
    System.out.println(containsHelloTerse.test("Goodbye"));

    List<String> names = Arrays.asList("Alice", "Bill", "Allicia", "Pete");

    List<String> a_names = names.stream()
                                .filter(val -> val.startsWith("A"))
                                .collect(Collectors.toList());

    List<String> non_a_names = names.stream()
                                    .filter(val -> !a_names.contains(val))
                                    .collect(Collectors.toList());

    System.out.println("A names: " + a_names);
    System.out.println("Non A names: " + non_a_names);
  }
}
