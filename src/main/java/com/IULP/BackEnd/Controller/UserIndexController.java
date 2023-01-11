package com.IULP.BackEnd.Controller;

import com.IULP.BackEnd.DTO.UserDto;
import com.IULP.BackEnd.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserIndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/join")
    public String join() { return "/user/user-join"; }

    @PostMapping("/auth/joinProc")
    public String joinProc(UserDto userDto) {
        if(userService.join(userDto)==false) return "redirect:/";

        return "redirect:/auth/login";
    }

    @GetMapping("/auth/login")
    public String login() { return "/user/user-login"; }
}
