package com.tomasz.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvironmentConfigurationData {
  // TODO create model of configuration data
  private String environmentName;
  private String frontEndUrl;
  private String apiUrl;
  private User user;
}
