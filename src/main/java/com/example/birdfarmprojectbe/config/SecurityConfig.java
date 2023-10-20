package com.example.birdfarmprojectbe.config;


import com.example.birdfarmprojectbe.Jwt.JwtAuthenticationFilter;
import com.example.birdfarmprojectbe.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter authenticationFilter;

    private final UserDetailsServiceImpl userDetailsService;

    // Danh sách các URL không yêu cầu xác thực
    private static final String[] UNSECURED_URLs = {
            "/authenticate/**",
            "/register",
            "/register/**",
            "/home",
            "/forgot-password",
            "/api/manager/*",
            "/api/location/*",
    };
    // Danh sách các URL cho customer
    private static final String[] STAFF_URL = {

    };
    // Danh sách các URL cho expert
    private static final String[] MANAGER_URL = {
    };

    // Danh sách các URL cho admin
    private static final String[] ADMIN_URL = {
            "/admin/**"

    };
    //Danh sách url cho cả 3 role staff, admin, manager
    private static final String[] THREEROLE_URL = {
            "/change-password",
            "/profile",
            "/update/profile"
    };
    // Cấu hình bộ lọc bảo mật
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors().and().csrf()
                .disable()
                // Cho phép truy cập các URL không yêu cầu xác thực
//                .authorizeHttpRequests().requestMatchers(UNSECURED_URLs).permitAll().and()
//                // Cấu hình quyền truy cập dựa trên vai trò (authorities)
//                .authorizeHttpRequests().requestMatchers(ADMIN_URL).hasAuthority("ADMIN").and()
//                .authorizeHttpRequests().requestMatchers(MANAGER_URL).hasAuthority("MANAGER").and()
//                .authorizeHttpRequests().requestMatchers(STAFF_URL).hasAuthority("STAFF").and()
//                .authorizeHttpRequests().requestMatchers(THREEROLE_URL).hasAnyAuthority("MANAGER", "STAFF","ADMIN")
//                .anyRequest().authenticated().and()
//                // Quản lý phiên làm việc (session)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                // Cấu hình AuthenticationProvider
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // Cấu hình quản lý xác thực
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // Cấu hình mã hóa mật khẩu
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Cấu hình AuthenticationProvider
    public AuthenticationProvider authenticationProvider(){
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
