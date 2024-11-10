// package com.i2s.data_kendaraan_api.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.filter.CorsFilter;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.FilterConfig;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;

// @Configuration
// public class CorsConfig {

//     @Bean
//     public CorsFilter corsFilter() {
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         CorsConfiguration config = new CorsConfiguration();
//         config.setAllowCredentials(true);
//         config.addAllowedOrigin("*");
//         config.addAllowedHeader("*");
//         config.addAllowedMethod("*");
//         source.registerCorsConfiguration("/**", config);
//         return new CorsFilter(source);
//     }

//     @Bean
//     public OncePerRequestFilter loggingFilter() {
//         return new OncePerRequestFilter() {
//             @Override
//             protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//                     throws ServletException, IOException {
//                 System.out.println("CORS Filter: " + request.getMethod() + " " + request.getRequestURI());
//                 filterChain.doFilter(request, response);
//             }

//             @Override
//             public void destroy() {
//                 // Cleanup logic if needed
//             }
//         };
//     }
// }

