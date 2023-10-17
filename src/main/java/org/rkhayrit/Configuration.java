package org.rkhayrit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rkhayrit.models.symbols.ScratchGame;

import java.io.IOException;
import java.io.InputStream;

public class Configuration {
    private static ScratchGame config;

    public static void buildConfig(InputStream inputStream) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            config = mapper.readValue(inputStream, ScratchGame.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ScratchGame getConfig() {
        return config;
    }
}
