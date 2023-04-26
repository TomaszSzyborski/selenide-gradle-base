package com.tomasz.core;

import com.github.javafaker.Faker;
import com.google.inject.Singleton;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Singleton
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class Fake implements Faking {
  private final Faker faker = new Faker();

  public Faker with() {
    return faker;
  }
}
