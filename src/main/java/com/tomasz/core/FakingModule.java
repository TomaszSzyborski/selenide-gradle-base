package com.tomasz.core;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

public final class FakingModule implements Module {

  @Override
  public void configure(Binder binder) {
    binder.bind(Faking.class).to(Fake.class).in(Singleton.class);
  }
}
