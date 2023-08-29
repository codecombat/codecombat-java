package com.codecombat.api;

import com.codecombat.api.core.ClientOptions;
import com.codecombat.api.core.Environment;
import java.util.Base64;

public final class CodecombatApiClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;

    public CodecombatApiClientBuilder credentials(String username, String password) {
        String unencodedToken = username + ":" + password;
        String encodedToken = Base64.getEncoder().encodeToString(unencodedToken.getBytes());
        this.clientOptionsBuilder.addHeader("Authorization", "Basic " + encodedToken);
        return this;
    }

    public CodecombatApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public CodecombatApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public CodecombatApiClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new CodecombatApiClient(clientOptionsBuilder.build());
    }
}
