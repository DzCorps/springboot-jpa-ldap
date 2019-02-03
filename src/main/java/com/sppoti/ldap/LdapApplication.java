package com.sppoti.ldap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableLdapRepositories
public class LdapApplication {

    private static final Logger log = LoggerFactory.getLogger(LdapApplication.class);

    private final UserService userService;

    @Autowired
    public LdapApplication(final UserService userService) {
        this.userService = userService;
    }

    public static void main(final String[] args) {
        SpringApplication.run(LdapApplication.class, args);
    }


    @PostConstruct
    public void setup() {
        log.info("Spring LDAP + Spring Boot Configuration Example");

        final List<User> names = this.userService.findAll();
        log.info("names: {}", names);
    }
}

