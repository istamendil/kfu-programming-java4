package ru.kpfu.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.bookstore.models.UserAuthority;

/**
 *
 * @author Alexander Ferenets <istamendil.info>
 */
public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {

  public UserAuthority findByAuthority(String role_user);
}
