package com.firebrigadeserver.controller;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.User;
import com.firebrigadeserver.service.IFireBrigadeService;
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

    @GetMapping("firebrigade/{id}")
    public ResponseEntity<FireBrigade> getFireBrigadeById(@PathVariable("id") Integer id) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(id);
        return new ResponseEntity<FireBrigade>(fireBrigade, HttpStatus.OK);
    }

    @GetMapping("firebrigades")
    public ResponseEntity<List<FireBrigade>> getAllFireBrigades() {
        List<FireBrigade> list = fireBrigadeService.getAllFireBrigades();
        return new ResponseEntity<List<FireBrigade>>(list, HttpStatus.OK);
    }

    @GetMapping("firebrigade/user/{id}/{username}/{password}")
    public ResponseEntity<FireBrigade> getFireBrigadeByUser(@PathVariable("id") Integer id, @PathVariable("username") String username, @PathVariable("password") String password) {
        User user = new User();
        user.setUserId(id);
        user.setUsername(username);
        user.setPassword(password);
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeByUser(user);
        return new ResponseEntity<FireBrigade>(fireBrigade, HttpStatus.OK);
    }


    @RequestMapping(value = "firebrigade", method = RequestMethod.POST)
    public ResponseEntity<Void> addFireBrigade(@RequestBody FireBrigade fireBrigade) {
        try {
            fireBrigadeService.addFireBrigade(fireBrigade);
        } catch (Exception e) {
            logger.error("Blad przy dodawaniu jednostki strazy pozarnej", e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("firebrigade")
    public ResponseEntity<FireBrigade> updateFireBrigade(@RequestBody FireBrigade fireBrigade) {
        fireBrigadeService.updateFireBrigade(fireBrigade);
        return new ResponseEntity<FireBrigade>(fireBrigade, HttpStatus.OK);
    }

    @RequestMapping(value = "firebrigade/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFireBrigade(@PathVariable("id") Integer id) {
        fireBrigadeService.deleteFireBrigade(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
