package org.rkhayrit.models.symbols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class _500 {
    @JsonProperty("extra")
    private Double extra;
    @JsonProperty("type")
    private String type;
    @JsonProperty("impact")
    private String impact;
    public Double getExtra() {
        return extra;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
