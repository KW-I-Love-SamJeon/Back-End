package com.IULP.BackEnd.Service;

import com.IULP.BackEnd.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //의존성 주입
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer userId = Integer.valueOf(username); // 아이디(학번)
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException(String.format("user_id=%d", userId)));
    }
}
