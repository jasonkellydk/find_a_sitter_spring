package io.deveo.findasitter.app.user.repositories;

import io.deveo.findasitter.app.user.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
  public Role findById(int id);

  public Role findByType(String name);
}
