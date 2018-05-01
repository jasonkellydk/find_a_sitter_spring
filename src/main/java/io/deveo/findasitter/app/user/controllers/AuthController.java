package io.deveo.findasitter.app.user.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import io.deveo.findasitter.app.user.models.JwtToken;
import io.deveo.findasitter.app.user.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @RequestMapping(method = POST, value = "/login")
  public @ResponseBody
  JwtToken authenticate(@RequestParam String username, @RequestParam String password) {
    return authService.authenticate(username, password);
  }
}
