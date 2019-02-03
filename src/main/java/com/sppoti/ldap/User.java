package com.sppoti.ldap;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;


@Entry(
        base = "ou=people,dc=sppoti,dc=com",
        objectClasses = {"person"})
public class User {

    @Id
    private Name id;

    @Attribute(name = "cn")
    private String username;
    @Attribute(name = "sn")
    private String password;

    public User() {
    }

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public Name getId() {
        return this.id;
    }

    public void setId(final Name id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + this.id +
                ", username='" + this.username + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }
}
