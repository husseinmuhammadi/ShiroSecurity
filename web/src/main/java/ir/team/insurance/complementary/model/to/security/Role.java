package ir.team.insurance.complementary.model.to.security;

/**
 * Created by hmohammadi on 11/10/17.
 */
public class Role {
    private String name;
    private Permission[] permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission[] getPermissions() {
        return permissions;
    }

    public void setPermissions(Permission[] permissions) {
        this.permissions = permissions;
    }
}
