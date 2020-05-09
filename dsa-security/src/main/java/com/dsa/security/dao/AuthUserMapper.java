package com.dsa.security.dao;

import com.dsa.security.model.AuthUser;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("authUserMapper")
public interface AuthUserMapper {
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    AuthUser getUserInfoByUsername(@Param("username") String username);
}
