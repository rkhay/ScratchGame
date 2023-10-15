package org.rkhayrit.models.probabilities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Probabilities {
    @JsonProperty("standard_symbols")
    private List<StandardSymbol> standardSymbols = new ArrayList<StandardSymbol>();
    @JsonProperty("bonus_symbols")
    private BonusSymbols bonusSymbols;

    public List<StandardSymbol> getStandardSymbols() {
        return standardSymbols;
    }

    public void setStandardSymbols(List<StandardSymbol> standardSymbols) {
        this.standardSymbols = standardSymbols;
    }

    public BonusSymbols getBonusSymbols() {
        return bonusSymbols;
    }

    public void setBonusSymbols(BonusSymbols bonusSymbols) {
        this.bonusSymbols = bonusSymbols;
    }
}
