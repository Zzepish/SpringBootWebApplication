package com.example.SecurityLearning.Service;

import com.example.SecurityLearning.Entity.User;
import com.example.SecurityLearning.Principal.UserPrincipal;
import com.example.SecurityLearning.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = this.userRepository.findByUsername(username);

        if (null == user) {
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user.getUsername(), user.getPassword());
    }
}
