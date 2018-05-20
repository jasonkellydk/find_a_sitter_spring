package io.deveo.findasitter.app.user.controllers;

import io.deveo.findasitter.app.user.dataBinders.UserDataBinders;
import io.deveo.findasitter.app.user.entities.User;
import io.deveo.findasitter.app.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/users")
  public @ResponseBody
  User createUser(@RequestBody UserDataBinders user) {
    return userService.createUser(user.getEmail(), user.getPassword(), user.getName(), user.getRole());
  }

  @GetMapping(value = "/users")
  public @ResponseBody
  List<User> findAll(@RequestParam(required = false) String type) {
    if (type == null) {
      return userService.findAll();
    }

    return userService.findAll(type);
  }
}
