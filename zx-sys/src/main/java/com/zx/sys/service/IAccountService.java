package com.zx.sys.service;

import com.dsa.common.enums.ResponseBean;
import com.zx.sys.dto.DataInfoDto;
import com.zx.sys.dto.LoginInputDto;
import com.zx.sys.dto.NoticeLogDto;
import com.zx.sys.dto.UserInfoDto;
import com.zx.sys.model.Class;
import com.zx.sys.model.College;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IAccountLoginService
 * @Description 个人中心 接口实现
 * @Author ZX
 * @Date 2020/3/24 14:06
 */
public interface IAccountService {

    /**
     * Description 登录验证
     * @Author ZX
     * @Date 17:00 2020/3/26
     * @param loginInputDto
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean login(@RequestBody LoginInputDto loginInputDto);

    /**
     * Description 获取班级数据
     * @Author ZX
     * @Date 15:03 2020/3/24
     * @param
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<Integer, Class> classInfo();

    /**
     * Description 获取班级名称数据
     * @Author ZX
     * @Date 20:14 2020/4/30
     * @param
     * @return
     */
    List<Map<String, String>> className();

    /**
     * Description 获取注册时的学院数据
     * @Author ZX
     * @Date 15:03 2020/3/24
     * @param
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<Integer, College> collegeInfo();

    /**
     * Description 获取学院名称数据
     * @Author ZX
     * @Date 20:14 2020/4/30
     * @param
     * @return
     */
    List<Map<String, String>> collegeName();

    /**
     * Description 验证用户名是否已被注册
     * @Author ZX
     * @Date 21:01 2020/3/25
     * @param userInfoDto
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean UsernameUnique (UserInfoDto userInfoDto);

    /**
     * Description 验证教师编号是否已经被注册
     * @Author ZX
     * @Date 10:56 2020/5/8
     * @param userInfoDto
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean teacherIdUnique (UserInfoDto userInfoDto);

    /**
     * Description 验证注册码是否正确
     * @Author ZX
     * @Date 21:28 2020/3/25
     * @param userInfoDto
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean checkKey (UserInfoDto userInfoDto);

    /**
     * Description 注册用户信息
     * @Author ZX
     * @Date 22:18 2020/3/25
     * @param userInfoDto:注册信息
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean register (UserInfoDto userInfoDto);



    /**
     * Description 统计当前用户未查看的公告数量
     * @Author ZX
     * @Date 19:01 2020/3/27
     * @param loginInputDto
     * @return java.lang.Integer
     */
    Integer countNotice(@RequestBody LoginInputDto loginInputDto);

    /**
     * Description 获取用户公告列表
     * @Author ZX
     * @Date 15:32 2020/4/7
     * @param dataInfoDto
     * @return java.util.Map<java.lang.Integer,com.zx.sys.dto.NoticeInfoDto>
     */
    Map<String, Object> noticeInfo(@RequestBody DataInfoDto dataInfoDto);

    /**
     * Description 更改用户公告状态：将公告的状态插入公告日志中
     * @Author ZX
     * @Date 17:42 2020/4/7
     * @param noticeLogDto
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean noticeState(@RequestBody NoticeLogDto noticeLogDto);

    /**
     * Description 获取用户信息
     * @Author ZX
     * @Date 16:10 2020/4/17
     * @param loginInputDto
     * @return com.zx.sys.dto.RegisterInputDto
     */
    UserInfoDto userInfo(LoginInputDto loginInputDto);

    /**
     * Description 更新用户信息
     * @Author ZX
     * @Date 23:05 2020/4/17
     * @param userInfoDto
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean updateUserInfo(UserInfoDto userInfoDto);

    /**
     * Description 修改密码
     * @Author ZX
     * @Date 20:31 2020/4/18
     * @param userInfoDto
     * @return com.dsa.common.enums.ResponseBean
     */
    ResponseBean updatePwd(UserInfoDto userInfoDto);
}
