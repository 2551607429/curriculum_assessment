package com.dsa.security.config;

import java.util.List;

import com.dsa.security.model.AuthUser;
import com.dsa.security.service.AuthUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbShiroRealm extends AuthorizingRealm {
	private final Logger log = LoggerFactory.getLogger(DbShiroRealm.class);

	private AuthUserService userService;

	public DbShiroRealm(AuthUserService userService) {
		this.userService = userService;
		this.setCredentialsMatcher(new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME));
	}

	@Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

	/**
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userpasswordToken = (UsernamePasswordToken)token;
		String username = userpasswordToken.getUsername();
		String password = String.valueOf(userpasswordToken.getPassword());
		AuthUser user = userService.getUserInfo(username,password);
		if(user == null)
			throw new AuthenticationException("用户名或者密码错误");

		return new SimpleAuthenticationInfo(user, user.getEncryptPwd(), ByteSource.Util.bytes(user.getSalt()), "dbRealm");
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//AuthUser user = (AuthUser) principals.getPrimaryPrincipal();
		//角色
        /*List<String> roles = user.getRoles();
        if(roles == null) {
            roles = userService.getUserRoles(user.getUserId());
            user.setRoles(roles);
        }
        if (roles != null)
            simpleAuthorizationInfo.addRoles(roles);*/

        return simpleAuthorizationInfo;
	}


}
