package com.zx.security.service;

import com.zx.security.model.AuthUser;

import java.util.List;

public interface AuthUserService {
    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param username
     * @param password
     * @return
     */
    AuthUser getUserInfo(String username, String password);

    /**
     * 获取用户角色
     * @param userId
     * @return
     */
    List<String> getUserRoles(Integer userId);

    /**
     * 获取上次token生成时的salt值和登录用户信息
     * @param username
     * @return
     */
    AuthUser getJwtTokenInfo(String username);

    /**
     * 保存user登录信息，返回token
     * @param username
     * @return
     */
    String generateJwtToken(String username);

    /**
     * 清除token信息
     * @param username
     */
    void deleteLoginInfo(String username);
}
