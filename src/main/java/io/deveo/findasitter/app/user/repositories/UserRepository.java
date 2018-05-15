package io.deveo.findasitter.app.user.repositories;

import io.deveo.findasitter.app.user.entities.User;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  public List<User> findAll();

  public User findByEmail(String email);

  public User findById(int id);

}
