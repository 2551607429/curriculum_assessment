package com.zx.sys.service.impl;

import com.zx.common.enums.ResponseBean;
import com.zx.sys.dao.*;
import com.zx.sys.dto.*;
import com.zx.sys.model.*;
import com.zx.sys.model.Class;
import com.zx.sys.service.IAccountService;
import com.zx.sys.service.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName UserManageImpl
 * @Description TODO
 * @Author ZX
 * @Date 2020/5/7 15:57
 */
@Service
public class UserManageImpl implements IUserManageService {


    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeachingMapper teachingMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private IAccountService iAccountService;


    @Override
    /**
     * Description 增加用户信息
     * @Author ZX
     * @Date 9:16 2020/4/30
     * @param [userInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addUser(UserInfoDto userInfoDto) {
        ResponseBean responseBean = iAccountService.register(userInfoDto);
        if("200".equals(responseBean.getCode())){
            responseBean.setMsg("增加成功！");
        }
        else{
            responseBean.setMsg("增加失败！");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 批量上传用户信息
     * @Author ZX
     * @Date 9:17 2020/4/30
     * @param [list]
     * responseBean:返回的信息
     * res:添加列表中每个用户信息的返回信息
     * successCount:成功上传数量
     * failCount:失败上传数量
     * regexPass:验证密码的正则表达式
     * regexStuId:验证学号的正则表达式
     * regexUserName:验证用户名的正则表达式
     * upload:上传数据对象
     * failList:失败上传列表
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean uploadUser(List<UserInfoDto> list) {
        ResponseBean responseBean = new ResponseBean();
        ResponseBean res;
        Integer successCount = 0;
        Integer failCount = 0;
        String regexPass = "^\\w{6,18}$";
        String regexStuId = "^\\d{4,16}$";
        String regexUserName = "^[a-zA-Z]\\w{4,15}$";
        List<UserInfoDto> failList = new ArrayList<>();
        UploadInfoDto upload = new UploadInfoDto();
        try {
            for(UserInfoDto user : list){
                //判断该用户是否上传成功：false：失败；true：成功
                boolean flag = false;
              //当密码和用户名符合规范时且用户名尚未被注册
                if( user.getPass().matches(regexPass) && user.getUsername().matches(regexUserName) &&
                        (!"101".equals(iAccountService.UsernameUnique(user).getCode())) ){
                    //当批量导入学生时
                    if(user.getOption() == 1){
                        //当输入的班级名称存在、用户名不存在且学号符合规范时
                        if(classMapper.selectByName(user.getClassName()) != null && user.getStuId().matches(regexStuId)){
                            //将该班级的编号录入进去
                            user.setClassId(classMapper.selectByName(user.getClassName()));
                            res = addUser(user);
                            if("200".equals(res.getCode())) {
                                flag = true;
                                successCount++;
                            }
                        }
                        else if(classMapper.selectByName(user.getClassName()) == null){
                            user.setKey("班级名称错误，请输入正确的班级！");
                        }
                        else if(user.getStuId().matches(regexStuId)){
                            user.setKey("学号格式不正确，请重新填写！");
                        }
                    }
                    //当批量导入教师时
                    else if(user.getOption() == 2){
                        //当输入的学院名称存在时且教师编号符合规范并且没有被注册时
                        if(collegeMapper.selectByName(user.getCollegeName()) != null && user.getTeacherId().matches(regexStuId) &&
                                (!"409".equals(iAccountService.teacherIdUnique(user).getCode())) ){
                            //将该学院的编号录入进去
                            user.setCollegeId(collegeMapper.selectByName(user.getCollegeName()));
                            res = addUser(user);
                            if("200".equals(res.getCode())) {
                                flag = true;
                                successCount++;
                            }
                        }
                        else if(collegeMapper.selectByName(user.getCollegeName()) == null){
                            user.setKey("学院名称错误，请输入正确的学院！");
                        }
                        else if(user.getTeacherId().matches(regexStuId)){
                            user.setKey("教师编号格式不正确，请重新填写！");
                        }
                        else if("409".equals(iAccountService.teacherIdUnique(user).getCode())){
                            user.setKey("教师编号已存在，请重新填写！");
                        }
                    }
                }
                else if(user.getPass().matches(regexPass)){
                    user.setKey("密码格式不正确，请重新填写！");
                }
                else if(user.getUsername().matches(regexUserName)){
                    user.setKey("用户名格式不正确，请重新填写！");
                }
                else if("101".equals(iAccountService.UsernameUnique(user).getCode())){
                    user.setKey("该用户名已存在，请更换！");
                }
                if(!flag){
                    failCount++;
                    failList.add(user);
                }
            }
            upload.setAllCount(list.size());
            upload.setFailCount(failCount);
            upload.setSuccessCount(successCount);
            upload.setResponseList(Collections.singletonList(failList));
            responseBean.setCode("200");
            responseBean.setData(upload);
            responseBean.setMsg("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode("500");
            responseBean.setMsg("上传失败");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 删除用户信息
     * @Author ZX
     * @Date 9:17 2020/4/30
     * @param [dataInfoDto]
     * option:需要删除的用户身份
     * userId:需要删除的用户编号
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteUser(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] userId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 1){
            for(Integer id : userId){
                studentMapper.deleteByPrimaryKey(id);
            }
        }
        else if(option == 2){
            for(Integer id : userId){
                teacherMapper.deleteByPrimaryKey(id);
            }
        }
        else if(option == 3){
            for(Integer id : userId){
                adminMapper.deleteByPrimaryKey(id);
            }
        }
        responseBean.setCode("200");
        responseBean.setMsg("删除成功");
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取用户信息
     * @Author ZX
     * @Date 9:17 2020/4/30
     * @param [dataInfoDto]
     * option:需要获取的用户身份
     * page:页码
     * count:每页数量
     * map:页面学生信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> userInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        List<UserInfoDto> userList = new ArrayList<UserInfoDto>();
        //当需要查询学生信息时
        if(option == 1){
            StudentExample studentExample = new StudentExample();
            //找到当前页面显示的学生列表
            List<Student> list = studentMapper.selectPagination(page,count);
            for (Student student : list) {
                LoginInputDto loginInputDto = new LoginInputDto();
                loginInputDto.setUsername(student.getUsername());
                loginInputDto.setOption(1);
                //通过用户名和身份查询学生信息
                UserInfoDto user = iAccountService.userInfo(loginInputDto);
                //获取班级名称
                user.setClassName(classMapper.selectByPrimaryKey(user.getClassId()).getName());
                userList.add(user);
            }
            map.put("list",userList);
            map.put("total",studentMapper.countByExample(studentExample));
            return map;
        }
        else if(option == 2){
            TeacherExample teacherExample = new TeacherExample();
            //找到当前页面显示的教师列表
            List<Teacher> list = teacherMapper.selectPagination(page,count);
            for (Teacher teacher : list) {
                LoginInputDto loginInputDto = new LoginInputDto();
                loginInputDto.setUsername(teacher.getUsername());
                loginInputDto.setOption(2);
                //通过用户名和身份查询教师信息
                UserInfoDto user = iAccountService.userInfo(loginInputDto);
                //获取学院名称
                user.setCollegeName(collegeMapper.selectByPrimaryKey(user.getCollegeId()).getName());
                userList.add(user);
            }
            map.put("list",userList);
            map.put("total",teacherMapper.countByExample(teacherExample));
            return map;
        }
        else if(option == 3){
            AdminExample adminExample = new AdminExample();
            //找到当前页面显示的教师列表
            List<Admin> list = adminMapper.selectPagination(page,count);
            for (Admin admin : list) {
                LoginInputDto loginInputDto = new LoginInputDto();
                loginInputDto.setUsername(admin.getUsername());
                loginInputDto.setOption(3);
                //通过用户名和身份查询管理员信息
                UserInfoDto user = iAccountService.userInfo(loginInputDto);
                userList.add(user);
            }
            map.put("list",userList);
            map.put("total",adminMapper.countByExample(adminExample));
            return map;
        }
        else{
            return null;
        }
    }

    @Override
    /**
     * Description 修改用户信息
     * @Author ZX
     * @Date 9:17 2020/4/30
     * @param [userInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editUser(UserInfoDto userInfoDto) {
        ResponseBean responseBean = iAccountService.updateUserInfo(userInfoDto);
        if("500".equals(responseBean.getCode())){
            responseBean.setCode("500");
            responseBean.setMsg("修改失败");
        }
        else{
            responseBean.setCode("200");
            responseBean.setMsg("修改成功");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 增加任课信息
     * @Author ZX
     * @Date 16:13 2020/5/7
     * @param [teachingInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addTeaching(TeachingInfoDto teachingInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Teaching teaching = new Teaching();
            teaching.setTeacherId(teachingInfoDto.getTeacherId());
            teaching.setClassId(teachingInfoDto.getClassId());
            teaching.setCurriculumId(teachingInfoDto.getCurriculumId());
            teaching.setStartTime(teachingInfoDto.getTeachingDate().get(0));
            teaching.setEndTime(teachingInfoDto.getTeachingDate().get(1));
            teachingMapper.insertSelective(teaching);
            responseBean.setCode("200");
            responseBean.setMsg("增加成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode("500");
            responseBean.setMsg("增加失败");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 批量上传任课信息
     * @Author ZX
     * @Date 16:14 2020/5/7
     * @param [list]
     * responseBean:返回的信息
     * res:添加列表中每个任课信息的返回信息
     * successCount:成功上传数量
     * failCount:失败上传数量
     * upload:上传数据对象
     * failList:失败上传列表
     * regexDate:验证 yyyy-MM-dd 格式的正则表达式
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean uploadTeaching(List<TeachingInfoDto> list) {
        ResponseBean responseBean = new ResponseBean();
        ResponseBean res;
        Integer successCount = 0;
        Integer failCount = 0;
        UploadInfoDto upload = new UploadInfoDto();
        List<TeachingInfoDto> failList = new ArrayList<>();
        String regexDate = "^\\d{4}-\\d{1,2}-\\d{1,2}";
        try {
            for(TeachingInfoDto value : list){
                //判断该任课信息是否上传成功：false：失败；true：成功
                boolean flag = false;
                if(teacherMapper.selectByTeacherId(value.getTeachId()) != null &&
                classMapper.selectByName(value.getClassName()) != null &&
                curriculumMapper.selectByName(value.getCurriculumName()) != null){
                    Teaching teaching = new Teaching();
                    teaching.setTeacherId(teacherMapper.selectByTeacherId(value.getTeachId()).getId());
                    teaching.setClassId(classMapper.selectByName(value.getClassName()));
                    teaching.setCurriculumId(curriculumMapper.selectByName(value.getCurriculumName()).getId());
                    teaching.setStartTime(value.getStartTime());
                    teaching.setEndTime(value.getEndTime());
                    try {
                        teachingMapper.insertSelective(teaching);
                        flag = true;
                        successCount++;
                    } catch (Exception e) {
                        flag = false;
                    }
                }
                else if(teacherMapper.selectByTeacherId(value.getTeachId()) == null){
                    value.setKey("教师编号不存在，请重新输入！");
                }
                else if(classMapper.selectByName(value.getClassName()) == null){
                    value.setKey("班级名称不存在，请重新输入！");
                }
                else if(curriculumMapper.selectByName(value.getCurriculumName()) == null){
                    value.setKey("课程名称不存在，请重新输入！");
                }
                else{
                    value.setKey("上传失败，请重新上传！");
                }
                if(!flag){
                    failList.add(value);
                    failCount++;
                }
            }
            upload.setAllCount(list.size());
            upload.setFailCount(failCount);
            upload.setSuccessCount(successCount);
            upload.setResponseList(Collections.singletonList(failList));
            responseBean.setCode("200");
            responseBean.setData(upload);
            responseBean.setMsg("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode("500");
            responseBean.setMsg("上传失败");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 删除任课信息
     * @Author ZX
     * @Date 16:14 2020/5/7
     * @param [dataInfoDto]
     * option:用户身份
     * teacherId:需要删除的任课教师编号
     * curriculumId:需要删除的课程编号
     * classId:需要删除的班级编号
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteTeaching(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] teacherId = dataInfoDto.getTeacherId();
        Integer [] curriculumId = dataInfoDto.getCurriculumId();
        Integer [] classId = dataInfoDto.getClassId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 3 && teacherId.length == curriculumId.length && curriculumId.length == classId.length){
            for(int i = 0;i < teacherId.length;i++){
                TeachingKey teachingKey = new TeachingKey();
                teachingKey.setClassId(classId[i]);
                teachingKey.setCurriculumId(curriculumId[i]);
                teachingKey.setTeacherId(teacherId[i]);
                teachingMapper.deleteByPrimaryKey(teachingKey);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        else{
            responseBean.setCode("500");
            responseBean.setMsg("删除失败");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取任课信息
     * @Author ZX
     * @Date 16:14 2020/5/7
     * @param [dataInfoDto]
     * option:用户身份
     * page:页码
     * count:每页数量
     * list:获取所选页面的任课列表
     * map:页面任课信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> teachingInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        if(option == 3){
            TeachingExample teachingExample = new TeachingExample();
            //查询当前页面显示的任课列表
            List<Teaching> list = teachingMapper.selectPagination(page,count);
            List<TeachingInfoDto> teachList = new ArrayList<>();
            //对每个任课信息增加内容
            for (Teaching teaching : list) {
                TeachingInfoDto value = new TeachingInfoDto();
                value.setTeacherId(teaching.getTeacherId());
                value.setTeacherName(teacherMapper.selectByPrimaryKey(teaching.getTeacherId()).getName());
                value.setCurriculumId(teaching.getCurriculumId());
                value.setCurriculumName(curriculumMapper.selectByPrimaryKey(teaching.getCurriculumId()).getName());
                value.setClassId(teaching.getClassId());
                value.setClassName(classMapper.selectByPrimaryKey(teaching.getClassId()).getName());
                value.setStartTime(teaching.getStartTime());
                value.setEndTime(teaching.getEndTime());
                teachList.add(value);
            }
            map.put("list",teachList);
            map.put("total",teachingMapper.countByExample(teachingExample));
            return map;
        }
        else{
            return null;
        }
    }

    @Override
    /**
     * Description 修改任课信息
     * @Author ZX
     * @Date 16:14 2020/5/7
     * @param [teachingInfoDto]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editTeaching(TeachingInfoDto teachingInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        Teaching teaching = new Teaching();
        teaching.setTeacherId(teachingInfoDto.getTeacherId());
        teaching.setClassId(teachingInfoDto.getClassId());
        teaching.setCurriculumId(teachingInfoDto.getCurriculumId());
        teaching.setStartTime(teachingInfoDto.getTeachingDate().get(0));
        teaching.setEndTime(teachingInfoDto.getTeachingDate().get(1));
        try {
            teachingMapper.updateByPrimaryKey(teaching);
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
     * Description 获取所有的教师信息
     * @Author ZX
     * @Date 21:50 2020/5/8
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Teacher>
     */
    public Map<Integer, Teacher> teacherInfo() {
        Map<Integer, Teacher> info = new HashMap<>();
        TeacherExample teacherExample = new TeacherExample();
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        for(Teacher te : list){
            info.put(te.getId(),te);
        }
        return info;
    }

    @Override
    /**
     * Description 获取所有的课程信息
     * @Author ZX
     * @Date 21:51 2020/5/8
     * @param dataInfoDto
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Curriculum>
     */
    public Map<Integer, Curriculum> curriculumInfo(DataInfoDto dataInfoDto) {
        Map<Integer, Curriculum> info = new HashMap<>();
        //当管理员获取课程时，为全部信息
        if(dataInfoDto.getOption() == 3){
            CurriculumExample curriculumExample = new CurriculumExample();
            List<Curriculum> list = curriculumMapper.selectByExample(curriculumExample);
            for(Curriculum cu : list){
                info.put(cu.getId(),cu);
            }
        }
        //当教师获取课程时，只能获取自己教授的课程
        else if(dataInfoDto.getOption() == 2){
            Teacher teacher = teacherMapper.selectByUserName(dataInfoDto.getUsername());
            Date date = new Date();
            List<Curriculum> list = curriculumMapper.selectByTeacher(date,teacher.getId());
            for(Curriculum cu : list){
                info.put(cu.getId(),cu);
            }
        }
        return info;
    }

    @Override
    /**
     * Description 获取任课信息中所有的筛选信息
     * @Author ZX
     * @Date 21:51 2020/5/8
     * @param []
     * @return java.util.List<java.util.Map<java.lang.Integer,java.lang.Object>>
     */
    public List<List<Map<String, String>>> teachingInfo() {
        List<List<Map<String, String>>> list = new ArrayList<>();
        List<Integer> teacherIdList = teachingMapper.selectIdList("teacher_id");
        List<Integer> curriculumIdList = teachingMapper.selectIdList("curriculum_id");
        List<Integer> classIdList = teachingMapper.selectIdList("class_id");
        List<Map<String,String>> teacherName = new ArrayList<>();
        List<Map<String,String>> curriculumName = new ArrayList<>();
        List<Map<String,String>> className = new ArrayList<>();
        for(Integer id : teacherIdList){
            Map<String,String> info = new HashMap<>();
            info.put("text",teacherMapper.selectByPrimaryKey(id).getName());
            info.put("value",teacherMapper.selectByPrimaryKey(id).getName());
            teacherName.add(info);
        }
        for(Integer id : curriculumIdList){
            Map<String,String> info = new HashMap<>();
            info.put("text",curriculumMapper.selectByPrimaryKey(id).getName());
            info.put("value",curriculumMapper.selectByPrimaryKey(id).getName());
            curriculumName.add(info);
        }
        for(Integer id : classIdList){
            Map<String,String> info = new HashMap<>();
            info.put("text",classMapper.selectByPrimaryKey(id).getName());
            info.put("value",classMapper.selectByPrimaryKey(id).getName());
            className.add(info);
        }
        list.add(teacherName);
        list.add(curriculumName);
        list.add(className);
        return list;
    }


}
