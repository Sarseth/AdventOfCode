package pl.sarseth.advent.year2015.day07;

import org.apache.commons.lang3.StringUtils;
import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Year2015Day07 {

    private static final String AND = "AND";
    private static final String OR = "OR";
    private static final String NOT = "NOT";
    private static final String RSHIFT = "RSHIFT";
    private static final String LSHIFT = "LSHIFT";

    public static void main(String[] args) {
        List<String> allLines = new ArrayList<>(InputReader.readInputAndDivide("201507"));

        var signalManager = new Year2015Day07SignalManager();

        modficationOfSecondTask(allLines, signalManager);

        int remainingLines = allLines.size();
        int i = 0;
        while (remainingLines > 0) {
            String logicGate = allLines.get(i);
            var splitString = logicGate.split(" ");

            String[] preGates = findPreGates(logicGate, splitString);

            if (canCalculateNextGate(preGates, signalManager)) {

                if (logicGate.contains(AND)) {
                    andGate(signalManager, splitString[4], preGates);
                } else if (logicGate.contains(OR)) {
                    orGate(signalManager, splitString[4], preGates);
                } else if (logicGate.contains(NOT)) {
                    Year2015Day07Signal signal = signalManager.getSignal(preGates[0]).negate();
                    signalManager.putSignal(splitString[3], signal);
                } else if (logicGate.contains(RSHIFT)) {
                    Year2015Day07Signal signal = signalManager.getSignal(preGates[0]).rightShift(Integer.valueOf(splitString[2]));
                    signalManager.putSignal(splitString[4], signal);
                } else if (logicGate.contains(LSHIFT)) {
                    Year2015Day07Signal signal = signalManager.getSignal(preGates[0]).leftShift(Integer.valueOf(splitString[2]));
                    signalManager.putSignal(splitString[4], signal);
                } else {
                    assign(signalManager, splitString[2], preGates[0]);
                }

                allLines.remove(i);
                remainingLines--;
                i = 0;
            } else {
                i++;
            }
        }

        signalManager.printASignalAsInt();
    }

    private static void modficationOfSecondTask(List<String> allLines, Year2015Day07SignalManager signalManager) {
        Year2015Day07Signal signalB = new Year2015Day07Signal();
        signalB.setNumber(956);
        signalManager.putSignal("b", signalB);
        allLines.remove("14146 -> b");
    }

    private static void andGate(Year2015Day07SignalManager signalManager, String signalId, String[] preGates) {
        Year2015Day07Signal leftSignal;
        if (StringUtils.isNumeric(preGates[0])) {
            leftSignal = new Year2015Day07Signal();
            leftSignal.setNumber(Integer.valueOf(preGates[0]));
        } else {
            leftSignal = signalManager.getSignal(preGates[0]);
        }

        Year2015Day07Signal rightSignal;
        if (StringUtils.isNumeric(preGates[1])) {
            rightSignal = new Year2015Day07Signal();
            rightSignal.setNumber(Integer.valueOf(preGates[1]));
        } else {
            rightSignal = signalManager.getSignal(preGates[1]);
        }

        Year2015Day07Signal signal = leftSignal.and(rightSignal);
        signalManager.putSignal(signalId, signal);
    }

    private static void orGate(Year2015Day07SignalManager signalManager, String signalId, String[] preGates) {
        Year2015Day07Signal leftSignal;
        if (StringUtils.isNumeric(preGates[0])) {
            leftSignal = new Year2015Day07Signal();
            leftSignal.setNumber(Integer.valueOf(preGates[0]));
        } else {
            leftSignal = signalManager.getSignal(preGates[0]);
        }

        Year2015Day07Signal rightSignal;
        if (StringUtils.isNumeric(preGates[1])) {
            rightSignal = new Year2015Day07Signal();
            rightSignal.setNumber(Integer.valueOf(preGates[1]));
        } else {
            rightSignal = signalManager.getSignal(preGates[1]);
        }

        Year2015Day07Signal signal = leftSignal.or(rightSignal);
        signalManager.putSignal(signalId, signal);
    }

    private static void assign(Year2015Day07SignalManager signalManager, String signalId, String preGate) {
        Year2015Day07Signal signal = new Year2015Day07Signal();
        if (StringUtils.isNumeric(preGate)) {
            signal.setNumber(Integer.valueOf(preGate));
        } else {
            signal.setNumber(signalManager.getSignal(preGate).getAsInt());
        }
        signalManager.putSignal(signalId, signal);
    }

    private static String[] findPreGates(String logicGate, String[] splitString) {
        String[] preGates;
        if (logicGate.contains(AND)) {
            preGates = new String[]{splitString[0], splitString[2]};
        } else if (logicGate.contains(OR)) {
            preGates = new String[]{splitString[0], splitString[2]};
        } else if (logicGate.contains(NOT)) {
            preGates = new String[]{splitString[1]};
        } else if (logicGate.contains(RSHIFT)) {
            preGates = new String[]{splitString[0]};
        } else if (logicGate.contains(LSHIFT)) {
            preGates = new String[]{splitString[0]};
        } else {
            preGates = new String[]{splitString[0]};
        }
        return preGates;
    }

    private static boolean canCalculateNextGate(String[] preGates, Year2015Day07SignalManager signalManager) {
        for (String preGate : preGates) {
            if (!StringUtils.isNumeric(preGate) && !signalManager.isSignalCalculated(preGate)) {
                return false;
            }
        }
        return true;
    }

}
