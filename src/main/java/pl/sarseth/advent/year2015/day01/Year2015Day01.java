package pl.sarseth.advent.year2015.day01;

import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.InputReader;

public class Year2015Day01 {

    public static void main(String[] args) {
        var input = InputReader.readInput("201501");

        int floorUpCharIdx = '(';
        var sum = input.chars().map(character -> character == floorUpCharIdx ? 1 : -1).sum();
        System.out.println(sum);

        sum = 0;
        for (var i = 0; i < input.length(); i++) {
            sum += input.charAt(i) == floorUpCharIdx ? 1 : -1;
            if (sum < 0) {
                System.out.println(i + 1);
                break;
            }
        }
    }

}
