package pl.sarseth.advent.year2015.day02;

import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.InputReader;

import java.util.Scanner;
import java.util.function.Consumer;

public class Year2015Day02 {

    public static void main(String[] args) {
        String input = InputReader.readInput("201502");

        BigWrapper bigWrapper = new BigWrapper();
        new Scanner(input).forEachRemaining(bigWrapper);
        System.out.println(bigWrapper.wrapSurface);
    }

    private static class BigWrapper implements Consumer<String> {

        long wrapSurface = 0L;

        @Override
        public void accept(String s) {
            String[] split = s.split("x");
            Rectangle rectangle = new Rectangle(split);
            wrapSurface += rectangle.calculateSurface() + rectangle.calculateSmallestSideSurface();
            System.out.println(wrapSurface);
        }

        private static class Rectangle {

            long x,y,z;

            private Rectangle(String[] dimensions) {
                x = Long.valueOf(dimensions[0]);
                y = Long.valueOf(dimensions[1]);
                z = Long.valueOf(dimensions[2]);
            }

            private long calculateSurface() {
                return 2 * x * y + 2 * x * z + 2 * y * z;
            }

            private long calculateSmallestSideSurface() {
                if (x < y) {
                    if (y < z) {
                        return x * y;
                    } else {
                        return x * z;
                    }
                }
                return y * z;
            }

        }
    }

}
