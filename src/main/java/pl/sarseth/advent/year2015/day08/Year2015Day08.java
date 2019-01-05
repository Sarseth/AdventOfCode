package pl.sarseth.advent.year2015.day08;

import org.apache.commons.lang3.StringEscapeUtils;
import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.InputReader;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Year2015Day08 {

    public static void main(String[] args) {
        String input = InputReader.readInput("201508");

        AtomicInteger totalLength = new AtomicInteger();
        AtomicInteger codeLength = new AtomicInteger();
        AtomicInteger part2Length = new AtomicInteger();
        new Scanner(input).forEachRemaining(s -> {
            totalLength.addAndGet(s.length());
            codeLength.addAndGet(s.length());
            part2Length.addAndGet(StringEscapeUtils.escapeJava(s).length() + 2);

            int offset = 0;
            while (offset < s.length()) {
                int curChar = s.codePointAt(offset);
                offset += Character.charCount(curChar);
                if (curChar == 34) { // if quotation
                    codeLength.getAndDecrement();
                } else if (curChar == 92) {  // if slash
                    codeLength.getAndDecrement();
                    curChar = s.codePointAt(offset);
                    if (curChar == 120) { // if hex
                        codeLength.addAndGet(-2);
                        offset += Character.charCount(curChar);
                    } else {
                        offset += Character.charCount(curChar);
                    }
                }
            }
        });
        System.out.println(totalLength.get() - codeLength.get());
        System.out.println(part2Length.get() - totalLength.get());

    }

}