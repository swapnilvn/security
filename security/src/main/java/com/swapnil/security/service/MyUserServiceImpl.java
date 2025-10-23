package com.swapnil.security.service;

import com.swapnil.security.domain.MyUser;
import com.swapnil.security.repository.MyUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService{

    private final PasswordEncoder passwordEncoder;
    private final MyUserRepository myUserRepository;

    public MyUserServiceImpl(PasswordEncoder passwordEncoder, MyUserRepository myUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.myUserRepository = myUserRepository;
    }

    @Override
    public MyUser createUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myUserRepository.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        myUserRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public MyUser getUserById(Long id) {
        return myUserRepository.getReferenceById(id);
    }

    @Override
    public MyUser getUserByName(String name) {
        return myUserRepository.getUserByUsername(name);
    }

    @Override
    public List<MyUser> getAllUsers() {
        return myUserRepository.findAll();
    }
}
