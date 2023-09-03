package com.qust.task.mapper;

import com.qust.task.entity.AccountEntity;
import com.qust.task.model.AccountModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    AccountModel securityLogin(String uname);

    int resetPwd(Long id, String pwd);

    int regist(AccountEntity entity);

    int updateAccount(AccountEntity entity);

    int checkPhone(String phone);
}
