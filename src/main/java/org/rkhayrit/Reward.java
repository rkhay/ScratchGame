package org.rkhayrit;

import org.rkhayrit.models.combinations.WinCombinations;
import org.rkhayrit.models.symbols.Symbols;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Reward {
    private final Map<Integer, Double> multiplier = new HashMap<>();
    private final Map<String, Double> symbols = new HashMap<>();

    public Reward() {
        WinCombinations wC = Configuration.getConfig().getWinCombinations();
        multiplier.put(wC.getSameSymbol3Times().getCount(), wC.getSameSymbol3Times().getRewardMultiplier());
        multiplier.put(wC.getSameSymbol4Times().getCount(), wC.getSameSymbol4Times().getRewardMultiplier());
        multiplier.put(wC.getSameSymbol5Times().getCount(), wC.getSameSymbol5Times().getRewardMultiplier());
        multiplier.put(wC.getSameSymbol6Times().getCount(), wC.getSameSymbol6Times().getRewardMultiplier());
        multiplier.put(wC.getSameSymbol7Times().getCount(), wC.getSameSymbol7Times().getRewardMultiplier());
        multiplier.put(wC.getSameSymbol8Times().getCount(), wC.getSameSymbol8Times().getRewardMultiplier());
        multiplier.put(wC.getSameSymbol9Times().getCount(), wC.getSameSymbol9Times().getRewardMultiplier());

        Symbols smbls = Configuration.getConfig().getSymbols();
        symbols.put(smbls.getA().getClass().getSimpleName(), smbls.getA().getRewardMultiplier());
        symbols.put(smbls.getB().getClass().getSimpleName(), smbls.getB().getRewardMultiplier());
        symbols.put(smbls.getC().getClass().getSimpleName(), smbls.getC().getRewardMultiplier());
        symbols.put(smbls.getD().getClass().getSimpleName(), smbls.getD().getRewardMultiplier());
        symbols.put(smbls.getE().getClass().getSimpleName(), smbls.getE().getRewardMultiplier());
        symbols.put(smbls.getF().getClass().getSimpleName(), smbls.getF().getRewardMultiplier());

        symbols.put(smbls.get10X().getRewardMultiplier().toString(), smbls.get10X().getRewardMultiplier());
        symbols.put(smbls.get5X().getRewardMultiplier().toString(), smbls.get5X().getRewardMultiplier());
        symbols.put(smbls.get1000().getExtra().toString(), smbls.get1000().getExtra());
        symbols.put(smbls.get500().getExtra().toString(), smbls.get500().getExtra());
        symbols.put(smbls.getmISS().getClass().getSimpleName(), 0d);
    }

    private int calculateStandardSymbolsReward(Map<String, Integer> matchResult, Double betAmount) {
        int reward = 0;
        Map<String, Double> diagonals = Matrix.getDiagonals();
        for (Map.Entry<String, Integer> map : matchResult.entrySet()) {
            double tempValue = 0;

            if (symbols.containsKey(map.getKey()) && map.getValue() > 1) {
                tempValue = betAmount * symbols.get(map.getKey()) * map.getValue() * multiplier.get(map.getValue());
                if (diagonals.containsKey(map.getKey())) {
                    tempValue *= diagonals.get(map.getKey());
                }
            }
            reward += (int) tempValue;
        }
        return reward;
    }

    public int calculateReward(Map<String, Integer> matchResult, Double betAmount) {
        if (matchResult.size() == 1) {
            return 0;
        }

        int reward = calculateStandardSymbolsReward(matchResult, betAmount);

        String bonusSymbol = matchResult.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey).collect(Collectors.joining());

        Symbols sm = Configuration.getConfig().getSymbols();
        if (!bonusSymbol.equals("MISS")) {
            String bonus = bonusSymbol.replaceAll("[^0-9]", "");
            double toDouble = Double.parseDouble(bonus);

            if (symbols.get(Double.toString(toDouble)).equals(sm.get500().getExtra()) ||
                    symbols.get(Double.toString(toDouble)).equals(sm.get1000().getExtra())) {
                reward += symbols.get(Double.toString(toDouble));
            } else if (symbols.get(Double.toString(toDouble)).equals(sm.get10X().getRewardMultiplier()) ||
                    symbols.get(Double.toString(toDouble)).equals(sm.get5X().getRewardMultiplier())) {
                reward *= symbols.get(Double.toString(toDouble));
            }
        }
        return reward;
    }
}
