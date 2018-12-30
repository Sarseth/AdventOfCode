package pl.sarseth.advent.year2015.day05;

import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.InputReader;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Year2015Day05 {

    public static void main(String[] args) {
        var threeVowels = createThreeVowelsPredicate();
        var twoLettersInARow = createTwoLettersInRowPredicate();
        var forbiddenCombos = createForbiddenCombosPredicate();
        var comboPredicate = forbiddenCombos.negate().and(threeVowels).and(twoLettersInARow);

        var twoLettersInARowTwice = createTwoLettersInRowTwicePredicate();
        var twoLettersSameWithBreak = createTwoLettersWithBreakPredicate();
        var secondComboPredicate = twoLettersInARowTwice.and(twoLettersSameWithBreak);

        var input = InputReader.readInput("201505");
        var listOfString = new ArrayList<String>();
        new Scanner(input).forEachRemaining(listOfString::add);

        var count = listOfString.stream().filter(comboPredicate).count();
        System.out.println(count);

        count = listOfString.stream().filter(secondComboPredicate).count();
        System.out.println(count);
    }

    private static Predicate<String> createTwoLettersWithBreakPredicate() {
        return s -> {
            if (s.length() < 3) {
                return false;
            }
            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i - 2) == s.charAt(i)) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Predicate<String> createTwoLettersInRowTwicePredicate() {
        return s -> {
            if (s.length() < 4) {
                return false;
            }
            for (int i = 1; i < s.length(); i++) {
                for (int j = i + 2; j < s.length(); j++) { // +2 cause they do not want to overlap
                    if (s.substring(i - 1, i + 1).equals(s.substring(j - 1, j + 1))) {
                        return true;
                    }
                }
            }
            return false;
        };
    }

    private static Predicate<String> createThreeVowelsPredicate() {
        return s -> {
            final var vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
            var vowelCounter = 0;
            for (final var character : s.toCharArray()) {
                if (character == vowels[0] || character == vowels[1] ||
                        character == vowels[2] || character == vowels[3] ||
                        character == vowels[4]) {
                    vowelCounter++;
                }
                if (vowelCounter == 3) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Predicate<String> createTwoLettersInRowPredicate() {
        return s -> {
            if (s.length() < 2) {
                return false;
            }
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == s.charAt(i)) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Predicate<String> createForbiddenCombosPredicate() {
        return s -> s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy");
    }

}
