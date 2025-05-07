package com.example.SecurityLearning.Config;

import com.example.SecurityLearning.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(this.userDetailsService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(10));

        return authProvider;
    }

    private Collection<UserDetails> users = new ArrayList<>(List.of(
            User
                    .withDefaultPasswordEncoder()
                    .username("Zzepish")
                    .password("1234")
                    .roles("USER")
                    .build(),
            User
                    .withDefaultPasswordEncoder()
                    .username("Remark")
                    .password("1234")
                    .roles("USER")
                    .build()
    ));
    /**
     * This way we are completely takin over Security control. All of other security will be removed
     *
     * LAMBDA WAY
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(customizer -> customizer.disable());
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults()); // Web page login form
        httpSecurity.httpBasic(Customizer.withDefaults()); // API auth (aka. Postman)
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // API auth (aka. Postman)

        return httpSecurity.build();
    }


    //User login/password mechanism
   /* @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(this.users);
    }*/

    /**
     * This way we are completely takin over Security control. All of other security will be removed
     *
     * IMPERIC WAY
     */
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        Customizer<CsrfConfigurer<HttpSecurity>> csrfCustomizer = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
                customizer.disable();
            }
        };

        httpSecurity.csrf(csrfCustomizer);


        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> authCustomizer
                = new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
            @Override
            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry customizer) {
                customizer.anyRequest().authenticated();
            }
        };
        httpSecurity.authorizeHttpRequests(authCustomizer);
        httpSecurity.formLogin(Customizer.withDefaults()); // Web page login form
        httpSecurity.httpBasic(Customizer.withDefaults()); // API auth (aka. Postman)
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // API auth (aka. Postman)

        return httpSecurity.build();
    }*/
}
