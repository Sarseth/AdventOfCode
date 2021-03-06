package pl.sarseth.advent.year2015.day02;

import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.InputReader;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Year2015Day02 {

    public static void main(String[] args) {
        var input = InputReader.readInput("201502");

        var bigWrapper = new BigWrapper();
        new Scanner(input).forEachRemaining(bigWrapper);
        System.out.println(bigWrapper.wrapSurface);
        System.out.println(bigWrapper.ribbonLength);
    }

    private static class BigWrapper implements Consumer<String> {

        int wrapSurface = 0;
        int ribbonLength = 0;

        @Override
        public void accept(String s) {
            var splitString = s.split("x");
            var rectangle = new Rectangle(splitString);
            wrapSurface += rectangle.calculateSurface() + rectangle.calculateSmallestSideSurface();
            ribbonLength += rectangle.calculateRibbonLength() + rectangle.calculateVolume();
        }

        private static class Rectangle {

            int x, y, z;

            private Rectangle(String[] dimensions) {
                x = Integer.valueOf(dimensions[0]);
                y = Integer.valueOf(dimensions[1]);
                z = Integer.valueOf(dimensions[2]);
            }

            private int calculateSurface() {
                return (2 * x * y) + (2 * x * z) + (2 * y * z);
            }

            private int calculateSmallestSideSurface() {
                return IntStream.of(x, y, z).sorted().limit(2).reduce(1, (smallest, mid) -> smallest * mid);
            }

            private int calculateVolume() {
                return x * y * z;
            }

            private int calculateRibbonLength() {
                return IntStream.of(x, y, z).sorted().limit(2).reduce(0, (smallest, mid) -> smallest + mid) * 2;
            }

        }
    }

}