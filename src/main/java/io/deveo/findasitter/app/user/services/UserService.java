package io.deveo.findasitter.app.user.services;

import io.deveo.findasitter.app.user.entities.Role;
import io.deveo.findasitter.app.user.entities.User;
import io.deveo.findasitter.app.user.repositories.RoleRepository;
import io.deveo.findasitter.app.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  public User createUser(String email, String password, String name){
    Role role = roleRepository.findById(1);

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    User user = new User();

    user.setEmail(email);
    user.setPassword(passwordEncoder.encode(password));
    user.setName(name);
    user.setRole(role);

    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public UserService(){}

}
