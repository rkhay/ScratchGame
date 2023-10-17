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

    public SameSymbol4Times getSameSymbol4Times() {
        return sameSymbol4Times;
    }

    public SameSymbol5Times getSameSymbol5Times() {
        return sameSymbol5Times;
    }

    public SameSymbol6Times getSameSymbol6Times() {
        return sameSymbol6Times;
    }

    public SameSymbol7Times getSameSymbol7Times() {
        return sameSymbol7Times;
    }

    public SameSymbol8Times getSameSymbol8Times() {
        return sameSymbol8Times;
    }

    public SameSymbol9Times getSameSymbol9Times() {
        return sameSymbol9Times;
    }

    public SameSymbolsDiagonallyLeftToRight getSameSymbolsDiagonallyLeftToRight() {
        return sameSymbolsDiagonallyLeftToRight;
    }

    public SameSymbolsDiagonallyRightToLeft getSameSymbolsDiagonallyRightToLeft() {
        return sameSymbolsDiagonallyRightToLeft;
    }
}
