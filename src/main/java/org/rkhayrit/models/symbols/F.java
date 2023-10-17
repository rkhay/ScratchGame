package org.rkhayrit.models.symbols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class F {
    @JsonProperty("reward_multiplier")
    private Double rewardMultiplier;
    @JsonProperty("type")
    private String type;

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
