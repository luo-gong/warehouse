package lg.cn.whmmember.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menu")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
//转json时忽略hibernateLazyInitializer字段，hibernate会给被管理的pojo加入一个hibernateLazyInitializer属性
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pattern;
    private String name;
    private Timestamp createdate;

    @JsonIgnore
    @ManyToMany(targetEntity = Menu.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "menu_role", joinColumns = {
            @JoinColumn(name = "mid", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "rid", referencedColumnName = "id")
    })
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }
}
