package com.swapnil.security.controller;

import com.swapnil.security.domain.MyUser;
import com.swapnil.security.service.MyUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MyUserController {

    private final MyUserService myUserService;

    MyUserController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @PostMapping("/create")
    public MyUser createUser(@RequestBody MyUser user) {
        user = myUserService.createUser(user);
        return user;
    }

    @GetMapping("/getAll")
    public List<MyUser> getAllUsers() {
        return myUserService.getAllUsers();
    }

    @GetMapping("/getByName/{name}")
    public MyUser getUserByName(@PathVariable String name) {
        return myUserService.getUserByName(name);
    }

    @GetMapping("/getById/{id}")
    public MyUser getUserById(@PathVariable Long id) {
        return myUserService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return myUserService.deleteUser(id);
    }
}
