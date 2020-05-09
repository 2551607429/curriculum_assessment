package com.zx.sys.controller;

import com.dsa.common.enums.ResponseBean;
import com.zx.sys.dto.*;
import com.zx.sys.model.Class;
import com.zx.sys.model.College;
import com.zx.sys.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @Author ZX
 * @Description 注册与登录
 * @Date 22:48 2020/3/15
 * @param 
 * @return 
 */
@RestController
@RequestMapping("/sys")
public class SysController {
    @Autowired
    private IAccountService iAccountService;


    @PostMapping("/login")
    /**
     * @Author ZX
     * @Description 判断登录信息
     * @Date 23:40 2020/3/15
     * @param [loginInputDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean login(@RequestBody LoginInputDto loginInputDto){
        return iAccountService.login(loginInputDto);
    }

    @PostMapping("/class_info")
    /**
     * @Author ZX
     * @Description 获取班级数据
     * @Date 18:30 2020/3/24
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Class>
     */
    public Map<Integer, Class> classInfo(){
        return iAccountService.classInfo();
    }

    @PostMapping("/class_name")
    /**
     * Description 获取班级名称数据
     * @Author ZX
     * @Date 20:12 2020/4/30
     * @param []
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String, String>> className(){
        return iAccountService.className();
    }

    @PostMapping("/college_info")
    /**
     * @Author ZX
     * @Description 获取学院数据
     * @Date 18:32 2020/3/24
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.College>
     */
    public Map<Integer, College> collegeInfo(){
        return iAccountService.collegeInfo();
    }

    @PostMapping("/college_name")
    /**
     * Description 获取学院名称数据
     * @Author ZX
     * @Date 19:53 2020/5/1
     * @param []
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String, String>> collegeName(){
        return iAccountService.collegeName();
    }

    @PostMapping("/username_unique")
    /**
     * @Author ZX
     * @Description 判断用户名是否注册过
     * @Date 21:05 2020/3/24
     * @param []
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean userNameUnique(@RequestBody UserInfoDto userInfoDto){
        return iAccountService.UsernameUnique(userInfoDto);
    }

    @PostMapping("/teacherId_unique")
    /**
     * Description 判断教师编号是否注册过
     * @Author ZX
     * @Date 11:11 2020/5/8
     * @param userInfoDto
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean teacherIdUnique(@RequestBody UserInfoDto userInfoDto){
        return iAccountService.teacherIdUnique(userInfoDto);
    }

    @PostMapping("/check_key")
    /**
     * @Author ZX
     * @Description 验证注册码是否正确
     * @Date 21:05 2020/3/24
     * @param []
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean checkKey(@RequestBody UserInfoDto userInfoDto){
        return iAccountService.checkKey(userInfoDto);
    }


    @PostMapping("/register")
    /**
     * @Author ZX
     * @Description 注册用户信息
     * @Date 21:05 2020/3/24
     * @param []
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean register(@RequestBody UserInfoDto userInfoDto){
        return iAccountService.register(userInfoDto);
    }


    @PostMapping("/notice_count")
    /**
     * @Author ZX
     * @Description 获取用户当前未读的公告数量
     * @Date 14:53 2020/4/1
     * @param [loginInputDto]
     * @return java.lang.Integer
     */
    public Integer noticeCount(@RequestBody LoginInputDto loginInputDto){
        return iAccountService.countNotice(loginInputDto);
    }

    @PostMapping("/notice_init")
    /**
     * @Author ZX
     * @Description 获取用户公告列表数据
     * @Date 16:27 2020/4/7
     * @param [dataInfoDto]
     * @return java.util.List<com.zx.sys.dto.NoticeInfoDto>
     */
    public Map<String, Object> noticeInit(@RequestBody DataInfoDto dataInfoDto){
        return iAccountService.noticeInfo(dataInfoDto);
    }

    @PostMapping("/notice_state")
    /**
     * @Author ZX
     * @Description 修改公告状态
     * @Date 22:31 2020/4/11
     * @param [noticeLogDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean noticeState(@RequestBody NoticeLogDto noticeLogDto){
        return iAccountService.noticeState(noticeLogDto);
    }

    @PostMapping("/user_info")
    /**
     * @Author ZX
     * @Description 获取用户信息
     * @Date 22:57 2020/4/17
     * @param [loginInputDto]
     * @return com.zx.sys.dto.RegisterInputDto
     */
    public UserInfoDto userInfo(@RequestBody LoginInputDto loginInputDto){
        return iAccountService.userInfo(loginInputDto);
    }

    @PostMapping("/update_userInfo")
    /**
     * @Author ZX
     * @Description 更改用户信息
     * @Date 23:03 2020/4/17
     * @param [registerInputDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean updateUserInfo(@RequestBody UserInfoDto userInfoDto){
        return iAccountService.updateUserInfo(userInfoDto);
    }

    @PostMapping("/update_pwd")
    /**
     * @Author ZX
     * @Description 修改密码
     * @Date 20:45 2020/4/18
     * @param [registerInputDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean updatePwd(@RequestBody UserInfoDto userInfoDto){
        return iAccountService.updatePwd(userInfoDto);
    }

}
