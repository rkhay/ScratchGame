package org.rkhayrit;

import org.rkhayrit.models.combinations.WinCombinations;
import org.rkhayrit.models.probabilities.Probabilities;
import org.rkhayrit.models.probabilities.ProbabilitySymbolsBonus;
import org.rkhayrit.models.probabilities.ProbabilitySymbolsStandard;

import java.util.*;
import java.util.stream.Collectors;

public class Matrix {
    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String D = "D";
    public static final String E = "E";
    public static final String F = "F";
    public static final String X10 = "10x";
    public static final String X5 = "5x";
    public static final String _1000 = "1000";
    public static final String _500 = "500";
    public static final String MISS = "MISS";

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
        mapBonusSymProb.put(X10, bonusSymbols.get10X() / 15d);
        mapBonusSymProb.put(X5, bonusSymbols.get5X() / 15d);
        mapBonusSymProb.put(_1000, bonusSymbols.get1000() / 15d);
        mapBonusSymProb.put(_500, bonusSymbols.get500() / 15d);
        mapBonusSymProb.put(MISS, bonusSymbols.getmISS() / 15d);

        ProbabilitySymbolsStandard standardSymbols = probabilities.getStandardSymbols().get(0).getProbabilitySymbols();
        mapProb.put(A, standardSymbols.getA() / 21d);
        mapProb.put(B, standardSymbols.getB() / 21d);
        mapProb.put(C, standardSymbols.getC() / 21d);
        mapProb.put(D, standardSymbols.getD() / 21d);
        mapProb.put(E, standardSymbols.getE() / 21d);
        mapProb.put(F, standardSymbols.getF() / 21d);
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

    public void printResult(int reward) {
        List<List<String>> matrixList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                list.add(matrix[i][j]);
            }
            matrixList.add(list);

        }
        System.out.println();
        Map<String, List<String>> appliedWinningCombinations = applyWinningCombinations(matrix);
        String bonusSymbol = getBonusSymbol();
        OutputForm outputForm = new OutputForm(matrixList, reward, appliedWinningCombinations, bonusSymbol);
        System.out.println(outputForm);
    }

    public String getBonusSymbol() {
        Map<String, Integer> matchingSymbols = calculateMatchingSymbols(matrix);
        return matchingSymbols.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey).collect(Collectors.joining());
    }

    private Map<String, List<String>> applyWinningCombinations(String[][] matrix) {
        Map<String, Integer> matchingSymbols = calculateMatchingSymbols(matrix);
        Map<String, List<String>> appliedWinningCombinations = new HashMap<>();
        Map<Integer, String> winCombinationsMap = getWinCombinationsMap();

        matchingSymbols.entrySet().stream().filter(v -> v.getValue() > 1)
                .forEach(e -> {
                    List<String> list = new ArrayList<>();
                    list.add(winCombinationsMap.get(e.getValue()));
                    appliedWinningCombinations.put(e.getKey(), list);
                });

        if (checkDiagRightToLeft()) {
            String symbolsDiagonallyRightToLeft =
                    Configuration.getConfig().getWinCombinations().getSameSymbolsDiagonallyRightToLeft().getClass().getSimpleName();

            if (appliedWinningCombinations.containsKey(Matrix.matrix[2][0])) {
                appliedWinningCombinations.get(Matrix.matrix[2][0]).add(symbolsDiagonallyRightToLeft);
            }


        } else if (checkDiagLeftToRight()) {
            String symbolsDiagonallyLeftToRight =
                    Configuration.getConfig().getWinCombinations().getSameSymbolsDiagonallyLeftToRight().getClass().getSimpleName();

            if (appliedWinningCombinations.containsKey(Matrix.matrix[0][0])) {
                appliedWinningCombinations.get(Matrix.matrix[0][0]).add(symbolsDiagonallyLeftToRight);
            }
        }
        return appliedWinningCombinations;
    }

    private static Map<Integer, String> getWinCombinationsMap() {
        WinCombinations winCombinations = Configuration.getConfig().getWinCombinations();
        Map<Integer, String> winCombinationsMap = new HashMap<>();
        winCombinationsMap.put(winCombinations.getSameSymbol3Times().getCount(), winCombinations.getSameSymbol3Times().getClass().getSimpleName());
        winCombinationsMap.put(winCombinations.getSameSymbol4Times().getCount(), winCombinations.getSameSymbol4Times().getClass().getSimpleName());
        winCombinationsMap.put(winCombinations.getSameSymbol5Times().getCount(), winCombinations.getSameSymbol5Times().getClass().getSimpleName());
        winCombinationsMap.put(winCombinations.getSameSymbol6Times().getCount(), winCombinations.getSameSymbol6Times().getClass().getSimpleName());
        winCombinationsMap.put(winCombinations.getSameSymbol7Times().getCount(), winCombinations.getSameSymbol7Times().getClass().getSimpleName());
        winCombinationsMap.put(winCombinations.getSameSymbol8Times().getCount(), winCombinations.getSameSymbol8Times().getClass().getSimpleName());
        winCombinationsMap.put(winCombinations.getSameSymbol9Times().getCount(), winCombinations.getSameSymbol9Times().getClass().getSimpleName());
        return winCombinationsMap;
    }

    private int[] findCellForBonusSymbol(int bound) {
        int row = new Random().nextInt(bound);
        int column = new Random().nextInt(bound);
        return new int[]{row, column};
    }

    private String getRandomBonusSymbol() {
        double r = Math.random();

        if (r < mapBonusSymProb.get(X10)) {
            return X10;
        } else if (r < mapBonusSymProb.get(X10) + mapBonusSymProb.get(X5)) {
            return X5;
        } else if (r < mapBonusSymProb.get(X10) + mapBonusSymProb.get(X5) + mapBonusSymProb.get(_1000)) {
            return _1000;
        } else if (r < mapBonusSymProb.get(X10) + mapBonusSymProb.get(X5) + mapBonusSymProb.get(_1000) + mapBonusSymProb.get(_500)) {
            return _500;
        } else {
            return MISS;
        }
    }

    private String randomSymbols() {
        double r = Math.random();

        if (r < mapProb.get(A)) {
            return A;
        } else if (r < mapProb.get(B) + mapProb.get(A)) {
            return B;
        } else if (r < mapProb.get(B) + mapProb.get(A) + mapProb.get(C)) {
            return C;
        } else if (r < mapProb.get(D) + mapProb.get(B) + mapProb.get(A) + mapProb.get(C)) {
            return D;
        } else if (r < mapProb.get(E) + mapProb.get(D) + mapProb.get(B) + mapProb.get(A) + mapProb.get(C)) {
            return E;
        } else {
            return F;
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
        List<String> symbolsList = Arrays.asList(A, B, C, D, E, F);
        return map.entrySet().stream()
                .filter(k -> k.getValue() > 2 || !symbolsList.contains(k.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private boolean checkDiagRightToLeft() {
        int length = Matrix.matrix.length;
        for (int i = 1; i < length; i++) {
            if (!Matrix.matrix[i][length - 1 - i].equals(Matrix.matrix[0][length - 1])) {
                return false;
            }
        }
        diagonals.put(Matrix.matrix[2][0], Configuration.getConfig().getWinCombinations().getSameSymbolsDiagonallyRightToLeft().getRewardMultiplier());
        return true;
    }

    private boolean checkDiagLeftToRight() {
        for (int i = 1; i < Matrix.matrix.length; i++) {
            if (!Matrix.matrix[i][i].equals(Matrix.matrix[0][0])) {
                return false;
            }
        }
        diagonals.put(Matrix.matrix[0][0], Configuration.getConfig().getWinCombinations().getSameSymbolsDiagonallyLeftToRight().getRewardMultiplier());
        return true;
    }

    public static String[][] getMatrix() {
        return matrix;
    }

    public static Map<String, Double> getDiagonals() {
        return diagonals;
    }
}
