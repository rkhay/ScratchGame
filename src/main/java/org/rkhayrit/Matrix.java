package org.rkhayrit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.rkhayrit.models.combinations.WinCombinations;
import org.rkhayrit.models.probabilities.Probabilities;
import org.rkhayrit.models.probabilities.ProbabilitySymbolsBonus;
import org.rkhayrit.models.probabilities.ProbabilitySymbolsStandard;

import java.util.*;
import java.util.stream.Collectors;

public class Matrix {
    private int rows;
    private int columns;
    private static String[][] matrix;
    private final Map<String, Double> mapBonusSymProb = new HashMap<>();
    private final Map<String, Double> mapProb = new HashMap<>();
    private static final Map<String, Double> diagonals = new HashMap<>();

    public Matrix() {
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        Probabilities probabilities = Configuration.getConfig().getProbabilities();
        ProbabilitySymbolsBonus bonusSymbols = probabilities.getBonusSymbols().getProbabilitySymbols();
        mapBonusSymProb.put("10x", bonusSymbols.get_10x() / 15d);
        mapBonusSymProb.put("5x", bonusSymbols.get_5x() / 15d);
        mapBonusSymProb.put("1000", bonusSymbols.get_1000() / 15d);
        mapBonusSymProb.put("500", bonusSymbols.get_500() / 15d);
        mapBonusSymProb.put("MISS", bonusSymbols.getmISS() / 15d);

        ProbabilitySymbolsStandard standardSymbols = probabilities.getStandardSymbols().get(0).getProbabilitySymbols();
        mapProb.put("A", standardSymbols.getA() / 21d);
        mapProb.put("B", standardSymbols.getB() / 21d);
        mapProb.put("C", standardSymbols.getC() / 21d);
        mapProb.put("D", standardSymbols.getD() / 21d);
        mapProb.put("E", standardSymbols.getE() / 21d);
        mapProb.put("F", standardSymbols.getF() / 21d);
        matrix = generateMatrix();
        checkDiagLeftToRight();
        checkDiagRightToLeft();
    }

    private String[][] generateMatrix() {
        String[][] matrix = new String[rows][columns];

        int[] cells = findCellForBonusSymbol(rows);
        matrix[cells[0]][cells[1]] = getRandomBonusSymbol();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] == null) {
                    matrix[i][j] = randomSymbols();
                }
            }
        }
        Matrix.matrix = matrix;
        return matrix;
    }

    public void printMatrix(int reward) {
        List<List<String>> matrixList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                list.add(matrix[i][j]);
                System.out.print(matrix[i][j] + " ");
            }
            matrixList.add(list);
            System.out.println();
        }


        Map<String, List<String>> appliedWinningCombinations = applyWinningCombinations(matrix);

        String bonusSymbol = getBonusSymbol();
        OutputForm outputForm = new OutputForm(matrixList, reward, appliedWinningCombinations, bonusSymbol);
        try {
            String json = new ObjectMapper().writeValueAsString(outputForm);
            System.out.println(json);
            System.out.println(outputForm);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBonusSymbol() {
        Map<String, Integer> matchingSymbols = calculateMatchingSymbols(matrix);
        return matchingSymbols.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.joining());
    }

    public Map<String, List<String>> applyWinningCombinations(String[][] matrix) {
        Map<String, Integer> matchingSymbols = calculateMatchingSymbols(matrix);
        Map<String, List<String>> appliedWinningCombinations = new HashMap<>();

        WinCombinations winCombinations = Configuration.getConfig().getWinCombinations();
        Map<Integer, String> winCombinationsMap = new HashMap<>();
        winCombinationsMap.put(winCombinations.getSameSymbol3Times().getCount(), winCombinations.getSameSymbol3Times().getWhen());
        winCombinationsMap.put(winCombinations.getSameSymbol4Times().getCount(), winCombinations.getSameSymbol4Times().getWhen());
        winCombinationsMap.put(winCombinations.getSameSymbol5Times().getCount(), winCombinations.getSameSymbol5Times().getWhen());
        winCombinationsMap.put(winCombinations.getSameSymbol6Times().getCount(), winCombinations.getSameSymbol6Times().getWhen());
        winCombinationsMap.put(winCombinations.getSameSymbol7Times().getCount(), winCombinations.getSameSymbol7Times().getWhen());
        winCombinationsMap.put(winCombinations.getSameSymbol8Times().getCount(), winCombinations.getSameSymbol8Times().getWhen());
        winCombinationsMap.put(winCombinations.getSameSymbol9Times().getCount(), winCombinations.getSameSymbol9Times().getWhen());

        matchingSymbols.entrySet().stream().filter(v -> v.getValue() > 1)
                .forEach(e -> {
                    List<String> list = new ArrayList<>();
                    list.add(winCombinationsMap.get(e.getValue()));
                    appliedWinningCombinations.put(e.getKey(), list);
                });

        return appliedWinningCombinations;

    }

    private int[] findCellForBonusSymbol(int bound) {
        int r = new Random().nextInt(bound);
        int c = new Random().nextInt(bound);
        return new int[]{r, c};
    }


    private String getRandomBonusSymbol() {
        double r = Math.random();

        if (r < mapBonusSymProb.get("10x")) {
            return "10x";
        } else if (r < mapBonusSymProb.get("10x") + mapBonusSymProb.get("5x")) {
            return "5x";
        } else if (r < mapBonusSymProb.get("10x") + mapBonusSymProb.get("5x") + mapBonusSymProb.get("1000")) {
            return "1000";
        } else if (r < mapBonusSymProb.get("10x") + mapBonusSymProb.get("5x") + mapBonusSymProb.get("1000") + mapBonusSymProb.get("500")) {
            return "500";
        } else {
            return "MISS";
        }
    }

    private String randomSymbols() {
        double r = Math.random();

        if (r < mapProb.get("A")) {
            return "A";
        } else if (r < mapProb.get("B") + mapProb.get("A")) {
            return "B";
        } else if (r < mapProb.get("B") + mapProb.get("A") + mapProb.get("C")) {
            return "C";
        } else if (r < mapProb.get("D") + mapProb.get("B") + mapProb.get("A") + mapProb.get("C")) {
            return "D";
        } else if (r < mapProb.get("E") + mapProb.get("D") + mapProb.get("B") + mapProb.get("A") + mapProb.get("C")) {
            return "E";
        } else {
            return "F";
        }
    }

    public Map<String, Integer> calculateMatchingSymbols(String[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j], map.get(matrix[i][j]) + 1);
                }
                map.putIfAbsent(matrix[i][j], 1);
            }
        }

        System.out.println("--------------------------------");
//        map.forEach((key, value) -> System.out.println(key + " " + value));
//        System.out.println("--------------------------------");
        List<String> symbolsList = Arrays.asList("A", "B", "C", "D", "E", "F");

        Map<String, Integer> result = map.entrySet().stream()
                .filter(k -> k.getValue() > 2 || !symbolsList.contains(k.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        result.forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println("----------------------");
        return result;
    }

    private void checkDiagRightToLeft() {
        int length = matrix.length;
        for (int i = 1; i < length; i++) {
            if (!matrix[i][length - 1 - i].equals(matrix[0][length - 1])) {
                return;
            }
        }
        diagonals.put(matrix[2][0], Configuration.getConfig().getWinCombinations().getSameSymbolsDiagonallyRightToLeft().getRewardMultiplier());
    }

    private void checkDiagLeftToRight() {
        for (int i = 1; i < matrix.length; i++) {
            if (!matrix[i][i].equals(matrix[0][0])) {
                return;
            }
        }
        diagonals.put(matrix[0][0], Configuration.getConfig().getWinCombinations().getSameSymbolsDiagonallyLeftToRight().getRewardMultiplier());
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public static String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public static Map<String, Double> getDiagonals() {
        return diagonals;
    }
}
