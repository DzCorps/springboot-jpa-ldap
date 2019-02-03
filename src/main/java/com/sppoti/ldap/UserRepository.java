package com.sppoti.ldap;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends LdapRepository<User> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    List<User> findByUsernameLikeIgnoreCase(String username);

    @Override
    List<User> findAll();
}
