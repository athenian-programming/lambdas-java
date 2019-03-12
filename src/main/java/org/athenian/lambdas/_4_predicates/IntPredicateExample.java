package org.athenian.lambdas._4_predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class IntPredicateExample {

  public static void main(String[] args) {

    // Verbose
    Predicate<Integer> isEvenVerbose =
        new Predicate<Integer>() {
          @Override
          public boolean test(Integer val) {
            return val % 2 == 0;
          }
        };

    // Better
    Predicate<Integer> isEvenMedium = (Integer val) -> {
      return val % 2 == 0;
    };

    // Terse
    Predicate<Integer> isEvenTerse = val -> val % 2 == 0;

    for (int i = 0; i < 10; i++)
      System.out.println(format("%d %s", i, isEvenTerse.test(i)));

    List<Integer> vals = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<Integer> evens = vals.stream()
                              .filter(val -> val % 2 == 0)
                              .collect(Collectors.toList());

    List<Integer> odds = vals.stream()
                             .filter(val -> !evens.contains(val))
                             .collect(Collectors.toList());

    System.out.println("Evens: " + evens);
    System.out.println("Odds: " + odds);
  }
}
