package org.rkhayrit.models.symbols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Miss {
    @JsonProperty("type")
    private String type;
    @JsonProperty("impact")
    private String impact;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
