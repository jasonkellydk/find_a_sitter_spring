package io.deveo.findasitter.app.user.services;

import io.deveo.findasitter.app.user.entities.Role;
import io.deveo.findasitter.app.user.entities.User;
import io.deveo.findasitter.app.user.models.JwtToken;
import io.deveo.findasitter.app.user.repositories.UserRepository;
import io.deveo.findasitter.framework.providers.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  public AuthService() {}

  public JwtToken authenticate(String username, String password) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

    User user = userRepository.findByEmail(username);

    if (user == null) {
      return null;
    }

    Role role = user.getRole();

    if (role == null) {
      return null;
    }

    return jwtTokenProvider.createToken(username, role.getType());
  }

  public User findUserByusername(String username) {
    User user = userRepository.findByEmail(username);

    if (user == null) {
      return null;
    }

    return user;
  }
}
