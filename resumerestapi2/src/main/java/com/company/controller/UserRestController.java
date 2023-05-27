package com.company.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserDaoInter userDao;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUser(
            @RequestParam(name ="name",required = false) String name,
            @RequestParam(name ="surname",required = false) String surname,
            @RequestParam(name="email",required=false) String email

    ) {
        List<User> users = userDao.getAll(name, surname, email);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }

        return ResponseEntity.ok(ResponseDTO.of(userDTOS));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUsersId(@PathVariable("id") Integer id) {
        User users = userDao.getById(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(users)));

    }
}
