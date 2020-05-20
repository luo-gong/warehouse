package lg.cn.whmmember.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lg.cn.validation.EmailRegister;
import lg.cn.validation.Login;
import lg.cn.validation.MobileRegister;
import lg.cn.validation.UsernameRegister;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Table(name = "user")
@Entity(name = "user")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
//转json时忽略hibernateLazyInitializer字段，hibernate会给被管理的pojo加入一个hibernateLazyInitializer属性
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(groups = {Login.class, UsernameRegister.class})
    private String username;
    @NotNull(groups = {Login.class,
            UsernameRegister.class,
            MobileRegister.class,
            EmailRegister.class})
    private String password;
    @Email(groups = {EmailRegister.class})
    private String email;
    @Pattern(groups = {MobileRegister.class}, regexp = "^1[3456789]\\d{9}$")
    private String mobile;
    private boolean enabled;
    private Boolean locked;


    private Boolean isDelete;


    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "uid", referencedColumnName = "id")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "rid", referencedColumnName = "id")
            })
    private List<Role> roles;

    @Transient//表示忽略这个字段的映射
    private Collection<GrantedAuthority> grantedAuthorities;

    public Collection<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return this.locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
