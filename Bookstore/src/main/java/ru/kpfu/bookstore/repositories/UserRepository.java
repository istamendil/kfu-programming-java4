package ru.kpfu.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.bookstore.models.User;

/**
 *
 * @author Alexander Ferenets <istamendil.info>
 */
public interface UserRepository extends CrudRepository<User, Integer>{
  User findByUsername(String username);
}
