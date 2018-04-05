package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.FireBrigadeDTO;
import com.firebrigadeserver.dto.mapper.FireBrigadeMapper;
import com.firebrigadeserver.dto.mapper.UserMapper;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.User;
import com.firebrigadeserver.service.IFireBrigadeService;
import com.firebrigadeserver.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FireBrigadeController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IFireBrigadeService fireBrigadeService;

    @Autowired
    private IUserService userService;

    @Autowired
    private FireBrigadeMapper fireBrigadeMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("firebrigade/{id}")
    public ResponseEntity getFireBrigadeById(@PathVariable("id") Integer id) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(id);
        FireBrigadeDTO fireBrigadeDTO = fireBrigadeMapper.entityToDto(fireBrigade);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fireBrigadeDTO);
    }

    @GetMapping("firebrigades")
    public ResponseEntity getAllFireBrigades() {
        List<FireBrigade> list = fireBrigadeService.getAllFireBrigades();
        List<FireBrigadeDTO> dtosList = fireBrigadeMapper.entityListToDtoList(list);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtosList);
    }

    @GetMapping("firebrigade/user/{username}")
    public ResponseEntity getFireBrigadeByUser(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeByUser(user);
        FireBrigadeDTO fireBrigadeDTO = fireBrigadeMapper.entityToDto(fireBrigade);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fireBrigadeDTO);
    }


    @RequestMapping(value = "firebrigade/user/{username}", method = RequestMethod.POST)
    public ResponseEntity addFireBrigade(@RequestBody FireBrigadeDTO fireBrigadeDTO, @PathVariable String username) {
        FireBrigadeDTO returnFirebrigadeDTO = null;
        try {
            System.out.println("USERNAME: " + username);
            User user = userService.getUserByUsername(username);
            System.out.println("USER: ");
            user.printUser();
            FireBrigade fireBrigade = fireBrigadeMapper.dtoToEntity(fireBrigadeDTO);
            fireBrigade.setUser(user);
            System.out.println(fireBrigade.toString());
            if (fireBrigadeService.addFireBrigade(fireBrigade)) {
                fireBrigade = fireBrigadeService.getFireBrigadeByUser(user);
                logger.debug(fireBrigade.toString());
                returnFirebrigadeDTO = fireBrigadeMapper.entityToDto(fireBrigade);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(returnFirebrigadeDTO);
            } else {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(returnFirebrigadeDTO);
            }

        } catch (Exception e) {
            logger.error("Blad przy dodawaniu jednostki strazy pozarnej: " + e.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(null);
    }

    @PutMapping("firebrigade")
    public ResponseEntity updateFireBrigade(@RequestBody FireBrigadeDTO fireBrigadeDto) {
        FireBrigade fireBrigade = fireBrigadeMapper.dtoToEntity(fireBrigadeDto);
        fireBrigadeService.updateFireBrigade(fireBrigade);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Update success");
    }

    @RequestMapping(value = "firebrigade/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteFireBrigade(@PathVariable("id") Integer id) {
        fireBrigadeService.deleteFireBrigade(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(null);
    }

}
