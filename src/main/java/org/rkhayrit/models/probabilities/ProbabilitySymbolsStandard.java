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

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
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