package com.tomasz.core;

import java.io.InputStream;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertySupplier {
  @Getter
  private static final EnvironmentConfigurationData environmentConfigurationData;

  static {
    String environmentFilePath =
        String.format("environments/%s.yaml", System.getProperty("envName", "uat"));
    log.info(environmentFilePath);
    InputStream configStream = PropertySupplier.class.getClassLoader()
        .getResourceAsStream(environmentFilePath);
    environmentConfigurationData =
        new Yaml().loadAs(configStream, EnvironmentConfigurationData.class);
  }
}
