package com.IULP.BackEnd.DTO;

import com.IULP.BackEnd.Common.Role;
import com.IULP.BackEnd.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
public class UserSessionDTO implements Serializable {

    private String username;
    private String password;
    private String nickname;
    private String email;
    private Role role;

    /* Entity -> Dto */
    public UserSessionDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
}
