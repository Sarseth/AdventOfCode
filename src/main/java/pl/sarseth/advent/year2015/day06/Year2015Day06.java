package pl.sarseth.advent.year2015.day06;

import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.InputReader;
import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.MyFrame;

public class Year2015Day06 {

    private enum Action {
        TOGGLE,
        TURN_ON,
        TURN_OFF
    }

    public static void main(String[] args) throws InterruptedException {
        Year2015Day06GridPainter painter = new Year2015Day06GridPainter();
        new MyFrame(1000, 1000, painter);

        var input = InputReader.readInputAndDivide("201506");

        for (var str : input) {
            var splitString = str.split(" ");

            String startingPos, destinationPos;
            Action action;
            if (splitString[0].equals("turn")) {
                startingPos = splitString[2];
                destinationPos = splitString[4];
                if (splitString[1].equals("off")) {
                    action = Action.TURN_OFF;
                } else {
                    action = Action.TURN_ON;
                }
            } else {
                startingPos = splitString[1];
                destinationPos = splitString[3];
                action = Action.TOGGLE;
            }

            int startX, startY, finishX, finishY;
            String[] split = startingPos.split(",");
            startX = Integer.valueOf(split[0]);
            startY = Integer.valueOf(split[1]);
            split = destinationPos.split(",");
            finishX = Integer.valueOf(split[0]);
            finishY = Integer.valueOf(split[1]);

            for (var x = startX; x <= finishX; x++) {
                for (var y = startY; y <= finishY; y++) {
                    switch (action) {
                        case TOGGLE:
                            painter.toggle(x, y);
                            break;
                        case TURN_ON:
                            painter.turnOn(x, y);
                            break;
                        case TURN_OFF:
                            painter.turnOff(x, y);
                            break;
                    }
                }
            }
            Thread.sleep(50L);

        }
        painter.printHowManyLightsAreOn();
    }
}