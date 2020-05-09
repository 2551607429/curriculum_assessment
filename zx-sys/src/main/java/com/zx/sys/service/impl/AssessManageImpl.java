package com.zx.sys.service.impl;

import com.dsa.common.enums.ResponseBean;
import com.zx.sys.dao.*;
import com.zx.sys.dto.*;
import com.zx.sys.model.*;
import com.zx.sys.service.IAccountService;
import com.zx.sys.service.IAssessManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName AssessManageImpl
 * @Description  考核管理 和 成员管理 接口功能实现
 * @Author ZX
 * @Date 2020/4/20 23:29
 */
@Service
public class AssessManageImpl implements IAssessManageService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private QuestionTypeMapper questionTypeMapper;

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private ChapterMapper chapterMapper ;


    @Override
    /**
     * @Author ZX
     * @Description 获取题型初始化信息
     * @Date 23:36 2020/4/20
     * @param [loginInputDto]
     * username: 用户名
     * option:用户身份
     * @return com.zx.sys.model.QuestionType
     */
    public List<QuestionType> typeInit(LoginInputDto loginInputDto) {
        String username = loginInputDto.getUsername();
        Integer option = loginInputDto.getOption();
        List<QuestionType> list = new ArrayList<>();
        if(option == 3){
            Admin admin = adminMapper.selectByUserName(username);
            if(admin != null){
                QuestionTypeExample example = new QuestionTypeExample();
                list = questionTypeMapper.selectByExample(example);
            }
        }
        return list;
    }

    @Override
    /**
     * Description 增加题型
     * @Author ZX
     * @Date 23:38 2020/4/22
     * @param [questionType]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addType(QuestionType questionType) {
        ResponseBean responseBean = new ResponseBean();
        try {
            questionTypeMapper.insertSelective(questionType);
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
     * Description 删除题型
     * @Author ZX
     * @Date 16:44 2020/4/26
     * @param [dataInfoDto]
     * option:用户身份
     * typeId:需要删除的题型编号
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteType(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] typeId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 3){
            for(Integer id : typeId){
                questionTypeMapper.deleteByPrimaryKey(id);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        return responseBean;
    }

    @Override
    /**
     * Description 修改题型
     * @Author ZX
     * @Date 23:22 2020/4/25
     * @param [questionType]
     * id:需要修改的题型编号
     * name:修改后的题型名称
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editType(QuestionType questionType) {
        ResponseBean responseBean = new ResponseBean();
        try {
            questionTypeMapper.updateByPrimaryKey(questionType);
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
     * Description 增加课程信息
     * @Author ZX
     * @Date 22:57 2020/4/26
     * @param [curriculum]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addCurriculum(Curriculum curriculum) {
        ResponseBean responseBean = new ResponseBean();
        try {
            curriculumMapper.insertSelective(curriculum);
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
     * Description 批量上传课程信息
     * @Author ZX
     * @Date 22:21 2020/4/28
     * @param [list]
     * responseBean:返回的信息
     * res:添加列表中每个课程信息的返回信息
     * successCount:成功上传数量
     * failCount:失败上传数量
     * upload:上传数据对象
     * failList:失败上传列表
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean uploadCurriculum(List<Curriculum> list) {
        ResponseBean responseBean = new ResponseBean();
        ResponseBean res;
        Integer successCount = 0;
        Integer failCount = 0;
        UploadInfoDto upload = new UploadInfoDto();
        List<Curriculum> failList = new ArrayList<>();
        try {
            for(Curriculum curr : list){
                res = addCurriculum(curr);
                if("200".equals(res.getCode())) {
                    successCount++;
                }
                else{
                    failCount++;
                    failList.add(curr);
                }
            }
            upload.setAllCount(list.size());
            upload.setFailCount(failCount);
            upload.setSuccessCount(successCount);
            upload.setResponseList(Collections.singletonList(failList));
            responseBean.setCode("200");
            responseBean.setData(upload);
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
     * Description 删除课程信息
     * @Author ZX
     * @Date 23:02 2020/4/26
     * @param [dataInfoDto]
     * option:用户身份
     * curriculumId:需要删除的课程编号
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteCurriculum(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] curriculumId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 3 || option == 2){
            for(Integer id : curriculumId){
                curriculumMapper.deleteByPrimaryKey(id);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        return responseBean;
    }


    @Override
    /**
     * Description 分页获取课程信息
     * @Author ZX
     * @Date 20:34 2020/4/26
     * @param [dataInfoDto]
     * option:用户身份
     * page:页码
     * count:每页数量
     * list:获取所选页面的课程列表
     * map:页面课程信息
     * @return java.util.List<com.zx.sys.model.Curriculum>
     */
    public Map<String,Object> curriculumInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        if(option == 3){
            CurriculumExample curriculumExample = new CurriculumExample();
            //查询当前页面显示的课程列表
            List<Curriculum> list = curriculumMapper.selectPagination(page,count);
            map.put("list",list);
            map.put("total",curriculumMapper.countByExample(curriculumExample));
            return map;
        }
        else{
            return null;
        }
    }

    @Override
    /**
     * Description 修改课程信息
     * @Author ZX
     * @Date 22:18 2020/4/26
     * @param [curriculum]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editCurriculum(Curriculum curriculum) {
        ResponseBean responseBean = new ResponseBean();
        try {
            curriculumMapper.updateByPrimaryKey(curriculum);
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
     * Description 增加章节
     * @Author ZX
     * @Date 17:21 2020/4/29
     * @param [chapter]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean addChapter(Chapter chapter) {
        ResponseBean responseBean = new ResponseBean();
        try {
            chapterMapper.insertSelective(chapter);
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
     * Description 删除章节信息
     * @Author ZX
     * @Date 17:20 2020/4/29
     * @param [dataInfoDto]
     * option:用户身份
     * chapterId:需要删除的章节编号
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean deleteChapter(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] chapterId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 3){
            for(Integer id : chapterId){
                chapterMapper.deleteByPrimaryKey(id);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取章节信息
     * @Author ZX
     * @Date 17:20 2020/4/29
     * @param [dataInfoDto]
     * option:用户身份
     * page:页码
     * count:每页数量
     * list:获取所选页面的章节列表
     * map:页面章节信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> chapterInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        if(option == 3){
            ChapterExample chapterExample = new ChapterExample();
            //查询当前页面显示的章节列表
            List<Chapter> list = chapterMapper.selectPagination(page,count);
            map.put("list",list);
            map.put("total",chapterMapper.countByExample(chapterExample));
            return map;
        }
        else{
            return null;
        }
    }

    @Override
    /**
     * Description 修改章节信息
     * @Author ZX
     * @Date 17:20 2020/4/29
     * @param [chapter]
     * @return com.dsa.common.enums.ResponseBean
     */
    public ResponseBean editChapter(Chapter chapter) {
        ResponseBean responseBean = new ResponseBean();
        try {
            chapterMapper.updateByPrimaryKey(chapter);
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
