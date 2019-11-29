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

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .exceptionHandling()
                .and()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

//                .antMatchers("/v2/api-docs",
//                        "/configuration/ui",
//                        "/swagger-resources/**",
//                        "/configuration/security",
//                        "/swagger-ui.html",
//                        "/webjars/**").permitAll()
//
                .antMatchers("/login")
                .permitAll()

                //TODO teste da camila
                .antMatchers("/prova-questao-dissertativa/**")
                .hasAnyRole("ADMIN")
//
//                .antMatchers("/prova/**", "/dashboard/**", "/email/**","/buscar-prova/**", "/dominio/**",
//                        "/excluir/**", "/incluir/**", "/prova-questao-dissertativa/**", "/prova-questao-multipla-escolha/**",
//                        "/prova-questao-tecnica/**")
//                .hasAnyRole("ADMIN", "ENTREVISTADOR")
//
//                .antMatchers(HttpMethod.POST, "/questao-dissertativa/**", "/questao-multipla-escolha/**",
//                        "/questao-tecnica/**")
//                .hasRole("ADMIN")
//
//                .antMatchers(HttpMethod.GET, "/questao-dissertativa/**", "/questao-multipla-escolha/**",
//                        "/questao-tecnica/**")
//                .hasAnyRole("ADMIN", "ENTREVISTADOR")
//
//                .antMatchers(HttpMethod.PUT, "/questao-dissertativa/**", "/questao-multipla-escolha/**",
//                        "/questao-tecnica/**")
//                .hasAnyRole("ADMIN", "ENTREVISTADOR")
//
//                .antMatchers("/usuario/**")
//                .hasAnyRole("ADMIN", "ENTREVISTADOR")
//
//                .antMatchers(HttpMethod.PUT, "prova/{id-prova}/iniciar-prova")
//                .hasAnyRole("USUARIO", "ADMIN", "ENTREVISTADOR")

                .anyRequest()
                .authenticated();
    }

}