package org.rkhayrit.models.symbols;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rkhayrit.models.combinations.WinCombinations;
import org.rkhayrit.models.probabilities.Probabilities;

public class ScratchGame {
    @JsonProperty("columns")
    private int columns;
    @JsonProperty("rows")
    private int rows;
    @JsonProperty("symbols")
    private Symbols symbols;
    @JsonProperty("probabilities")
    private Probabilities probabilities;
    @JsonProperty("win_combinations")
    private WinCombinations winCombinations;

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Symbols getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public Probabilities getProbabilities() {
        return probabilities;
    }

    public WinCombinations getWinCombinations() {
        return winCombinations;
    }

    @Override
    public String toString() {
        return "ScratchGame{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", symbols=" + symbols +
                ", probabilities=" + probabilities +
                ", winCombinations=" + winCombinations +
                '}';
    }
}
