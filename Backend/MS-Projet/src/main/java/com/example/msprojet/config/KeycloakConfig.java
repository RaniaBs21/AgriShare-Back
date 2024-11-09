/*
package com.example.msprojet.config;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {
    private static volatile Keycloak keycloak;
    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean

    public static Keycloak getInstance() {
        if (keycloak == null) {
            synchronized (Keycloak.class) {
                if (keycloak == null) {
                    keycloak = KeycloakBuilder.builder()
                            .serverUrl("http://keycloak:8082")
                            .realm("Agrishare_keycloak")
                            .grantType(OAuth2Constants.PASSWORD)
                            .clientId("MS-Project")
                            .clientSecret("14llv0dXVvUpoPt6l1G4ilMYRYHbwgLA")
                            .username("admin")
                            .password("admin")
                            .resteasyClient(new ResteasyClientBuilderImpl().connectionPoolSize(10).build())
                            .build();
                }
            }
        }
        return keycloak;
    }


}


*/
