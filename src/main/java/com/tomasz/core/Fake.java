package com.tomasz.core;

import com.google.inject.Singleton;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

@Singleton
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class Fake implements Faking {
    private final Faker faker = new Faker();

    public Faker with() {
        return faker;
    }
}
