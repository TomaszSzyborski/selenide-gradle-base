package com.tomasz.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Endpoints {
  INFORMATION("/information"),
  DESK("/desk"),
  CONTROL_ROOM("/{key}/control_room"),
  CONTROL_RODS("/{key}/control_rods/{index}");

  private final String endpoint;
}
