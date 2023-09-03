package com.qust.task.model;

import com.qust.task.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class AccountModel extends Account implements UserDetails {
    private String urealName; //用户真实姓名
    private Collection<? extends GrantedAuthority> authorities; //认证集


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUrealName() {
        return urealName;
    }

    public void setUrealName(String urealName) {
        this.urealName = urealName;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPwd();
    }

    @Override
    public String getUsername() {
        return super.getUname();
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    //省略构造方法以及get/set方法


    public AccountModel(String urealName, Collection<? extends GrantedAuthority> authorities) {
        this.urealName = urealName;
        this.authorities = authorities;
    }

    public AccountModel(Long id, String uname, String pwd, String phoneNumber, String utype, Date updatetime, Date createtime, String realname, String urealName, Collection<? extends GrantedAuthority> authorities) {
        super(id, uname, pwd, phoneNumber, utype, updatetime, createtime, realname);
        this.urealName = urealName;
        this.authorities = authorities;
    }

    public AccountModel(Long id, String uname, String pwd, String phoneNumber, String utype, String urealName, Date updatetime, Date createtime) {
        super(id, uname, pwd, phoneNumber, utype, updatetime, createtime, urealName);
        this.urealName = urealName;
    }

    public AccountModel(Long id, String uname, String realname, String role, String pwd, List<GrantedAuthority> auths) {
        super(id, uname, pwd, role, realname);
        this.urealName = realname;
        this.authorities = auths;
    }
}