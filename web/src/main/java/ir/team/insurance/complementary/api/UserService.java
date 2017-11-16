package ir.team.insurance.complementary.api;

import ir.team.insurance.complementary.model.to.security.Permission;
import ir.team.insurance.complementary.model.to.security.User;

/**
 * Created by hmohammadi on 11/10/17.
 */
public class UserService {
    public Permission findUserPermissions(String currentUser) {
        return new Permission();
    }


    public User authenticate(String username, String hashPassword) {
        return new User();
    }

    public User findByUsername(String username) {
        return null;
    }
}
