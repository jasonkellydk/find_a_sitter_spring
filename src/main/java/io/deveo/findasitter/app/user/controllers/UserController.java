package io.deveo.findasitter.app.user.controllers;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
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
    return userService.createUser(user.getEmail(), user.getPassword(), user.getName());
  }

  @GetMapping(value = "/users")
  public @ResponseBody
  List<User> findAll() {
    return userService.findAll();
  }

  @GetMapping(value = "/userstest")
  public List<User> findAllByRsql(@RequestParam(value = "search") String search) {
    Node rootNode = new RSQLParser().parse(search);
    System.out.println(rootNode);
    // Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
   // return repo.findAll(spec);
    return null;
  }
}
