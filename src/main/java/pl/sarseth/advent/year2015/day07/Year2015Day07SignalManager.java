package pl.sarseth.advent.year2015.day07;

import java.util.HashMap;
import java.util.Map;

class Year2015Day07SignalManager {

    private Map<String, Year2015Day07Signal> signalMap = new HashMap<>();

    boolean isSignalCalculated(String signalId) {
        Year2015Day07Signal signal = signalMap.get(signalId);
        return signal != null;
    }

    void putSignal(String signalId, Year2015Day07Signal signal) {
        signalMap.put(signalId, signal);
    }

    Year2015Day07Signal getSignal(String signalId) {
        return signalMap.get(signalId);
    }

    void printASignalAsInt() {
        Year2015Day07Signal a = signalMap.get("a");
        System.out.println(a.getAsInt());
    }
}
