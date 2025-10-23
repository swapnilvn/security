package com.swapnil.security.config;

import com.swapnil.security.domain.MyUser;
import com.swapnil.security.repository.MyUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final MyUserRepository myUserRepository;

    public MyUserDetailsService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser userByUsername = myUserRepository.getUserByUsername(username);
        Set<GrantedAuthority> authorities = userByUsername.getRoles().stream().map(String::trim)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return User.builder().username(username)
                .password(userByUsername.getPassword())
                .authorities(authorities)
                .build();
    }
}
