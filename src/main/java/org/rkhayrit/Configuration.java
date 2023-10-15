package org.rkhayrit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rkhayrit.models.symbols.ScratchGame;

import java.io.IOException;
import java.io.InputStream;

public class Configuration {

    private static ScratchGame config;

    public static void buildConfig(InputStream inputStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        config = mapper.readValue(inputStream, ScratchGame.class);
    }

    public static ScratchGame getConfig() {
        return config;
    }
}
