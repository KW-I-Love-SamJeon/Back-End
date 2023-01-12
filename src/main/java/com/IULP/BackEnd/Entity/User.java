package com.IULP.BackEnd.Entity;


import com.IULP.BackEnd.Common.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "users")
public class User implements UserDetails {
    @Id
    private Integer id; // 아이디(학번)
    private String passwordHashed; // 암호화된 비밀번호

    // Constructor

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(); // 사용자별 권한 설정은 사용하지 않을 예정
    }

    @Override
    public String getPassword() {
        return passwordHashed;
    }

    @Override
    public String getUsername() {
        return String.valueOf(id);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 유효한 계정
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 사용불가(잠금)하지 않은 계정
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호가 만료되지 않음
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    // Getter, Setter
}
