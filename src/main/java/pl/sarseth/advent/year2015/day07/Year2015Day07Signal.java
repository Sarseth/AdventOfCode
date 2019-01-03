package pl.sarseth.advent.year2015.day07;

class Year2015Day07Signal {

    private static int SIG_LNT = 16;

    boolean[] signal = new boolean[SIG_LNT];

    void setNumber(int val) {
        var binaryString = Integer.toBinaryString(val);
        int binaryLength = binaryString.length();
        for (var i = 0; i < binaryLength; i++) {
            signal[SIG_LNT - binaryLength + i] = binaryString.charAt(i) == '1';
        }
    }

    Year2015Day07Signal negate() {
        var negation = new Year2015Day07Signal();
        negation.signal = signal;
        for (var i = 0; i < SIG_LNT; i++) {
            negation.signal[i] = !negation.signal[i];
        }
        return negation;
    }

    Year2015Day07Signal leftShift(int val) {
        var shifted = new Year2015Day07Signal();
        var shiftedSignal = new boolean[SIG_LNT];
        for (var i = 0; i < SIG_LNT; i++) {
            var newPlace = i - val;
            if (newPlace >= 0) {
                shiftedSignal[newPlace] = signal[i];
            }
        }
        shifted.signal = shiftedSignal;
        return shifted;
    }

    Year2015Day07Signal rightShift(int val) {
        var shifted = new Year2015Day07Signal();
        var shiftedSignal = new boolean[SIG_LNT];
        for (var i = 0; i < SIG_LNT; i++) {
            var newPlace = i + val;
            if (newPlace < SIG_LNT) {
                shiftedSignal[newPlace] = signal[i];
            }
        }
        shifted.signal = shiftedSignal;
        return shifted;
    }

    Year2015Day07Signal and(Year2015Day07Signal other) {
        var year2015Day07Signal = new Year2015Day07Signal();
        for (var i = 0; i < SIG_LNT; i++) {
            year2015Day07Signal.signal[i] = signal[i] && other.signal[i];
        }
        return year2015Day07Signal;
    }

    Year2015Day07Signal or(Year2015Day07Signal other) {
        var year2015Day07Signal = new Year2015Day07Signal();
        for (var i = 0; i < SIG_LNT; i++) {
            year2015Day07Signal.signal[i] = signal[i] || other.signal[i];
        }
        return year2015Day07Signal;
    }

    int getAsInt() {
        int val = 0;
        for (var i = 0; i < SIG_LNT - 1; i++) {
            if (signal[i]) {
                val += 1;
            }
            val = val << 1;
        }
        if (signal[SIG_LNT - 1]) {
            val += 1;
        }
        return val;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (boolean b : signal) {
            builder.append(b ? "1" : "0");
        }
        return builder.toString();
    }
}
