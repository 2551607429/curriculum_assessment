package com.zx.sys.service.impl;

import com.zx.common.enums.ResponseBean;
import com.zx.sys.dao.*;
import com.zx.sys.dto.*;
import com.zx.sys.model.*;
import com.zx.sys.model.Class;
import com.zx.sys.service.IAssessManageService;
import com.zx.utils.UtilInteger;
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
    private TeacherMapper teacherMapper;

    @Autowired
    private QuestionTypeMapper questionTypeMapper;

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private ChapterMapper chapterMapper ;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private KnowledgeMapper knowledgeMapper;


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

    @Override
    /**
     * Description 增加题库题目信息
     * @Author ZX
     * @Date 21:49 2020/5/11
     * @param [question]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean addQuestion(QuestionInfoDto questionInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Question question = new Question();
            question.setTypeId(questionInfoDto.getTypeId());
            question.setStem(questionInfoDto.getStem());
            if(questionInfoDto.getOptionA() != null){
                question.setOptionA(questionInfoDto.getOptionA());
            }
            else{
                question.setOptionA("");
            }
            if(questionInfoDto.getOptionB() != null) {
                question.setOptionB(questionInfoDto.getOptionB());
            }
            else{
                question.setOptionB("");
            }
            if(questionInfoDto.getOptionC() != null) {
                question.setOptionC(questionInfoDto.getOptionC());
            }
            else{
                question.setOptionC("");
            }
            if(questionInfoDto.getOptionD() != null) {
                question.setOptionD(questionInfoDto.getOptionD());
            }
            else{
                question.setOptionD("");
            }
            question.setAnswer(questionInfoDto.getAnswer());
            if(questionInfoDto.getKeyword() != null) {
                question.setKeyword(questionInfoDto.getKeyword());
            }
            else{
                question.setKeyword("");
            }
            question.setCurriculumId(questionInfoDto.getCurriculumId());
            question.setChapterId(questionInfoDto.getChapterId());
            question.setDifficulty(questionInfoDto.getDifficulty());
            questionMapper.insertSelective(question);
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
     * Description 批量上传题库题目信息
     * @Author ZX
     * @Date 21:50 2020/5/11
     * @param [list]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean uploadQuestion(List<QuestionInfoDto> list) {
        return null;
    }

    @Override
    /**
     * Description 删除题库题目信息
     * @Author ZX
     * @Date 21:51 2020/5/11
     * @param [dataInfoDto]
     * option:用户身份
     * questionId:需要删除的题库题目编号
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean deleteQuestion(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] questionId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 2){
            for(Integer id : questionId){
                questionMapper.deleteByPrimaryKey(id);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取题库题目信息
     * @Author ZX
     * @Date 21:52 2020/5/11
     * @param [dataInfoDto]
     * option:用户身份
     * page:页码
     * count:每页数量
     * list:获取所选页面的题库列表
     * map:页面题库信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> questionInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        List<Question> list = new ArrayList<>();
        List<QuestionInfoDto> questionList = new ArrayList<>();
        //当是管理员时
        if(option == 3){
            QuestionExample questionExample = new QuestionExample();
            //查询当前页面显示的题库题目列表
            list = questionMapper.selectPagination(page,count);
            map.put("total",questionMapper.countByExample(questionExample));
        }
        //当时教师时
        else if(option == 2){
            Teacher teacher = teacherMapper.selectByUserName(dataInfoDto.getUsername());
            Date date = new Date();
            //查询当前页面显示的自己任课信息的题库题目列表
            list = questionMapper.selectPaginByTeach(date,teacher.getId(),page,count);
            questionList = new ArrayList<>();
            map.put("total",questionMapper.countByTeacher(teacher.getId()));
        }
        //对每个题库题目信息增加内容
        for (Question question : list) {
            QuestionInfoDto value = new QuestionInfoDto();
            value.setId(question.getId());
            value.setTypeId(question.getTypeId());
            value.setTypeName(questionTypeMapper.selectByPrimaryKey(question.getTypeId()).getName());
            value.setStem(question.getStem());
            value.setOptionA(question.getOptionA());
            value.setOptionB(question.getOptionB());
            value.setOptionC(question.getOptionC());
            value.setOptionD(question.getOptionD());
            value.setAnswer(question.getAnswer());
            value.setKeyword(question.getKeyword());
            value.setCurriculumId(question.getCurriculumId());
            value.setCurriculumName(curriculumMapper.selectByPrimaryKey(question.getCurriculumId()).getName());
            value.setChapterId(question.getChapterId());
            value.setChapterName(chapterMapper.selectByPrimaryKey(question.getChapterId()).getName());
            value.setDifficulty(question.getDifficulty());
            questionList.add(value);
        }
        map.put("list",questionList);
        return map;
    }

    @Override
    /**
     * Description 修改题库题目信息
     * @Author ZX
     * @Date 21:52 2020/5/11
     * @param [question]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean editQuestion(QuestionInfoDto questionInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        try {
            questionMapper.updateByInfo(questionInfoDto,questionInfoDto.getId());
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
     * Description 获取所有的题目类型信息
     * @Author ZX
     * @Date 16:53 2020/5/12
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.QuestionType>
     */
    public Map<Integer, QuestionType> typeInfo() {
        Map<Integer, QuestionType> info = new HashMap<>();
        QuestionTypeExample questionTypeExample = new QuestionTypeExample();
        List<QuestionType> list = questionTypeMapper.selectByExample(questionTypeExample);
        for(QuestionType qu : list){
            info.put(qu.getId(),qu);
        }
        return info;
    }

    @Override
    /**
     * Description 获取所有的题目章节信息
     * @Author ZX
     * @Date 17:04 2020/5/12
     * @param []
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Chapter>
     */
    public Map<Integer, Chapter> chapterInfo() {
        Map<Integer, Chapter> info = new HashMap<>();
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> list = chapterMapper.selectByExample(chapterExample);
        for(Chapter ch : list){
            info.put(ch.getId(),ch);
        }
        return info;
    }


    @Override
    /**
     * Description 获取自己任课的所有班级信息
     * @Author ZX
     * @Date 14:43 2020/5/13
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Class>
     */
    public Map<Integer, Class> classInfo(DataInfoDto dataInfoDto) {
        Map<Integer,Class> info = new HashMap<>();
        List<Class> list = new ArrayList<>();
        //当是教师时，只能获取自己任课的班级
        if(dataInfoDto.getOption() == 2){
            Teacher teacher = teacherMapper.selectByUserName(dataInfoDto.getUsername());
            list = classMapper.selectByTeacher(teacher.getId());
        }
        else if(dataInfoDto.getOption() == 1 || dataInfoDto.getOption() == 3){
            ClassExample classExample = new ClassExample();
            list = classMapper.selectByExample(classExample);
        }
        for(Class li : list){
            info.put(li.getId(),li);
        }
        return info;
    }

    @Override
    /**
     * Description 增加考试信息
     * @Author ZX
     * @Date 21:43 2020/5/12
     * @param [examInfoDto]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean addExam(ExamInfoDto examInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Exam exam = new Exam();
            exam.setName(examInfoDto.getName());
            exam.setEndTime(examInfoDto.getEndTime());
            exam.setStartTime(examInfoDto.getStartTime());
            exam.setTotalScore(examInfoDto.getTotalScore());
            exam.setDifficulty(examInfoDto.getDifficulty());
            exam.setExamRange(examInfoDto.getExamRange());
            exam.setCurriculumId(examInfoDto.getCurriculumId());
            if(examInfoDto.getClassRange() != null){
                exam.setClassRange(examInfoDto.getClassRange());
            }
            else{
                exam.setClassRange("");
            }
            examMapper.insertSelective(exam);
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
     * Description 删除考试信息
     * @Author ZX
     * @Date 21:43 2020/5/12
     * @param [dataInfoDto]
     * option:用户身份
     * examId:需要删除的考试编号
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean deleteExam(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer [] examId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if(option == 2){
            for(Integer id : examId){
                examMapper.deleteByPrimaryKey(id);
                responseBean.setCode("200");
                responseBean.setMsg("删除成功");
            }
        }
        return responseBean;
    }

    @Override
    /**
     * Description 分页获取考试信息
     * @Author ZX
     * @Date 21:44 2020/5/12
     * @param [dataInfoDto]
     * option:用户身份
     * page:页码
     * count:每页数量
     * list:获取所选页面的考试列表
     * map:页面题库信息
     * regexClass:分割班级范围的正则表达式
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> examInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String,Object> map = new HashMap<>();
        String regexClass = ";|；|\\s+";
        if(option == 2){
            ExamExample examExample = new ExamExample();
            Teacher teacher = teacherMapper.selectByUserName(dataInfoDto.getUsername());
            Date date = new Date();
            //查询当前页面显示的考试列表
            List<Exam> list = examMapper.selectPaginByteach(date,teacher.getId(),page,count);
            List<ExamInfoDto> examList = new ArrayList<>();
            //对每个题库题目信息增加内容
            for (Exam exam : list) {
                ExamInfoDto value = new ExamInfoDto();
                value.setId(exam.getId());
                value.setName(exam.getName());
                value.setStartTime(exam.getStartTime());
                value.setEndTime(exam.getEndTime());
                value.setTotalScore(exam.getTotalScore());
                value.setDifficulty(exam.getDifficulty());
                value.setExamRange(exam.getExamRange());
                value.setClassRange(exam.getClassRange());
                //当班级范围不空时，通过中英文；和空格进行分割 获取到班级的编号
                if(exam.getClassRange() != null){
                    String[] strings = exam.getClassRange().split(regexClass);
                    Integer[] classId = new Integer[strings.length];
                    StringBuilder className = new StringBuilder();
                    for(int i = 0;i < strings.length;i ++){
                        classId[i] = UtilInteger.parseInt(strings[i]);
                        //获取该班级的名称并追加
                        className.append(classMapper.selectByPrimaryKey(classId[i]).getName());
                        className.append("；");
                    }
                    value.setClassIdRange(classId);
                    value.setClassNameRange(className.toString());
                }
                value.setCurriculumId(exam.getCurriculumId());
                value.setCurriculumName(curriculumMapper.selectByPrimaryKey(exam.getCurriculumId()).getName());
                examList.add(value);
            }
            map.put("list",examList);
            map.put("total",examMapper.countByExample(examExample));
            return map;
        }
        else{
            return null;
        }
    }

    @Override
    /**
     * Description 修改考试信息
     * @Author ZX
     * @Date 21:44 2020/5/12
     * @param [examInfoDto]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean editExam(ExamInfoDto examInfoDto) {
        ResponseBean responseBean = new ResponseBean();
        try {
            examMapper.updateByInfo(examInfoDto,examInfoDto.getId());
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
     * Description 查询课程的各个题型的问题数量
     * @Author ZX
     * @Date 19:29 2020/5/13
     * @param [dataInfoDto]
     * curriculumId:课程编号
     * @return java.util.Map<java.lang.Integer,com.zx.sys.model.Class>
     */
    public Map<Integer, Integer> questionCountByType(DataInfoDto dataInfoDto) {
        Integer curriculumId = dataInfoDto.getCurriculum();
        Map<Integer,Integer> info = new HashMap<>();
        QuestionTypeExample questionTypeExample = new QuestionTypeExample();
        List<QuestionType> typeList = questionTypeMapper.selectByExample(questionTypeExample);
        //将每个题型遍历一遍
        for(QuestionType type : typeList){
            info.put(type.getId(),questionMapper.countByCurriculum(curriculumId,type.getId()));
        }
        return info;
    }

}
