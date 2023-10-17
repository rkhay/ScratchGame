package org.rkhayrit.models.symbols;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class _10x {
    @JsonProperty("reward_multiplier")
    private Double rewardMultiplier;
    @JsonProperty("type")
    private String type;
    @JsonProperty("impact")
    private String impact;

    public Double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(Double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
