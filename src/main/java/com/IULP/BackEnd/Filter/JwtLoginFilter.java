package com.IULP.BackEnd.Filter;

import com.IULP.BackEnd.Entity.User;
import com.aspose.threed.utils.Algorithms;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    //생성자
    public JwtLoginFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        User user = (User) authResult.getPrincipal();//로그인한 사용자의 Userdetails 객체 반환
        String username = user.getUsername();

        //jwt 생성
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String accessToken = JWT.create()
                .withIssuer("issuer")
                .withSubject(username)
                .sign(algorithm);
        response.getWriter().write(accessToken);
    }
}
