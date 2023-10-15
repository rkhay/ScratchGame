package org.rkhayrit.models.combinations;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rkhayrit.models.combinations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinCombinations {

    @JsonProperty("same_symbol_3_times")
    private SameSymbol3Times sameSymbol3Times;
    @JsonProperty("same_symbol_4_times")
    private SameSymbol4Times sameSymbol4Times;
    @JsonProperty("same_symbol_5_times")
    private SameSymbol5Times sameSymbol5Times;
    @JsonProperty("same_symbol_6_times")
    private SameSymbol6Times sameSymbol6Times;
    @JsonProperty("same_symbol_7_times")
    private SameSymbol7Times sameSymbol7Times;
    @JsonProperty("same_symbol_8_times")
    private SameSymbol8Times sameSymbol8Times;
    @JsonProperty("same_symbol_9_times")
    private SameSymbol9Times sameSymbol9Times;
    @JsonProperty("same_symbols_horizontally")
    private SameSymbolsHorizontally sameSymbolsHorizontally;
    @JsonProperty("same_symbols_vertically")
    private SameSymbolsVertically sameSymbolsVertically;
    @JsonProperty("same_symbols_diagonally_left_to_right")
    private SameSymbolsDiagonallyLeftToRight sameSymbolsDiagonallyLeftToRight;
    @JsonProperty("same_symbols_diagonally_right_to_left")
    private SameSymbolsDiagonallyRightToLeft sameSymbolsDiagonallyRightToLeft;


    public SameSymbol3Times getSameSymbol3Times() {
        return sameSymbol3Times;
    }

    public void setSameSymbol3Times(SameSymbol3Times sameSymbol3Times) {
        this.sameSymbol3Times = sameSymbol3Times;
    }

    public SameSymbol4Times getSameSymbol4Times() {
        return sameSymbol4Times;
    }

    public void setSameSymbol4Times(SameSymbol4Times sameSymbol4Times) {
        this.sameSymbol4Times = sameSymbol4Times;
    }

    public SameSymbol5Times getSameSymbol5Times() {
        return sameSymbol5Times;
    }

    public void setSameSymbol5Times(SameSymbol5Times sameSymbol5Times) {
        this.sameSymbol5Times = sameSymbol5Times;
    }

    public SameSymbol6Times getSameSymbol6Times() {
        return sameSymbol6Times;
    }

    public void setSameSymbol6Times(SameSymbol6Times sameSymbol6Times) {
        this.sameSymbol6Times = sameSymbol6Times;
    }

    public SameSymbol7Times getSameSymbol7Times() {
        return sameSymbol7Times;
    }

    public void setSameSymbol7Times(SameSymbol7Times sameSymbol7Times) {
        this.sameSymbol7Times = sameSymbol7Times;
    }

    public SameSymbol8Times getSameSymbol8Times() {
        return sameSymbol8Times;
    }

    public void setSameSymbol8Times(SameSymbol8Times sameSymbol8Times) {
        this.sameSymbol8Times = sameSymbol8Times;
    }

    public SameSymbol9Times getSameSymbol9Times() {
        return sameSymbol9Times;
    }

    public void setSameSymbol9Times(SameSymbol9Times sameSymbol9Times) {
        this.sameSymbol9Times = sameSymbol9Times;
    }

    public SameSymbolsHorizontally getSameSymbolsHorizontally() {
        return sameSymbolsHorizontally;
    }

    public void setSameSymbolsHorizontally(SameSymbolsHorizontally sameSymbolsHorizontally) {
        this.sameSymbolsHorizontally = sameSymbolsHorizontally;
    }

    public SameSymbolsVertically getSameSymbolsVertically() {
        return sameSymbolsVertically;
    }

    public void setSameSymbolsVertically(SameSymbolsVertically sameSymbolsVertically) {
        this.sameSymbolsVertically = sameSymbolsVertically;
    }

    public SameSymbolsDiagonallyLeftToRight getSameSymbolsDiagonallyLeftToRight() {
        return sameSymbolsDiagonallyLeftToRight;
    }

    public void setSameSymbolsDiagonallyLeftToRight(SameSymbolsDiagonallyLeftToRight sameSymbolsDiagonallyLeftToRight) {
        this.sameSymbolsDiagonallyLeftToRight = sameSymbolsDiagonallyLeftToRight;
    }

    public SameSymbolsDiagonallyRightToLeft getSameSymbolsDiagonallyRightToLeft() {
        return sameSymbolsDiagonallyRightToLeft;
    }

    public void setSameSymbolsDiagonallyRightToLeft(SameSymbolsDiagonallyRightToLeft sameSymbolsDiagonallyRightToLeft) {
        this.sameSymbolsDiagonallyRightToLeft = sameSymbolsDiagonallyRightToLeft;
    }
}
