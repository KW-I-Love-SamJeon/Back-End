package com.IULP.BackEnd.Controller;

import com.IULP.BackEnd.Entity.User;
import com.IULP.BackEnd.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    GetUser signUp(@RequestBody SignUp body) {
        System.out.println(132);
        User newUser = userRepository.save(new User(body.id(), body.name(), passwordEncoder.encode(body.password())));
        return new GetUser(newUser.getId(), newUser.getUsername() );
    }

    public record GetUser(Integer id, String name) {
    }

    public record SignUp(Integer id, String name, String password) {
    }
}
