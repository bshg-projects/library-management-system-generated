package org.bshg.librarysystem.mySecurity.service.facade;

import org.bshg.librarysystem.mySecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    String cryptPassword(String value);

    boolean changePassword(String username, String newPassword);

    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);

    void deleteById(Long id);

    User save(User user);

    User update(User user);

    int delete(User user);

    User findByUsernameWithRoles(String username);

    int deleteByUsername(String username);

    UserDetails loadUserByUsername(String username);
}
