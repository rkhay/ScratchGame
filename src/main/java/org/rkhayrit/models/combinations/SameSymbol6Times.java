package org.rkhayrit.models.combinations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SameSymbol6Times {
    @JsonProperty("reward_multiplier")
    private double rewardMultiplier;
    @JsonProperty("when")
    private String when;
    @JsonProperty("count")
    private int count;
    @JsonProperty("group")
    private String group;

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

    public int getCount() {
        return count;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
