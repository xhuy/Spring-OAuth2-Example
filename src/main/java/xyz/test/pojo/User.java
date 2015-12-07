package xyz.test.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -198410314369231653L;

    public User() {

    }

    public User(Integer id) {
	this.id = id;
    }

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    @NotEmpty
    @NotNull
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enable")
    private Boolean enable;

    @OneToOne
    @JoinColumn(name = "role")
    private Role role;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Boolean getEnable() {
	return enable;
    }

    public void setEnable(Boolean enable) {
	this.enable = enable;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }




}