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

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }

    public D getD() {
        return d;
    }

    public E getE() {
        return e;
    }

    public F getF() {
        return f;
    }

    public _10x get10X() {
        return _10x;
    }

    public _5x get5X() {
        return _5x;
    }

    public _1000 get1000() {
        return _1000;
    }

    public _500 get500() {
        return _500;
    }

    public Miss getmISS() {
        return mISS;
    }
}
