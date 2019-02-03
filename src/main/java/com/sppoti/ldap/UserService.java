package com.sppoti.ldap;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // User Authentication
    public Boolean authenticate(final String u, final String p) {
        return this.userRepository.findByUsernameAndPassword(u, p) != null;
    }

    // User Creation
    public void create(final String username, final String password) {
        final User newUser = new User(username, DigestUtils.sha256Hex(password));
        newUser.setId(LdapUtils.emptyLdapName());
        this.userRepository.save(newUser);
    }

    // User modification
    public void modify(final String u, final String p) {
        final User user = this.userRepository.findByUsername(u);
        user.setPassword(p);
        this.userRepository.save(user);
    }

    // USer search
    public List<String> search(final String u) {
        final List<User> userList = this.userRepository
                .findByUsernameLikeIgnoreCase(u);

        if (CollectionUtils.isEmpty(userList)) {
            return Collections.emptyList();
        }

        return userList.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
