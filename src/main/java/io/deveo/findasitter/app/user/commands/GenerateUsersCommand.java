package io.deveo.findasitter.app.user.commands;

import com.github.javafaker.Faker;
import io.deveo.findasitter.app.rating.entities.Rating;
import io.deveo.findasitter.app.rating.repositories.RatingRepository;
import io.deveo.findasitter.app.user.entities.Role;
import io.deveo.findasitter.app.user.entities.User;
import io.deveo.findasitter.app.user.repositories.RoleRepository;
import io.deveo.findasitter.app.user.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class GenerateUsersCommand {

  private UserRepository userRepository;

  private RoleRepository roleRepository;

  @Autowired
  public GenerateUsersCommand(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  @ShellMethod("Generate random users")
  public String generate_users() {
    List<User> users = new ArrayList();
    Role sitter = roleRepository.findByType("sitter");
    Role baby = roleRepository.findByType("baby");

    for (int i = 0; i < 50; i++) {
      Faker faker = new Faker(new Locale("da-DK"));
      User user = new User();
      user.setName(faker.name().name());
      user.setEmail(faker.internet().safeEmailAddress());
      user.setPassword(faker.internet().password());
      user.setLocation(faker.address().city());

      if (i % 2 == 0) {
        user.setRole(sitter);
      } else {
        user.setRole(baby);
      }

      users.add(user);
    }

    userRepository.saveAll(users);


    return "Your users have been generated <3";
  }
}

