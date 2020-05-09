package com.zx.sys.service.impl;

import com.dsa.common.enums.ResponseBean;
import com.zx.sys.dao.*;
import com.zx.sys.dto.DataInfoDto;
import com.zx.sys.dto.NoticeInfoDto;
import com.zx.sys.model.*;
import com.zx.sys.model.Class;
import com.zx.sys.service.ISystemManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @ClassName SystemManageImpl
 * @Description 系统管理 接口实现
 * @Author ZX
 * @Date 2020/5/2 16:19
 */
@Service
public class SystemManageImpl implements ISystemManageService {


    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RegistrationKeyMapper registrationKeyMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private ClassMapper classMapper;



    @Override
    /**
     * Description 增加公告信息
     * @Author ZX
     * @Date 16:21 2020/5/2
     * @param [noticeInfoDto]
     * username:发布人用户名
     * identity:发布人身份——1:管理员；2:教师
     * notice:要添加的公告对象
     * title:公告标题
     * content:公告内容
     * issueRange:公告发布范围——0:全部用户；1:学生；2:教师；3:管理员；
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addNotice(NoticeInfoDto noticeInfoDto) {
        String username = noticeInfoDto.getUsername();
        Integer identity = noticeInfoDto.getIdentity();
        Notice notice = new Notice();
        Date date = new Date();
        ResponseBean responseBean = new ResponseBean();
        notice.setTime(date);
        //当管理员进行添加公告时
        if(identity == 1){
            notice.setIssueRange(noticeInfoDto.getIssueRange());
            Admin admin = adminMapper.selectByUserName(username);
            notice.setIdentityId(admin.getId());
        }
        //当教师进行添加公告时
        else if(identity == 2){
            notice.setIssueRange(1);
            Teacher teacher = teacherMapper.selectByUserName(username);
            notice.setIdentityId(teacher.getId());
        }
        notice.setTitle(noticeInfoDto.getTitle());
        notice.setContent(noticeInfoDto.getContent());
        notice.setIdentity(identity);
        try {
            noticeMapper.insertSelective(notice);
            responseBean.setCode("200");
            responseBean.setMsg("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode("500");
            responseBean.setMsg("增加失败");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 删除公告信息
     * @Author ZX
     * @Date 16:23 2020/5/2
     * @param [dataInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteNotice(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] curriculumId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 3){
            for(Integer id : curriculumId){
                noticeMapper.deleteByPrimaryKey(id);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取公告信息
     * @Author ZX
     * @Date 16:25 2020/5/2
     * @param [dataInfoDto]:数据信息
     * option:用户身份
     * page:页码
     * count:每页数量
     * notice:获取所选页面的公告列表
     * map:页面公告信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> noticeInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        List<NoticeInfoDto> notice = new ArrayList<>();
        if(option == 3){
            NoticeExample noticeExample = new NoticeExample();
            //找到当前页面显示的公告列表
            List<Notice> list = noticeMapper.selectPagination(page,count);
            for (Notice value : list) {
                NoticeInfoDto noInfo = new NoticeInfoDto();
                //设置信息
                noInfo.setId(value.getId());
                noInfo.setTitle(value.getTitle());
                noInfo.setContent(value.getContent());
                noInfo.setDate(value.getTime());
                noInfo.setIssueRange(value.getIssueRange());
                noInfo.setIdentity(value.getIdentity());
                noInfo.setIdentityId(value.getIdentityId());
                //当发布公告身份是管理员时
                if (value.getIdentity() == 1) {
                    noInfo.setName(adminMapper.selectByPrimaryKey(value.getIdentityId()).getName());
                }
                //当发布公告身份是教师时
                else if (value.getIdentity() == 2) {
                    noInfo.setName(teacherMapper.selectByPrimaryKey(value.getIdentityId()).getName());
                }
                notice.add(noInfo);
            }
            map.put("list",notice);
            map.put("total",noticeMapper.countByExample(noticeExample));
            return map;
        }
        else{
            return null;
        }
    }

    @Override
    /**
     * Description 编辑公告信息
     * @Author ZX
     * @Date 16:26 2020/5/2
     * @param [noticeInfoDto]
     * identity:发布人身份：1:管理员；2:教师
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editNotice(NoticeInfoDto noticeInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        Integer identity = noticeInfoDto.getIdentity();
        Notice notice = new Notice();
        notice.setId(noticeInfoDto.getId());
        notice.setTitle(noticeInfoDto.getTitle());
        notice.setContent(noticeInfoDto.getContent());
        //当是管理员时
        if(identity == 1){
            notice.setIssueRange(noticeInfoDto.getIssueRange());
        }
        try {
            noticeMapper.updateByPrimaryKeySelective(notice);
            responseBean.setMsg("修改成功");
            responseBean.setCode("200");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setMsg("修改失败");
            responseBean.setCode("500");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取注册码信息
     * @Author ZX
     * @Date 11:21 2020/5/5
     * @param [dataInfoDto]
     * username: 用户名
     * option:用户身份
     * @return java.util.List<com.zx.sys.model.RegistrationKey>
     */
    public List<RegistrationKey> registerInit(DataInfoDto dataInfoDto) {
        String username = dataInfoDto.getUsername();
        Integer option = dataInfoDto.getOption();
        List<RegistrationKey> list = new ArrayList<>();
        if(option == 3){
            Admin admin = adminMapper.selectByUserName(username);
            if(admin != null){
                RegistrationKeyExample registrationKeyExample = new RegistrationKeyExample();
                list = registrationKeyMapper.selectByExample(registrationKeyExample);
            }
        }
        return list;
    }

    @Override
    /**
     * Description 修改注册码信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [registrationKey]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editRegister(RegistrationKey registrationKey) {
        ResponseBean responseBean = new ResponseBean();
        try {
            registrationKeyMapper.updateByPrimaryKeySelective(registrationKey);
            responseBean.setMsg("修改成功");
            responseBean.setCode("200");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setMsg("修改失败");
            responseBean.setCode("500");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 增加二级学院信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [college]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addCollege(College college) {
        ResponseBean responseBean = new ResponseBean();
        try {
            collegeMapper.insertSelective(college);
            responseBean.setCode("200");
            responseBean.setMsg("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode("500");
            responseBean.setMsg("增加失败");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 删除二级学院信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [dataInfoDto]
     * option:用户身份
     * collegeId:需要删除的二级学院编号
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteCollege(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] collegeId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 3){
            for(Integer id : collegeId){
                collegeMapper.deleteByPrimaryKey(id);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取二级学院信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [dataInfoDto]
     * option:用户身份
     * page:页码
     * count:每页数量
     * list:获取所选页面的二级学院列表
     * map:页面二级学院信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> collegeInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        if(option == 3){
            CollegeExample collegeExample = new CollegeExample();
            //找到当前页面显示的二级学院列表
            List<College> list = collegeMapper.selectPagination(page,count);
            map.put("list",list);
            map.put("total",collegeMapper.countByExample(collegeExample));
            return map;
        }
        else{
            return null;
        }
    }

    @Override
    /**
     * Description 修改二级学院信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [college]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editCollege(College college) {

        ResponseBean responseBean = new ResponseBean();
        try {
            collegeMapper.updateByPrimaryKey(college);
            responseBean.setMsg("修改成功");
            responseBean.setCode("200");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setMsg("修改失败");
            responseBean.setCode("500");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 增加班级信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [classInfo]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addClass(Class classInfo) {

        ResponseBean responseBean = new ResponseBean();
        try {
            classMapper.insertSelective(classInfo);
            responseBean.setCode("200");
            responseBean.setMsg("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode("500");
            responseBean.setMsg("增加失败");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 删除班级信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [dataInfoDto]
     * option:用户身份
     * classId:需要删除的班级编号
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteClass(DataInfoDto dataInfoDto) {

        Integer option = dataInfoDto.getOption();
        Integer [] classId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 3){
            for(Integer id : classId){
                classMapper.deleteByPrimaryKey(id);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取班级信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [dataInfoDto]
     * option:用户身份
     * page:页码
     * count:每页数量
     * list:获取所选页面的班级列表
     * map:页面班级信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> classInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        if(option == 3){
            ClassExample classExample = new ClassExample();
            //找到当前页面显示的班级列表
            List<Class> list = classMapper.selectPagination(page,count);
            map.put("list",list);
            map.put("total",classMapper.countByExample(classExample));
            return map;
        }
        else{
            return null;
        }
    }

    @Override
    /**
     * Description 修改班级信息
     * @Author ZX
     * @Date 23:07 2020/5/4
     * @param [classInfo]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editClass(Class classInfo) {
        ResponseBean responseBean = new ResponseBean();
        try {
            classMapper.updateByPrimaryKey(classInfo);
            responseBean.setMsg("修改成功");
            responseBean.setCode("200");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setMsg("修改失败");
            responseBean.setCode("500");
        }
        return responseBean;
    }
}
