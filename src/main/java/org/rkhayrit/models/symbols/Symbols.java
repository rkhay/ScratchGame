package org.rkhayrit.models.symbols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Symbols {
    @JsonProperty("A")
    private A a;
    @JsonProperty("B")
    private B b;
    @JsonProperty("C")
    private C c;
    @JsonProperty("D")
    private D d;
    @JsonProperty("E")
    private E e;
    @JsonProperty("F")
    private F f;
    @JsonProperty("10x")
    private _10x _10x;
    @JsonProperty("5x")
    private _5x _5x;
    @JsonProperty("+1000")
    private _1000 _1000;
    @JsonProperty("+500")
    private _500 _500;
    @JsonProperty("MISS")
    private Miss mISS;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public F getF() {
        return f;
    }

    public void setF(F f) {
        this.f = f;
    }

    public _10x get_10x() {
        return _10x;
    }

    public void set_10x(_10x _10x) {
        this._10x = _10x;
    }

    public _5x get_5x() {
        return _5x;
    }

    public void set_5x(_5x _5x) {
        this._5x = _5x;
    }

    public _1000 get_1000() {
        return _1000;
    }

    public void set_1000(_1000 _1000) {
        this._1000 = _1000;
    }

    public _500 get_500() {
        return _500;
    }

    public void set_500(_500 _500) {
        this._500 = _500;
    }

    public Miss getmISS() {
        return mISS;
    }

    public void setmISS(Miss mISS) {
        this.mISS = mISS;
    }
}
