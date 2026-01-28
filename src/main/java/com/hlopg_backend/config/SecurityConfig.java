// // // // // package com.hlopg_backend.config;

// // // // // import java.util.Arrays;
// // // // // import java.util.List;

// // // // // import org.springframework.context.annotation.Bean;
// // // // // import org.springframework.context.annotation.Configuration;
// // // // // import org.springframework.security.authentication.AuthenticationManager;
// // // // // import org.springframework.security.authentication.AuthenticationProvider;
// // // // // import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// // // // // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// // // // // import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// // // // // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // // // // import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // // // // import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// // // // // import org.springframework.security.config.http.SessionCreationPolicy;
// // // // // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // // // // import org.springframework.security.crypto.password.PasswordEncoder;
// // // // // import org.springframework.security.web.SecurityFilterChain;
// // // // // import org.springframework.web.cors.CorsConfiguration;
// // // // // import org.springframework.web.cors.CorsConfigurationSource;
// // // // // import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// // // // // import com.hlopg_backend.service.CustomUserDetailsService;

// // // // // import lombok.RequiredArgsConstructor;

// // // // // @Configuration
// // // // // @EnableWebSecurity
// // // // // @EnableMethodSecurity
// // // // // @RequiredArgsConstructor
// // // // // public class SecurityConfig {
    
// // // // //     private final CustomUserDetailsService userDetailsService;
    
// // // // //     @Bean
// // // // //     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// // // // //         return http
// // // // //                 .csrf(AbstractHttpConfigurer::disable)
// // // // //                 .cors(cors -> cors.configurationSource(corsConfigurationSource()))
// // // // //                 .authorizeHttpRequests(auth -> auth
// // // // //                         .requestMatchers("/api/auth/**").permitAll()
// // // // //                         .requestMatchers("/api/hostels/**").permitAll()
// // // // //                         .requestMatchers("/api/hostel/**").permitAll()  // Add this line
// // // // //                         .requestMatchers("/api/h2-console/**").permitAll()
// // // // //                         .anyRequest().authenticated()
// // // // //                 )
// // // // //                 .sessionManagement(session -> session
// // // // //                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
// // // // //                 )
// // // // //                 .authenticationProvider(authenticationProvider())
// // // // //                 .build();
// // // // //     }
    
// // // // //     @Bean
// // // // //     public CorsConfigurationSource corsConfigurationSource() {
// // // // //         CorsConfiguration configuration = new CorsConfiguration();
// // // // //         configuration.setAllowedOrigins(Arrays.asList(
// // // // //                 "http://localhost:5173",  // Vite default port
// // // // //                 "http://localhost:3000",  // Create React App
// // // // //                 "http://localhost:8081",  // Other ports
// // // // //                 "exp://localhost:8081"
// // // // //         ));
// // // // //         configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
// // // // //         configuration.setAllowedHeaders(List.of("*"));
// // // // //         configuration.setAllowCredentials(true);
// // // // //         configuration.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));
// // // // //         configuration.setMaxAge(3600L); // 1 hour
        
// // // // //         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
// // // // //         source.registerCorsConfiguration("/**", configuration);
// // // // //         return source;
// // // // //     }
    
// // // // //     @Bean
// // // // //     public AuthenticationProvider authenticationProvider() {
// // // // //         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
// // // // //         authProvider.setUserDetailsService(userDetailsService);
// // // // //         authProvider.setPasswordEncoder(passwordEncoder());
// // // // //         return authProvider;
// // // // //     }
    
// // // // //     @Bean
// // // // //     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) 
// // // // //             throws Exception {
// // // // //         return config.getAuthenticationManager();
// // // // //     }
    
// // // // //     @Bean
// // // // //     public PasswordEncoder passwordEncoder() {
// // // // //         return new BCryptPasswordEncoder();
// // // // //     }
// // // // // }

// // // // package com.hlopg_backend.config;

// // // // import org.springframework.context.annotation.Bean;
// // // // import org.springframework.context.annotation.Configuration;
// // // // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // // // import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // // // import org.springframework.security.web.SecurityFilterChain;

// // // // @Configuration
// // // // @EnableWebSecurity
// // // // public class SecurityConfig {
    
// // // //     @Bean
// // // //     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// // // //         http
// // // //             .csrf(csrf -> csrf.disable()) // Disable CSRF
// // // //             .authorizeHttpRequests(auth -> auth
// // // //                 .anyRequest().permitAll() // Allow ALL requests without authentication
// // // //             );
        
// // // //         return http.build();
// // // //     }
// // // // }
// // // package com.hlopg_backend.config;

// // // import org.springframework.context.annotation.Bean;
// // // import org.springframework.context.annotation.Configuration;
// // // import org.springframework.security.authentication.AuthenticationManager;
// // // import org.springframework.security.authentication.AuthenticationProvider;
// // // import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// // // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// // // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // // import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // // import org.springframework.security.core.userdetails.UserDetailsService;
// // // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // // import org.springframework.security.crypto.password.PasswordEncoder;
// // // import org.springframework.security.web.SecurityFilterChain;
// // // import org.springframework.web.servlet.config.annotation.CorsRegistry;
// // // import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// // // @Configuration
// // // @EnableWebSecurity
// // // public class SecurityConfig implements WebMvcConfigurer {
    
// // //     private final UserDetailsService userDetailsService;
    
// // //     public SecurityConfig(UserDetailsService userDetailsService) {
// // //         this.userDetailsService = userDetailsService;
// // //     }
    
// // //     @Bean
// // //     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// // //         http
// // //             .csrf(csrf -> csrf.disable())
// // //             .authorizeHttpRequests(auth -> auth
// // //                 .anyRequest().permitAll() // Allow all requests
// // //             );
        
// // //         return http.build();
// // //     }
    
// // //     @Bean
// // //     public AuthenticationProvider authenticationProvider() {
// // //         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
// // //         authProvider.setUserDetailsService(userDetailsService);
// // //         authProvider.setPasswordEncoder(passwordEncoder());
// // //         return authProvider;
// // //     }
    
// // //     @Bean
// // //     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) 
// // //             throws Exception {
// // //         return config.getAuthenticationManager();
// // //     }
    
// // //     @Bean
// // //     public PasswordEncoder passwordEncoder() {
// // //         return new BCryptPasswordEncoder();
// // //     }
    
// // //     @Override
// // //     public void addCorsMappings(CorsRegistry registry) {
// // //         registry.addMapping("/**")
// // //                 .allowedOrigins("*")
// // //                 .allowedMethods("*")
// // //                 .allowedHeaders("*");
// // //     }
// // // }

// // package com.hlopg_backend.config;

// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.security.web.SecurityFilterChain;

// // @Configuration
// // @EnableWebSecurity
// // public class SecurityConfig {
    
// //     @Bean
// //     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// //         http
// //             .csrf(csrf -> csrf.disable())
// //             .authorizeHttpRequests(auth -> auth
// //                 .anyRequest().permitAll()
// //             );
        
// //         return http.build();
// //     }
    
// //     @Bean
// //     public PasswordEncoder passwordEncoder() {
// //         return new BCryptPasswordEncoder();
// //     }
    
// //     @Bean
// //     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) 
// //             throws Exception {
// //         return config.getAuthenticationManager();
// //     }
// // }
// package com.hlopg_backend.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
    
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth
//                 .anyRequest().permitAll()
//             );
        
//         return http.build();
//     }
    
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
    
//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) 
//             throws Exception {
//         return config.getAuthenticationManager();
//     }
    
//     // Add this UserDetailsService bean
//     @Bean
//     public UserDetailsService userDetailsService() {
//         // Create a simple in-memory user for testing
//         UserDetails user = User.builder()
//                 .username("test@example.com")
//                 .password(passwordEncoder().encode("password"))
//                 .roles("USER")
//                 .build();
        
//         return new InMemoryUserDetailsManager(user);
//     }
// }

package com.hlopg_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );
        
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}