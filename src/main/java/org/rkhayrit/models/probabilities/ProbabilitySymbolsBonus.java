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

    public int get_10x() {
        return _10x;
    }

    public void set_10x(int _10x) {
        this._10x = _10x;
    }

    public int get_5x() {
        return _5x;
    }

    public void set_5x(int _5x) {
        this._5x = _5x;
    }

    public int get_1000() {
        return _1000;
    }

    public void set_1000(int _1000) {
        this._1000 = _1000;
    }

    public int get_500() {
        return _500;
    }

    public void set_500(int _500) {
        this._500 = _500;
    }

    public int getmISS() {
        return mISS;
    }

    public void setmISS(int mISS) {
        this.mISS = mISS;
    }
}
