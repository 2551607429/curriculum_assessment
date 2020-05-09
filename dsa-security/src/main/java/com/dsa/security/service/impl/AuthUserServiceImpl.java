package com.dsa.security.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.dsa.security.dao.AuthUserMapper;
import com.dsa.security.utils.JwtUtils;
import com.dsa.security.model.AuthUser;
import com.dsa.security.service.AuthUserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


/**
 * 用户信息接口
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private AuthUserMapper authUserMapper;

	@Value("${jwt.expiresecond}")
	private long expiresecond;

    /**
     * 保存user登录信息，返回token
     * @param username
     */
	@Override
    public String generateJwtToken(String username) {
		//生成随机扰码
    	String salt = JwtUtils.generateSalt();
    	/**
    	 * @todo 将salt保存到数据库或者缓存中
    	 */
		redisTemplate.opsForValue().set("token:"+username, salt, expiresecond, TimeUnit.SECONDS);
    	return JwtUtils.sign(username, salt, expiresecond); //生成jwt token，设置过期时间为1小时
    }

    /**
     * 获取上次token生成时的salt值和登录用户信息
     * @param username
     * @return
     */
	@Override
    public AuthUser getJwtTokenInfo(String username) {
		/**
		 * @todo 从数据库或者缓存中取出jwt token生成时用的salt
		 */
		String salt = redisTemplate.opsForValue().get("token:"+username);
		AuthUser user = authUserMapper.getUserInfoByUsername(username);
		user.setSalt(salt);
		return user;
    }

    /**
     * 清除token信息
     * @param username 登录用户名
     */
    @Override
    public void deleteLoginInfo(String username) {
    	/**
    	 * @todo 删除数据库或者缓存中保存的salt
    	 */
		redisTemplate.delete("token:"+username);
    }

    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param username
     * @return
     */
	@Override
    public AuthUser getUserInfo(String username,String password) {
		AuthUser user = authUserMapper.getUserInfoByUsername(username);
		String encryptPwd = new Sha256Hash(password, user.getSalt()).toHex();
		//密码验证失败，直接返回null
		if(!user.getPassword().equals(encryptPwd)){
			return null;
		}
		user.setEncryptPwd(encryptPwd);
		return user;
    }

	@Override
	public List<String> getUserRoles(Integer userId) {
		return Arrays.asList("admin");
	}

}
