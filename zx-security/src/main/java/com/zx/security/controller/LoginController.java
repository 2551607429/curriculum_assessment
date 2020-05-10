package com.zx.security.controller;

import com.zx.security.base.BaseResponse;
import com.zx.security.model.AuthUser;
import com.zx.security.service.AuthUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

    private AuthUserService userService;

    public LoginController(AuthUserService userService) {
    	this.userService = userService;
    }

    /**
     * 用户名密码登录，获取token
     * @param request
     * @return token
     */
    @PostMapping(value = "/login")
    public BaseResponse<?> login(@RequestBody AuthUser loginInfo, HttpServletRequest request, HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(loginInfo.getUsername(), loginInfo.getPassword());
            subject.login(token);

            AuthUser user = (AuthUser) subject.getPrincipal();
            String newToken = userService.generateJwtToken(user.getUsername());

            return new BaseResponse<>(0,"登录成功",newToken);
        } catch (AuthenticationException e) {
            logger.error("User {} login fail, Reason:{}", loginInfo.getUsername(), e.getMessage());
            return new BaseResponse<>(-1,"账号/密码错误","");
        } catch (Exception e) {
            return new BaseResponse<>(-1,"登录失败，请稍后再试","");
        }
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping(value = "/logout")
    public ResponseEntity<Void> logout() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipals() != null) {
            AuthUser user = (AuthUser)subject.getPrincipals().getPrimaryPrincipal();
            userService.deleteLoginInfo(user.getUsername());
        }
        SecurityUtils.getSubject().logout();
        return ResponseEntity.ok().build();
    }
}
