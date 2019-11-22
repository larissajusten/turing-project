package br.com.cwi.crescer.api.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "oauth2")
public class OAuth2Configuration {

    private String clientId;

    private String clientSecret;

    private String grantType;

    private String scopes;

    private String endpoint;

}

