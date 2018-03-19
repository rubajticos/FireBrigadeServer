package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.UserDTO;
import com.firebrigadeserver.dto.mapper.UserMapper;
import com.firebrigadeserver.entity.User;
import com.firebrigadeserver.repositories.UserRepository;
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
    private UserRepository userRepository;


    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody UserDTO userDto) {
        UserDTO returnUserDTO = null;
        try {
            User user = userMapper.dtoToEntity(userDto);
            if (userService.addUser(user)) {
                user = userRepository.findByUsername(user.getUsername());
                returnUserDTO = userMapper.entityToDto(user);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(returnUserDTO);
            } else {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(returnUserDTO);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(returnUserDTO);
    }

}
