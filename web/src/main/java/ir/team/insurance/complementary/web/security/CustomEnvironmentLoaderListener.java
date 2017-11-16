package ir.team.insurance.complementary.web.security;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.web.env.DefaultWebEnvironment;
import org.apache.shiro.web.env.EnvironmentLoader;
import org.apache.shiro.web.env.WebEnvironment;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CustomEnvironmentLoaderListener extends EnvironmentLoader
        implements ServletContextListener {

    @Inject
    private MyAuthenticatingRealm jpaRealm;

    @Override
    protected WebEnvironment createEnvironment(ServletContext pServletContext) {
        WebEnvironment environment = super.createEnvironment(pServletContext);
        RealmSecurityManager rsm = (RealmSecurityManager) environment.getSecurityManager();
//        PasswordService passwordService = new DefaultPasswordService();
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        PasswordMatcher passwordMatcher = new PasswordMatcher();
//        passwordMatcher.setPasswordService(passwordService);
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");
        jpaRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        rsm.setRealm(jpaRealm);
        ((DefaultWebEnvironment) environment).setSecurityManager(rsm);
        return environment;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initEnvironment(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        destroyEnvironment(sce.getServletContext());
    }
}
