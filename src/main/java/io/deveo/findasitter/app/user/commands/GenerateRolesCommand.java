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
public class GenerateRolesCommand {

  private RoleRepository roleRepository;

  @Autowired
  public GenerateRolesCommand(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @ShellMethod("Generate Roles Baby and Sitter")
  public String generate_roles() {
    List<Role> roles = new ArrayList<>();
    Role sitter = new Role();
    sitter.setId(1);
    sitter.setType("sitter");
    roles.add(sitter);
    Role baby = new Role();
    baby.setId(2);
    baby.setType("baby");
    roles.add(baby);
    roleRepository.saveAll(roles);



    return "Your Roles have been generated <3";
  }
}


