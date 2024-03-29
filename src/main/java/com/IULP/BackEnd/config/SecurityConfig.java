package com.IULP.BackEnd.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests() // 해당 메소드 아래는 각 경로에 따른 권한을 지정할 수 있다.
                .mvcMatchers(HttpMethod.OPTIONS, "/login").permitAll() // Preflight Request 허용해주기
                //.antMatchers("/**").hasAnyAuthority(USER.name())
                .antMatchers( "/" , "/resources/**","/user/**" ).permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
                //.antMatchers("/admin/**").hasRole("1") // 괄호의 권한을 가진 유저만 접근가능, ROLE_가 붙어서 적용 됨. 즉, 테이블에 ROLE_권한명 으로 저장해야 함.
                .anyRequest().authenticated()  //authenticated() 로그인된 사용자가 요청을 수행할 떄 필요하다  만약 사용자가 인증되지 않았다면, 스프링 시큐리티 필터는 요청을 잡아내고 사용자를 로그인 페이지로 리다이렉션 해준다.
                .and()
                .formLogin() // 하위에 내가 직접 구현한 로그인 폼, 로그인 성공시 이동 경로 설정 가능. , 로그인 폼의 아이디,패스워드는 username, password로 맞춰야 함
                .loginPage("/") // 로그인이 수행될 경로.
                .loginProcessingUrl("/loginProcess")// 로그인 form의  action과 일치시켜주어야 함.
                .defaultSuccessUrl("/user/login") // 로그인 성공 시 이동할 경로.
                .failureUrl("/user/loginFail")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/user/logout");

        http.cors().and();

        http.csrf().disable();
    }

}
