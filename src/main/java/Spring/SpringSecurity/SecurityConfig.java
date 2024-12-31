package Spring.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// 사용자 정의 보안 설정
@EnableWebSecurity // 스프링 시큐리티를 활성화, SpringSecurityFilterChain 을 생성하고 애플리케이션에 적용하여 요청을 보호.
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        auth -> auth.anyRequest().authenticated()) // 모든 요청에 대해 인증이 필요
                .formLogin(Customizer.withDefaults()); // 폼 기반 로그인 기능 활성화

        return http.build();
    }

    @Bean // 설정 파일에서 신규 유저 생성, 우선순위는 자바 설정 파일 > yml 파일
    public UserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password("{noop}1111")
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withUsername("user2")
                .password("{noop}1111")
                .roles("USER")
                .build();

        UserDetails user3 = User
                .withUsername("user3")
                .password("{noop}1111")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user, user2, user3);
    }
}