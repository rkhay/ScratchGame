package org.rkhayrit.models.probabilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rkhayrit.models.probabilities.ProbabilitySymbolsStandard;

public class StandardSymbol {
    public int column;
    public int row;
    @JsonProperty("symbols")
    public ProbabilitySymbolsStandard probabilitySymbolsStandard;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public ProbabilitySymbolsStandard getProbabilitySymbols() {
        return probabilitySymbolsStandard;
    }

    public void setProbabilitySymbols(ProbabilitySymbolsStandard probabilitySymbolsStandard) {
        this.probabilitySymbolsStandard = probabilitySymbolsStandard;
    }
}
