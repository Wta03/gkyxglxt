package com.qust.task.service;

import com.qust.task.mapper.AccountMapper;
import com.qust.task.model.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AccountModel accountModel = accountMapper.securityLogin(s);
        if (accountModel == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        String role = accountModel.getUtype();
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        System.out.println(accountModel.getRealname());
        AccountModel am = new AccountModel(accountModel.getId(), accountModel.getUname(), accountModel.getRealname(), role, accountModel.getPwd(), auths);
        return am;
    }
}
