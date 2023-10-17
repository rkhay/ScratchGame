package org.rkhayrit.models.probabilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rkhayrit.models.probabilities.ProbabilitySymbolsStandard;

public class StandardSymbol {
    @JsonProperty("column")
    public int column;
    @JsonProperty("row")
    public int row;
    @JsonProperty("symbols")
    public ProbabilitySymbolsStandard probabilitySymbolsStandard;

    public ProbabilitySymbolsStandard getProbabilitySymbols() {
        return probabilitySymbolsStandard;
    }
}
