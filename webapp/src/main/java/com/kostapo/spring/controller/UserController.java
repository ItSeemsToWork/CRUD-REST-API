package com.kostapo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kostapo.spring.model.User;
import com.kostapo.spring.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
 
   @Autowired
   private UserService userService;
 
   /*---Add new user---*/
   @PostMapping("/user")
   public ResponseEntity<?> save(@RequestBody User user) {
	  System.out.println("the json value of user is :::::: "+user);
      int id = userService.add(user);
      return ResponseEntity.ok().body("New User has been saved with ID:" + id);
   }
   
   /*---Get user by id---*/
   @GetMapping("/user/{id}")
   public ResponseEntity<User> get(@PathVariable("id") int id) {
      User user = userService.get(id);
      return ResponseEntity.ok().body(user);
   }
 
   /*---get all users---*/
   @GetMapping("/user")
   public ResponseEntity<List<User>> list() {
      List<User> users = userService.list();
      return ResponseEntity.ok().body(users);
   }
 
   /*---Update user by id---*/
   @PutMapping("/user/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody User user) {
      userService.update(id, user);
      return ResponseEntity.ok().body("User has been updated successfully.");
   }
 
   /*---Delete user by id---*/
   @DeleteMapping("/user/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id) {
      userService.delete(id);
      return ResponseEntity.ok().body("User has been deleted successfully.");
   }
}
