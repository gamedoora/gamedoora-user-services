package com.gamedoora.backend.userservices.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {
    public Keycloak keycloak(){
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("")
                .grantType(OAuth2Constants.PASSWORD)
                .realm("")
                .clientId("")
                .username("")
                .password("")
                .resteasyClient(
                        new ResteasyClientBuilder()
                                .connectionPoolSize(10)
                                .disableTrustManager()
                                .build()
                ).build();
            return keycloak;
    }

    @Bean("usersResource")
    public UsersResource usersResource(){
        return keycloak().realm("").users();
    }

}
