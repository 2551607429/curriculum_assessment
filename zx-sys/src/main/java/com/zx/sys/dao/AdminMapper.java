package com.zx.sys.dao;

import com.zx.sys.dto.UserInfoDto;
import com.zx.sys.model.Admin;
import com.zx.sys.model.AdminExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);



//    自定义

    /**
     * 根据用户名查询管理员信息
     * @param username
     * @return
     */
    Admin selectByUserName(@Param("username")String username);

    /**
     * 更新用户信息
     * @param input
     * @param id
     * @return
     */
    int updateInfo(@Param("input") UserInfoDto input, @Param("id")Integer id);

    /**
     * 修改密码
     * @param pwd
     * @param id
     * @return
     */
    int updatePwd(@Param("pwd") String pwd,@Param("id")Integer id);

    /**
     * 分页获取管理员列表
     * @param page：第几页
     * @param count：每页显示的数量
     * @return
     */
    List<Admin> selectPagination(@Param("page")Integer page, @Param("count")Integer count);
}