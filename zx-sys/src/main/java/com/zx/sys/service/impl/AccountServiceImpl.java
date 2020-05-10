package com.zx.sys.service.impl;

import com.zx.common.enums.ResponseBean;
import com.zx.sys.dao.*;
import com.zx.sys.dto.*;
import com.zx.sys.model.*;
import com.zx.sys.model.Class;
import com.zx.sys.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author ZX
 * @Date 2020/3/24 14:19
 */
@Service
public class AccountServiceImpl implements IAccountService {


    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private NoticeLogMapper noticeLogMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private RegistrationKeyMapper registrationKeyMapper;


    @Override
    /**
     * @Author ZX
     * @Description 登录验证
     * @Date 17:00 2020/3/26
     * @param [loginInputDto]
     * option:用户身份
     * username:用户名
     * password:密码
     * flag:是否登录成功：0：密码不正确；1：用户名不存在；2：登录成功
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean login(LoginInputDto loginInputDto) {
        ResponseBean responseBean = new ResponseBean();
        Integer option = loginInputDto.getOption();
        String username = loginInputDto.getUsername();
        String password = loginInputDto.getPassword();
        Integer flag = 0;
        if(option == 1){
            Student student = studentMapper.selectByUserName(username);
            if(student != null && password.equals(student.getPassword())) {
                flag = 2;
            } else if(student == null) {
                flag = 1;
            }
        }
        else if(option == 2){
            Teacher teacher = teacherMapper.selectByUserName(username);
            if(teacher != null && password.equals(teacher.getPassword())) {
                flag = 2;
            } else if(teacher == null) {
                flag = 1;
            }
        }
        else if(option == 3){
            Admin admin = adminMapper.selectByUserName(username);
            if(admin != null && password.equals(admin.getPassword())) {
                flag = 2;
            } else if(admin == null) {
                flag = 1;
            }
        }
        if(flag == 0){
            responseBean.setCode("500");
            responseBean.setMsg("密码不正确！");
        }
        else if(flag == 1){
            responseBean.setCode("500");
            responseBean.setMsg("用户名不存在！");
        }
        else if(flag == 2){
            responseBean.setCode("200");
            responseBean.setMsg("登录成功！");
        }
        return responseBean;
    }


    @Override
    /**
     * @Author ZX
     * @Description 获取注册时的班级数据
     * @Date 15:03 2020/3/24
     * @param []
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<Integer,Class> classInfo() {
        Map<Integer,Class> info = new HashMap<>();
        ClassExample classExample = new ClassExample();
        List<Class> list = classMapper.selectByExample(classExample);
        for(Class li : list){
            info.put(li.getId(),li);
        }
        return info;
    }


    @Override
    /**
     * Description 获取班级名称数据
     * @Author ZX
     * @Date 20:13 2020/4/30
     * @param []
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    public List<Map<String,String>> className() {
        ClassExample classExample = new ClassExample();
        List<Class> list = classMapper.selectByExample(classExample);
        List<Map<String,String>> nameList = new ArrayList<>();
        for(Class li : list){
            Map<String,String> info = new HashMap<>();
            info.put("text",li.getName());
            info.put("value",li.getName());
            nameList.add(info);
        }
        return nameList;
    }


    @Override
    /**
     * @Author ZX
     * @Description 获取注册时的学院数据
     * @Date 15:03 2020/3/24
     * @param []
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<Integer, College> collegeInfo() {
        Map<Integer,College> info = new HashMap<>();
        CollegeExample collegeExample = new CollegeExample();
        List<College> list = collegeMapper.selectByExample(collegeExample);
        for(College li : list){
            info.put(li.getId(),li);
        }
        return info;
    }

    @Override
    /**
     * Description 获取学院名称数据
     * @Author ZX
     * @Date 19:56 2020/5/1
     * @param []
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String, String>> collegeName() {
        CollegeExample collegeExample = new CollegeExample();
        List<College> list = collegeMapper.selectByExample(collegeExample);
        List<Map<String,String>> nameList = new ArrayList<>();
        for(College li : list){
            Map<String,String> info = new HashMap<>();
            info.put("text",li.getName());
            info.put("value",li.getName());
            nameList.add(info);
        }
        return nameList;
    }

    @Override
    /**
     * @Author ZX
     * @Description 验证用户名是否已被注册
     * @Date 21:01 2020/3/25
     * @param [registerInputDto]
     * username:用户名
     * option:用户身份
     * flag:判断用户名是否已被注册
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean UsernameUnique(UserInfoDto userInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        String username = userInfoDto.getUsername();
        Integer option = userInfoDto.getOption();
        Integer flag = 0;
        if(option == 1){
            Student stu = studentMapper.selectByUserName(username);
            if(stu != null) {
                flag = 1;
            }
        }
        else if(option == 2){
            Teacher tea = teacherMapper.selectByUserName(username);
            if(tea != null) {
                flag = 1;
            }
        }
        else if(option == 3){
            Admin admin = adminMapper.selectByUserName(username);
            if(admin != null) {
                flag = 1;
            }
        }
        if(flag == 1){
            responseBean.setCode("101");
            responseBean.setMsg("该用户名已存在，请更换！");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 验证教师编号是否已经被注册
     * @Author ZX
     * @Date 10:56 2020/5/8
     * @param [userInfoDto]
     * username:用户名
     * option:用户身份
     * flag:判断教师编号是否已被注册
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean teacherIdUnique(UserInfoDto userInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        String teacherId = userInfoDto.getUsername();
        Integer option = userInfoDto.getOption();
        Integer flag = 0;
        if(option == 2){
            Teacher tea = teacherMapper.selectByTeacherId(teacherId);
            if(tea != null) {
                flag = 1;
            }
        }
        if(flag == 1){
            responseBean.setCode("409");
            responseBean.setMsg("该教师编号已存在，请更换！");
        }
        return responseBean;
    }

    @Override
    /**
     * @Author ZX
     * @Description 验证注册码是否正确
     * @Date 21:28 2020/3/25
     * @param [registerInputDto]
     * option:用户身份
     * key:注册码
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean checkKey(UserInfoDto userInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        Integer option = userInfoDto.getOption();
        String key = userInfoDto.getKey();
        if((option == 1 &&  !registrationKeyMapper.selectByPrimaryKey(option).getRegisterKey().equals(key))
        || (option == 2 &&  !registrationKeyMapper.selectByPrimaryKey(option).getRegisterKey().equals(key))
        || (option == 3 &&  !registrationKeyMapper.selectByPrimaryKey(option).getRegisterKey().equals(key))){
            responseBean.setCode("101");
            responseBean.setMsg("注册码不正确");
        }
        return responseBean;
    }

    @Override
    /**
     * @Author ZX
     * @Description 注册用户信息
     * @Date 22:18 2020/3/25
     * @param [registerInputDto]:注册信息
     * option:用户身份
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean register(UserInfoDto userInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        Integer option = userInfoDto.getOption();
        //注册学生信息
        if(option == 1){
            Student student = new Student();
            student.setStuId(userInfoDto.getStuId());
            student.setUsername(userInfoDto.getUsername());
            student.setPassword(userInfoDto.getPass());
            student.setGender(userInfoDto.getGender());
            student.setClassId(userInfoDto.getClassId());
            if(userInfoDto.getName() != null){
                student.setName(userInfoDto.getName());
            }
            else{
                student.setName("");
            }
            if(userInfoDto.getTel() != null){
                student.setTelephone(userInfoDto.getTel());
            }
            else{
                student.setTelephone("");
            }
            if(userInfoDto.getAddress() != null) {
                student.setAddress(userInfoDto.getAddress());
            }
            else{
                student.setAddress("");
            }
            try{
                studentMapper.insert(student);
                responseBean.setCode("200");
                responseBean.setMsg("注册成功！");
            }
            catch (Exception e){
                e.printStackTrace();
                responseBean.setCode("500");
                responseBean.setMsg("注册失败！");
                return responseBean;
            }
        }
        //注册教师信息
        else if(option == 2){
            Teacher teacher = new Teacher();
            teacher.setTeacherId(userInfoDto.getTeacherId());
            teacher.setUsername(userInfoDto.getUsername());
            teacher.setPassword(userInfoDto.getPass());
            teacher.setGender(userInfoDto.getGender());
            teacher.setCollegeId(userInfoDto.getCollegeId());
            if(userInfoDto.getName() != null) {
                teacher.setName(userInfoDto.getName());
            }
            else{
                teacher.setName("");
            }
            if(userInfoDto.getTel() != null) {
                teacher.setTelephone(userInfoDto.getTel());
            }
            else{
                teacher.setTelephone("");
            }
            try{
                teacherMapper.insert(teacher);
                responseBean.setCode("200");
                responseBean.setMsg("注册成功！");
            }
            catch (Exception e){
                e.printStackTrace();
                responseBean.setCode("500");
                responseBean.setMsg("注册失败！");
                return responseBean;
            }
        }
        //注册管理员信息
        else if(option == 3){
            Admin admin = new Admin();
            admin.setUsername(userInfoDto.getUsername());
            admin.setPassword(userInfoDto.getPass());
            admin.setName(userInfoDto.getName());
            try{
                adminMapper.insert(admin);
                responseBean.setCode("200");
                responseBean.setMsg("注册成功！");
            }
            catch (Exception e){
                e.printStackTrace();
                responseBean.setCode("500");
                responseBean.setMsg("注册失败！");
                return responseBean;
            }
        }
        return responseBean;
    }



    @Override
    /**
     * @Author ZX
     * @Description 统计当前用户未查看的公告数量
     * @Date 19:01 2020/3/27
     * @param [loginInputDto]
     * option:用户身份
     * username:用户名
     * list:获取该用户身份所有公告
     * count:当前用户收到的全部公告数量
     * logList:判断用户是否阅读过，若日志中没有记录，说明已阅读
     * deletedList:判断用户是否已经删除该公告，若日志中没有记录，说明已删除
     * @return java.lang.Integer
     */
    public Integer countNotice(LoginInputDto loginInputDto) {
        Integer option = loginInputDto.getOption();
        String username = loginInputDto.getUsername();
        List<Notice> list = noticeMapper.selectNotice(option);
        Integer count = list.size();
        NoticeLog logList = null;
        NoticeLog deletedList = null;
        for(Notice notice : list){
            if(option == 1){
                Student student = studentMapper.selectByUserName(username);
                logList = noticeLogMapper.selectStudentNoticeLog(notice.getId(),student.getId());
                deletedList = noticeLogMapper.deletedStudentNoticeLog(notice.getId(),student.getId());
            }
            else if(option == 2){
                Teacher teacher = teacherMapper.selectByUserName(username);
                logList = noticeLogMapper.selectTeacherNoticeLog(notice.getId(),teacher.getId());
                deletedList = noticeLogMapper.deletedTeacherNoticeLog(notice.getId(),teacher.getId());
            }
            else if(option == 3){
                Admin admin = adminMapper.selectByUserName(username);
                logList = noticeLogMapper.selectAdminNoticeLog(notice.getId(),admin.getId());
                deletedList = noticeLogMapper.deletedAdminNoticeLog(notice.getId(),admin.getId());
            }
            if(logList != null) {
                count--;
            } else if(deletedList != null) {
                count--;
            }
        }
        return count;
    }

    @Override
    /**
     * @Author ZX
     * @Description 获取用户公告列表
     * @Date 15:32 2020/4/7
     * @param [dataInfoDto]
     * option:用户身份
     * username:用户名
     * page:页码
     * count:每页数量
     * list:获取该用户身份所有公告
     * infoList:当前用户拥有的公告
     * noticeInfo:用户公告对象
     * logList:判断用户是否阅读过，若日志中没有记录，说明已阅读
     * deletedList:判断用户是否已经删除该公告，若日志中没有记录，说明已删除
     * @return java.util.Map<java.lang.Integer,com.zx.sys.dto.NoticeInfoDto>
     */
    public Map<String, Object> noticeInfo(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        String username = dataInfoDto.getUsername();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        //最终剩余的公告
        Integer total = 0;
        Map<String,Object> map = new HashMap<>();
        List<Notice> list = noticeMapper.selectNotice(option);
        List<NoticeInfoDto> infoList = new ArrayList<NoticeInfoDto>();
        NoticeInfoDto noticeInfo = new NoticeInfoDto();
        NoticeLog logList = null;
        NoticeLog deletedList = null;
        for(Notice no : list){
            if(option == 1){
                Student student = studentMapper.selectByUserName(username);
                logList = noticeLogMapper.selectStudentNoticeLog(no.getId(),student.getId());
                deletedList = noticeLogMapper.deletedStudentNoticeLog(no.getId(),student.getId());
            }
            else if(option == 2){
                Teacher teacher = teacherMapper.selectByUserName(username);
                logList = noticeLogMapper.selectTeacherNoticeLog(no.getId(),teacher.getId());
                deletedList = noticeLogMapper.deletedTeacherNoticeLog(no.getId(),teacher.getId());
            }
            else if(option == 3){
                Admin admin = adminMapper.selectByUserName(username);
                logList = noticeLogMapper.selectAdminNoticeLog(no.getId(),admin.getId());
                deletedList = noticeLogMapper.deletedAdminNoticeLog(no.getId(),admin.getId());
            }
//            如果当前公告已删除，则不需要添加进去
            if(deletedList == null){
                total++;
                //判断是不是当前页范围内的数据
                if(total >= (page - 1) * count && total <= page * count){
                    noticeInfo = new NoticeInfoDto();
                    noticeInfo.setId(no.getId());
                    noticeInfo.setName(noticeMapper.selectName(no.getIdentity(),no.getIdentityId()));
                    noticeInfo.setContent(no.getContent());
                    noticeInfo.setDate(no.getTime());
                    noticeInfo.setTitle(no.getTitle());
                    //若已阅读，则需要设置已阅读的状态
                    if(logList == null){
                        noticeInfo.setState(0);
                    }
                    else{
                        noticeInfo.setState(1);
                    }
                    infoList.add(noticeInfo);
                }
            }
        }
        map.put("list",infoList);
        map.put("total",total);
        return map;
    }

    @Override
    /**
     * @Author ZX
     * @Description 更改用户公告状态：将公告的状态插入公告日志中
     * @Date 17:42 2020/4/7
     * @param [noticeLogDto]
     * option:用户身份
     * state:设置公告状态
     * username:用户名
     * noticeId:公告编号
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean noticeState(NoticeLogDto noticeLogDto) {
        Integer option = noticeLogDto.getOption();
        Integer state = noticeLogDto.getState();
        String username = noticeLogDto.getUsername();
        Integer[] noticeId = noticeLogDto.getId();
        ResponseBean responseBean = new ResponseBean();
        for(Integer id : noticeId){
            NoticeLog noticeLog = new NoticeLog();
            noticeLog.setNoticeId(id);
            //根据不同身份添加不同的编号
            if(option == 1){
                Student student = studentMapper.selectByUserName(username);
                noticeLog.setStuId(student.getId());
            }
            else if(option == 2){
                Teacher teacher = teacherMapper.selectByUserName(username);
                noticeLog.setTeacherId(teacher.getId());
            }
            else if(option == 3){
                Admin admin = adminMapper.selectByUserName(username);
                noticeLog.setAdminId(admin.getId());
            }
            //设置当前公告状态为删除
            noticeLog.setState(state);
            try{
                //将删除公告的日志插入进去
                noticeLogMapper.insertSelective(noticeLog);
                responseBean.setCode("200");
                responseBean.setMsg("操作成功！");
            }
            catch (Exception e){
                e.printStackTrace();
                responseBean.setCode("500");
                responseBean.setMsg("操作失败！");
                return responseBean;
            }
        }
        return responseBean;
    }



    @Override
    /**
     * @Author ZX
     * @Description 获取用户信息
     * @Date 16:10 2020/4/17
     * @param [loginInputDto]
     * username:用户名
     * option:用户身份
     * @return com.zx.sys.dto.RegisterInputDto
     */
    public UserInfoDto userInfo(LoginInputDto loginInputDto) {
        String username = loginInputDto.getUsername();
        Integer option = loginInputDto.getOption();
        UserInfoDto userInfoDto = new UserInfoDto();
        if(option == 1){
            Student student = studentMapper.selectByUserName(username);
            userInfoDto.setId(student.getId());
            userInfoDto.setUsername(student.getUsername());
            userInfoDto.setPass(student.getPassword());
            userInfoDto.setStuId(student.getStuId());
            userInfoDto.setName(student.getName());
            userInfoDto.setGender(student.getGender());
            userInfoDto.setClassId(student.getClassId());
            userInfoDto.setAddress(student.getAddress());
            userInfoDto.setTel(student.getTelephone());
        }
        else if(option == 2){
            Teacher teacher = teacherMapper.selectByUserName(username);
            userInfoDto.setId(teacher.getId());
            userInfoDto.setTeacherId(teacher.getTeacherId());
            userInfoDto.setUsername(teacher.getUsername());
            userInfoDto.setPass(teacher.getPassword());
            userInfoDto.setName(teacher.getName());
            userInfoDto.setGender(teacher.getGender());
            userInfoDto.setTel(teacher.getTelephone());
            userInfoDto.setCollegeId(teacher.getCollegeId());
        }
        else if(option == 3){
            Admin admin = adminMapper.selectByUserName(username);
            userInfoDto.setId(admin.getId());
            userInfoDto.setUsername(admin.getUsername());
            userInfoDto.setPass(admin.getPassword());
            userInfoDto.setName(admin.getName());
        }
        return userInfoDto;
    }

    @Override
    /**
     * @Author ZX
     * @Description 更新用户信息
     * @Date 23:05 2020/4/17
     * @param [registerInputDto]
     * option:用户身份
     * username:用户名
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean updateUserInfo(UserInfoDto userInfoDto) {
        String username = userInfoDto.getUsername();
        Integer option = userInfoDto.getOption();
        ResponseBean responseBean = new ResponseBean();
        Integer state = null;
        if(option == 1){
            Student student = studentMapper.selectByUserName(username);
            try{
                state = studentMapper.updateInfo(userInfoDto,student.getId());
                responseBean.setCode(state.toString());
                responseBean.setMsg("保存成功");
            }
            catch (Exception e){
                responseBean.setCode("500");
                responseBean.setMsg("保存失败");
            }
        }
        else if(option == 2){
            Teacher teacher = teacherMapper.selectByUserName(username);
            try{
                state = teacherMapper.updateInfo(userInfoDto,teacher.getId());
                responseBean.setCode(state.toString());
                responseBean.setMsg("保存成功");
            }
            catch (Exception e){
                responseBean.setCode("500");
                responseBean.setMsg("保存失败");
            }
        }
        else if(option == 3){
            Admin admin = adminMapper.selectByUserName(username);
            try{
                state = adminMapper.updateInfo(userInfoDto,admin.getId());
                responseBean.setCode(state.toString());
                responseBean.setMsg("保存成功");
            }
            catch (Exception e){
                responseBean.setCode("500");
                responseBean.setMsg("保存失败");
            }
        }
        return responseBean;
    }

    @Override
    /**
     * @Author ZX
     * @Description 修改密码
     * @Date 20:31 2020/4/18
     * @param [registerInputDto]
     * username:用户名
     * option:用户身份
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean updatePwd(UserInfoDto userInfoDto) {
        String username = userInfoDto.getUsername();
        Integer option = userInfoDto.getOption();
        ResponseBean responseBean = new ResponseBean();
        Integer state = null;
        if(option == 1){
            Student student = studentMapper.selectByUserName(username);
            //当旧密码输入正确时，进行更改密码
            if(student.getPassword().equals(userInfoDto.getOldPass())){
                try{
                    state = studentMapper.updatePwd(userInfoDto.getPass(),student.getId());
                    responseBean.setCode(state.toString());
                    responseBean.setMsg("修改成功！");
                }
                catch (Exception e){
                    responseBean.setCode("500");
                    responseBean.setMsg("修改失败！");
                }
            }
            //当旧密码输入错误时，返回前端页面
            else{
                responseBean.setCode("400");
                responseBean.setMsg("旧密码输入错误！");
            }
        }
        else if(option == 2){
            Teacher teacher = teacherMapper.selectByUserName(username);
            //当旧密码输入正确时，进行更改密码
            if(teacher.getPassword().equals(userInfoDto.getOldPass())){
                try{
                    state = teacherMapper.updatePwd(userInfoDto.getPass(),teacher.getId());
                    responseBean.setCode(state.toString());
                    responseBean.setMsg("修改成功！");
                }
                catch (Exception e){
                    responseBean.setCode("500");
                    responseBean.setMsg("修改失败！");
                }
            }
            //当旧密码输入错误时，返回前端页面
            else{
                responseBean.setCode("400");
                responseBean.setMsg("旧密码输入错误！");
            }
        }
        else if(option == 3){
            Admin admin = adminMapper.selectByUserName(username);
            //当旧密码输入正确时，进行更改密码
            if(admin.getPassword().equals(userInfoDto.getOldPass())){
                try{
                    state = adminMapper.updatePwd(userInfoDto.getPass(),admin.getId());
                    responseBean.setCode(state.toString());
                    responseBean.setMsg("修改成功！");
                }
                catch (Exception e){
                    responseBean.setCode("500");
                    responseBean.setMsg("修改失败！");
                }
            }
            //当旧密码输入错误时，返回前端页面
            else{
                responseBean.setCode("400");
                responseBean.setMsg("旧密码输入错误！");
            }
        }
        return responseBean;
    }


}
