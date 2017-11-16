package ir.team.insurance.complementary.web.security;

import ir.team.insurance.complementary.api.PermissionService;
import ir.team.insurance.complementary.api.UserService;
import ir.team.insurance.complementary.model.to.security.Permission;
import ir.team.insurance.complementary.model.to.security.Role;
import ir.team.insurance.complementary.model.to.security.User;
import ir.team.insurance.complementary.web.user.UserInformation;
import ir.team.insurance.complementary.web.util.ResourceBundleUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MyAuthenticatingRealm extends AuthorizingRealm {

    @Inject
    private UserService userDao;

    @Inject
    private UserInformation userInformation;

    @Inject
    private PermissionService permissionDao;

    public MyAuthenticatingRealm() {
        setName("jpaRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println(principalCollection.getRealmNames().size());
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        Sha256Hash hashPassword = new org.apache.shiro.crypto.hash.Sha256Hash(usernamePasswordToken.getPassword(), usernamePasswordToken.getUsername().toUpperCase());
        User user = userDao.authenticate(usernamePasswordToken.getUsername(), hashPassword.toString());
        if (user != null) {
            user.setLastLogin(new Date());
            userInformation.setLocale(user.getLocaleType().getValue());
            userInformation.setUsername(user.getUsername());
            userInformation.setFirstName(user.getFirstName());
            userInformation.setLastName(user.getLastName());
            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    new SimpleAuthenticationInfo(user.getUsername(), hashPassword.toHex(), new SimpleByteSource(user.getSalt()), getName());
            return simpleAuthenticationInfo;
        } else {
            throw new AuthenticationException(ResourceBundleUtil.getMessageBundle().getString("authenticate.not.valid"));
        }
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        User user = userDao.findByUsername(principals.getPrimaryPrincipal().toString());
        Set<Role> roles = user.getRoles();
        Set<String> roleNames = new HashSet<>();
        for (Role role : roles) {
            roleNames.add(role.getName());
        }
        return new SimpleAuthorizationInfo(roleNames);
    }

    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        if (permission != null) {
            String[] permissionPortion = permission.split(":");
            String username = SecurityUtils.getSubject().getPrincipal().toString();
            User user = userDao.findByUsername(username);
            try {
                Set<Role> roles = user.getRoles();
                for (Role role : roles) {
                    for (Permission rolePermission : role.getPermissions()) {
                        if (rolePermission == null) {
                            continue;
                        }

                        if (rolePermission.getName().equals(permissionPortion[0])) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (NoResultException e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
