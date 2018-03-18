package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.UserDTO;
import com.firebrigadeserver.dto.mapper.UserMapper;
import com.firebrigadeserver.entity.User;
import com.firebrigadeserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody UserDTO userDto) {
        try {
            User user = userMapper.dtoToEntity(userDto);
            userService.addUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
