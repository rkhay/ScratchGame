package org.rkhayrit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputForm {
    private List<List<String>> matrix;
    private int reward;
    private Map<String, List<String>> appliedWinningCombinations;
    private String appliedBonusSymbol;

    public OutputForm() {
    }

    public OutputForm(List<List<String>> matrix, int reward, Map<String, List<String>> appliedWinningCombinations, String appliedBonusSymbol) {
        this.matrix = matrix;
        this.reward = reward;
        this.appliedWinningCombinations = appliedWinningCombinations;
        this.appliedBonusSymbol = appliedBonusSymbol;
    }

    public List<List<String>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<String>> matrix) {
        this.matrix = matrix;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public Map<String, List<String>> getAppliedWinningCombinations() {
        return appliedWinningCombinations;
    }

    public void setAppliedWinningCombinations(Map<String, List<String>> appliedWinningCombinations) {
        this.appliedWinningCombinations = appliedWinningCombinations;
    }

    public String getAppliedBonusSymbol() {
        return appliedBonusSymbol;
    }

    public void setAppliedBonusSymbol(String appliedBonusSymbol) {
        this.appliedBonusSymbol = appliedBonusSymbol;
    }

    @Override
    public String toString() {
        List<String> value = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ").append("\"matrix\":[").append("\n");
        for (int i = 0; i < matrix.size(); i++) {
            value = matrix.get(i);
            stringBuilder.append(value).append("\n");
        }
        stringBuilder.append(
                        "],")
                .append("\n").append("\"reward\": ").append(reward).append(",")
                .append("\n").append("appliedWinningCombinations=").append(appliedWinningCombinations)
                .append(" appliedBonusSymbol='").append(appliedBonusSymbol).append('\'').append('}');
        return stringBuilder.toString();
    }
}
