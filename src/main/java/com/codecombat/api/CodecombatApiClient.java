package com.codecombat.api;

import com.codecombat.api.client.auth.authServiceClient;
import com.codecombat.api.client.clans.clansServiceClient;
import com.codecombat.api.client.classrooms.classroomsServiceClient;
import com.codecombat.api.client.stats.statsServiceClient;
import com.codecombat.api.client.users.usersServiceClient;
import com.codecombat.api.core.BasicAuth;
import com.codecombat.api.core.Environment;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class CodecombatApiClient {
  private final Supplier<authServiceClient> authServiceClient;

  private final Supplier<clansServiceClient> clansServiceClient;

  private final Supplier<classroomsServiceClient> classroomsServiceClient;

  private final Supplier<statsServiceClient> statsServiceClient;

  private final Supplier<usersServiceClient> usersServiceClient;

  public CodecombatApiClient(BasicAuth auth) {
    this(Environment.PRODUCTION, auth);
  }

  public CodecombatApiClient(Environment environment, BasicAuth auth) {
    this.authServiceClient = memoize(() -> new authServiceClient(environment.getUrl(), auth));
    this.clansServiceClient = memoize(() -> new clansServiceClient(environment.getUrl(), auth));
    this.statsServiceClient = memoize(() -> new statsServiceClient(environment.getUrl(), auth));
    this.classroomsServiceClient = memoize(() -> new classroomsServiceClient(environment.getUrl(), auth));
    this.usersServiceClient = memoize(() -> new usersServiceClient(environment.getUrl(), auth));
  }

  public final authServiceClient auth() {
    return this.authServiceClient.get();
  }

  public final clansServiceClient clans() {
    return this.clansServiceClient.get();
  }

  public final classroomsServiceClient classrooms() {
    return this.classroomsServiceClient.get();
  }

  public final statsServiceClient stats() {
    return this.statsServiceClient.get();
  }

  public final usersServiceClient users() {
    return this.usersServiceClient.get();
  }

  private static <T> Supplier<T> memoize(Supplier<T> delegate) {
    AtomicReference<T> value = new AtomicReference<>();
    return () ->  {
      T val = value.get();
      if (val == null) {
        val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
      }
      return val;
    } ;
  }
}
