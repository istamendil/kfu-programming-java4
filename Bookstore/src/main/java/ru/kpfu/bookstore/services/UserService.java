package ru.kpfu.bookstore.services;

import java.util.Set;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.bookstore.models.User;
import ru.kpfu.bookstore.models.UserAuthority;
import ru.kpfu.bookstore.repositories.UserAuthorityRepository;
import ru.kpfu.bookstore.repositories.UserRepository;

/**
 *
 * @author Alexander Ferenets <istamendil.info>
 */
@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private UserAuthorityRepository userAuthorityRepo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    return userRepo.findByUsername(username);
  }

  public void registerUser(User user) {
    if(userRepo.findByUsername(user.getUsername()) != null){
      throw new DuplicateKeyException("Duplicate key - username field.");
    }
    user.addAuthority(userAuthorityRepo.findByAuthority("ROLE_USER"));
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setPasswordRepeat(user.getPassword());
    userRepo.save(user);
  }
  
  public User updateFullNameAndAuthorities(Integer id, String fullName, Set<UserAuthority> authorities){
    User user = userRepo.findOne(id);
    if(user == null){
      throw new EntityNotFoundException("User with id " + id + "has not been found.");
    }
    user.setPasswordRepeat(user.getPassword());
    user.setFullName(fullName);
    user.setAuthorities(authorities);
    return user;
  }

}
