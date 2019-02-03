package com.sppoti.ldap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    private static final String USER3 = "wail djenane";
    private static final String USER3_PWD = "wail";

    @Autowired
    private UserService userService;

    @Test
    public void givenLdapClient_whenCorrectCredentials_thenSuccessfulLogin() {
        final Boolean isValid = this.userService.authenticate(USER3, USER3_PWD);

        assertEquals(true, isValid);
    }
}