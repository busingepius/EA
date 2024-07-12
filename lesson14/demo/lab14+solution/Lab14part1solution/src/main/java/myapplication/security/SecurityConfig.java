package myapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( authConfig -> {authConfig
                .requestMatchers(HttpMethod.GET, "/shop").hasRole("employee")
                .requestMatchers(HttpMethod.GET, "/orders").hasAnyRole("sales", "finance")
                .requestMatchers(HttpMethod.GET, "/payments").hasAnyRole("finance");
        }).httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
