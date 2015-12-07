package xyz.test.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1458042423010347783L;

    public Role() {

    }

    public Role(Integer id) {
	this.id = id;
    }

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    @NotEmpty
    @NotNull
    private String description;

    @Column(name = "`order`")
    private Integer order;

    @Column(name = "visible")
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

}
