package org.rkhayrit.models.symbols;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rkhayrit.models.combinations.WinCombinations;
import org.rkhayrit.models.probabilities.Probabilities;

public class ScratchGame {
    private int columns;
    private int rows;
    private Symbols symbols;
    private Probabilities probabilities;
    @JsonProperty("win_combinations")
    private WinCombinations winCombinations;

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
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

    public void setProbabilities(Probabilities probabilities) {
        this.probabilities = probabilities;
    }

    public WinCombinations getWinCombinations() {
        return winCombinations;
    }

    public void setWinCombinations(WinCombinations winCombinations) {
        this.winCombinations = winCombinations;
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
