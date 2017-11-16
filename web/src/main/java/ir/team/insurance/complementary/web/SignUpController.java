package ir.team.insurance.complementary.web;

/*
import ir.team.insurance.complementary.api.GeneralServiceApi;
import ir.team.insurance.complementary.api.RoleService;
import ir.team.insurance.complementary.api.UserService;
import ir.team.insurance.complementary.model.to.security.Role;
import ir.team.insurance.complementary.model.to.security.User;
import ir.team.insurance.complementary.web.controller.base.BaseControllerService;
import ir.team.insurance.complementary.web.controller.base.LoadControllerService;
*/
import org.apache.shiro.crypto.hash.Sha256Hash;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@ViewScoped
public class SignUpController /*extends BaseControllerService*/ implements Serializable {

    /*
    @EJB
    private UserService userService;

    @EJB
    private RoleService roleService;

    private User user = new User();
    private String confirmPassword;
    private List<Role> roles;
    private Long role;
    private Map<Long, Role> stringRoleMap = new HashMap<>();

    @PostConstruct
    private void init() {
        roles = roleService.findAll();
        for (Role role : roles) {
            stringRoleMap.put(role.getId(), role);
        }
    }

    public String createAction() {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(stringRoleMap.get(role));
        user.setRoles(roleSet);
        user.setUsername(user.getUsername().toLowerCase());
        user.setSalt(user.getUsername().toUpperCase());
        Sha256Hash hashPassword = new Sha256Hash(user.getPassword(), user.getUsername().toUpperCase());
        user.setPassword(hashPassword.toString());
        setEntity(user);
        return super.createAction();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public void afterLoad() {

    }

    @Override
    public GeneralServiceApi getGeneralServiceApi() {
        return userService;
    }

    @Override
    public LoadControllerService getLoadControllerService() {
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
    */
}

