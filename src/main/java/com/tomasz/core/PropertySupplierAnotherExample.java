package com.tomasz.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertySupplierAnotherExample {
    @Getter
    private static final EnvironmentConfigurationData environmentConfigurationData;

    static {
        Yaml yaml = new Yaml(new Constructor(EnvironmentConfigurationData.class, new LoaderOptions()));
        String environmentFilePath =
                String.format("environments/%s.yaml", System.getProperty("envName", "uat"));
        InputStream configStream = PropertySupplierAnotherExample.class.getClassLoader()
                .getResourceAsStream(environmentFilePath);
        environmentConfigurationData = yaml.load(configStream);
    }
}
