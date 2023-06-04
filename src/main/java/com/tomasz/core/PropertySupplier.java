package com.tomasz.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertySupplier {
    @Getter
    private static EnvironmentConfigurationData environmentConfigurationData;

    public static void loadConfigurationFromFile() {
        String environmentFilePath = String.format("environments/%s.yaml", System.getProperty("envName"));
        log.info(environmentFilePath);
        InputStream configStream = PropertySupplier.class.getClassLoader()
                .getResourceAsStream(environmentFilePath);
        environmentConfigurationData = new Yaml().loadAs(configStream, EnvironmentConfigurationData.class);
    }
}