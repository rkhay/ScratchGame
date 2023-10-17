package org.rkhayrit;

import picocli.CommandLine;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@CommandLine.Command(name = "GameStarter")
public class GameStarter implements Runnable {

    @CommandLine.Option(names = {"--config", "configuration file name"})
    private String json;
    @CommandLine.Option(names = {"--betting-amount", "amount to bet"})
    private Double bettingAmount;

    public static void main(String[] args) {
        new CommandLine(new GameStarter()).execute(args);
    }

    @Override
    public void run() {
        try(InputStream inputStream = Files.newInputStream(Paths.get(json))) {
            Configuration.buildConfig(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        startTheGame(bettingAmount);
    }

    public void startTheGame(Double bettingAmount) {
        Matrix matrix = new Matrix(Configuration.getConfig().getRows(),
                                   Configuration.getConfig().getColumns());

        String[][] generatedMatrix = Matrix.getMatrix();

        Map<String, Integer> matchSymbols = matrix.calculateMatchingSymbols(generatedMatrix);
        int reward = new Reward().calculateReward(matchSymbols, bettingAmount);
        matrix.printResult(reward);
    }
}
