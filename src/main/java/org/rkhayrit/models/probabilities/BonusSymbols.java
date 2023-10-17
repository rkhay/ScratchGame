package org.rkhayrit.models.probabilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rkhayrit.models.probabilities.ProbabilitySymbolsBonus;

public class BonusSymbols {
    @JsonProperty("symbols")
    private ProbabilitySymbolsBonus symbols;

    public ProbabilitySymbolsBonus getProbabilitySymbols() {
        return symbols;
    }

    public void setSymbols(ProbabilitySymbolsBonus symbols) {
        this.symbols = symbols;
    }
}
