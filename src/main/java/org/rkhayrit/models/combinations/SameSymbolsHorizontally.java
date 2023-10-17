package org.rkhayrit.models.combinations;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SameSymbolsHorizontally {
    @JsonProperty("reward_multiplier")
    private double rewardMultiplier;
    @JsonProperty("when")
    private String when;
    @JsonProperty("group")
    private String group;
    @JsonProperty("covered_areas")
    private List<List<String>> coveredAreas = new ArrayList<List<String>>();

    public double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
