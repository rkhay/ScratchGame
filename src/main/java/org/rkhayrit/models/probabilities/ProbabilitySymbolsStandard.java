package org.rkhayrit.models.probabilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProbabilitySymbolsStandard {
    @JsonProperty("A")
    private int A;
    @JsonProperty("B")
    private int B;
    @JsonProperty("C")
    private int C;
    @JsonProperty("D")
    private int D;
    @JsonProperty("E")
    private int E;
    @JsonProperty("F")
    private int F;

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public int getC() {
        return C;
    }

    public int getD() {
        return D;
    }

    public int getE() {
        return E;
    }

    public int getF() {
        return F;
    }

    @Override
    public String toString() {
        return "ProbabilitySymbolsStandard{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                ", D=" + D +
                ", E=" + E +
                ", F=" + F +
                '}';
    }
}