package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.UserDTO;
import com.firebrigadeserver.dto.mapper.UserMapper;
import com.firebrigadeserver.entity.User;
import com.firebrigadeserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<UserDTO>(userMapper.entityToDto(user), HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        List<UserDTO> dtoList = userMapper.entityListToDtoList(list);
        return new ResponseEntity<List<UserDTO>>(dtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody UserDTO userDto) {
        try {
            User user = userMapper.dtoToEntity(userDto);
            userService.addUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
