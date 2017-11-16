package ir.team.insurance.complementary.model.to.security;

import ir.team.insurance.complementary.model.type.LocaleType;

import java.util.Date;
import java.util.Set;

/**
 * Created by hmohammadi on 11/10/17.
 */
public class User {
    private Date lastLogin;
    private LocaleType localeType;
    private String username;
    private String firstName;
    private String lastName;
    private String salt;
    private Set<Role> roles;

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public LocaleType getLocaleType() {
        return localeType;
    }

    public void setLocaleType(LocaleType localeType) {
        this.localeType = localeType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
