package com.tomasz.core;

import java.io.IOException;
import java.util.Properties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Config {
  public static Properties getProperties() {
    return PROPERTIES;
  }

  private static final Properties PROPERTIES = new Properties();
  private static final String ENVIRONMENT_NAME = System.getProperty("envName", "uat");

  static {
    try {
      PROPERTIES.load(Config.class.getClassLoader()
          .getResourceAsStream(String.format("environments/%s.yaml", ENVIRONMENT_NAME)));
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }
}
