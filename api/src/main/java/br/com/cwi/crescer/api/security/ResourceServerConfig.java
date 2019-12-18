package br.com.cwi.crescer.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableOAuth2Client
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String ADMIN = "ADMIN";
    public static final String ENTREVISTADOR = "ENTREVISTADOR";
    public static final String QUESTAO_DISSERTATIVA = "/questao-dissertativa/**";
    public static final String QUESTAO_MULTIPLA_ESCOLHA = "/questao-multipla-escolha/**";
    public static final String QUESTAO_TECNICA = "/questao-tecnica/**";
    public static final String DASHBOARD = "/dashboard/**";
    public static final String PROVA = "/prova/**";

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                .and()
                .cors().and().csrf().disable()
                .exceptionHandling()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                .antMatchers(
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "http://localhost:8100/cwi-turing/swagger-ui.html#/").permitAll()

                .antMatchers("/login")
                .permitAll()

                .antMatchers(
                        DASHBOARD,
                        "/email/**",
                        PROVA,
                        "/excluir/**",
                        "/incluir/**",
                        "/prova-questao-dissertativa/**",
                        "/prova-questao-multipla-escolha/**",
                        "/prova-questao-tecnica/**")
                .hasAnyRole(ADMIN, ENTREVISTADOR)

                .antMatchers(HttpMethod.POST,
                        DASHBOARD,
                        "/email/**",
                        PROVA,
                        "/excluir/**",
                        "/incluir/**",
                        "/prova-questao-dissertativa/**",
                        "/prova-questao-multipla-escolha/**",
                        "/prova-questao-tecnica/**")
                .hasAnyRole(ADMIN, ENTREVISTADOR)

                .antMatchers(HttpMethod.POST,
                        QUESTAO_DISSERTATIVA,
                        QUESTAO_MULTIPLA_ESCOLHA,
                        QUESTAO_TECNICA)
                .hasRole(ADMIN)

                .antMatchers(HttpMethod.GET,
                        QUESTAO_DISSERTATIVA,
                        DASHBOARD,
                        QUESTAO_MULTIPLA_ESCOLHA,
                        QUESTAO_TECNICA)
                .hasAnyRole(ADMIN, ENTREVISTADOR)

                .antMatchers(HttpMethod.PUT,
                        QUESTAO_DISSERTATIVA,
                        QUESTAO_MULTIPLA_ESCOLHA,
                        QUESTAO_TECNICA)
                .hasAnyRole(ADMIN, ENTREVISTADOR)

                .antMatchers("/usuario/**")
                .hasAnyRole(ADMIN, ENTREVISTADOR)

                .antMatchers(HttpMethod.PUT, PROVA)
                .permitAll()

                .antMatchers(HttpMethod.POST, PROVA)
                .permitAll()

                .antMatchers(HttpMethod.GET, "/buscar-prova/**", "/dominio/**")
                .permitAll()

                .anyRequest()
                .authenticated();
    }
}