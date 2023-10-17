package org.rkhayrit.models.probabilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProbabilitySymbolsBonus {
    @JsonProperty("10x")
    private int _10x;
    @JsonProperty("5x")
    private int _5x;
    @JsonProperty("+1000")
    private int _1000;
    @JsonProperty("+500")
    private int _500;
    @JsonProperty("MISS")
    private int mISS;

    public int get10X() {
        return _10x;
    }

    public int get5X() {
        return _5x;
    }

    public int get1000() {
        return _1000;
    }

    public int get500() {
        return _500;
    }

    public int getmISS() {
        return mISS;
    }

}
