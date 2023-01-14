package com.IULP.BackEnd.Service;

import com.IULP.BackEnd.Model.User;
import com.IULP.BackEnd.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        User user = userDao.findUser(id);

        if( user == null ) {
            throw new UsernameNotFoundException(id);
        }
        return user;
    }
    public User findUser(String id){
        return userDao.findUser(id);
    }

    public User updateUser(User user){
        userDao.updateUser(user);
        return user;
    }

    public Boolean deleteUser(String id){
        userDao.deleteUser(id);
        return true;
    }
}
