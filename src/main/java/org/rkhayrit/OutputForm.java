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

    @Override
    public String toString() {
        List<String> value;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ \"matrix\":[\n");
        for (int i = 0; i < matrix.size(); i++) {
            value = matrix.get(i);
            stringBuilder.append(value).append("\n");
        }
        stringBuilder.append("],\n")
                .append("\"reward\": ").append(reward).append(",\n")
                .append("appliedWinningCombinations=")
                .append(appliedWinningCombinations)
                .append(" appliedBonusSymbol='")
                .append(appliedBonusSymbol).append('\'').append('}');
        return stringBuilder.toString();
    }
}
