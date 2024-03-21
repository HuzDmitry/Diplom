package by.TestFireAlarm.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Logins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    @ManyToMany
    @JoinTable(name = "logins_roles", joinColumns = @JoinColumn(name="logins_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Collection<Roles> rolesList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(Collection<Roles> rolesList) {
        this.rolesList = rolesList;
    }
}
