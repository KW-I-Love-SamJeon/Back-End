package com.IULP.BackEnd.Config;

import com.IULP.BackEnd.Filter.JwtDecodeFilter;
import com.IULP.BackEnd.Filter.JwtLoginFilter;
import com.IULP.BackEnd.Service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtDecodeFilter jwtDecodeFilter;
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(JwtDecodeFilter jwtDecodeFilter, UserDetailsServiceImpl userDetailsService){
        this.jwtDecodeFilter=jwtDecodeFilter;
        this.userDetailsService=userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService);
        AuthenticationManager authenticationManager= authenticationManagerBuilder.build();//인증 로직이 포함된 커스텀인증 매니저 추가

        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter(authenticationManager);
        jwtLoginFilter.setUsernameParameter("id");
        jwtLoginFilter.setPasswordParameter("password");
        return http
                .csrf().disable()
                .formLogin().disable()//form 방식 사용 안함, json으로 전달
                .httpBasic().disable()//Bearer 방식 사용 -> header에 authentication에 토큰을 넣어서 전달
                .authorizeRequests()
                .antMatchers("/login").permitAll()//login에 대해 권한을 모두 허용
                .anyRequest().authenticated()//일부 리소스에 대해 권한 설정을 한 후, 나머지 리소스들은 모두 무조건 인증을 완료 해야 함.
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//스프링 시큐리티가 생성하지도 않고 기존 것을 사용하지도 않음 -> JWT 사용
                .and()
                .authenticationManager(authenticationManager)
                .addFilterBefore(jwtDecodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
