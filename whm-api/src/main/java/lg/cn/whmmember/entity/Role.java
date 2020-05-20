package lg.cn.whmmember.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Table(name = "role")
@Entity(name = "role")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
//转json时忽略hibernateLazyInitializer字段，hibernate会给被管理的pojo加入一个hibernateLazyInitializer属性
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nameZh;
    private Boolean enabled;
    private Timestamp createdate;
    private boolean isDelete;


    private String remarks;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> users;

    @ManyToMany(targetEntity = Menu.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "menu_role", joinColumns = {
            @JoinColumn(name = "rid", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "mid", referencedColumnName = "id")
    })
    private List<Menu> menus;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }


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

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }


}
