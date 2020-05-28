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
    private StudentMapper studentMapper;

    @Autowired
    private QuestionTypeMapper questionTypeMapper;

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private AnswerPaperMapper answerPaperMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Autowired
    private AchievementMapper achievementMapper;


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
        if (option == 3) {
            Admin admin = adminMapper.selectByUserName(username);
            if (admin != null) {
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
        Integer[] typeId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if (option == 3) {
            for (Integer id : typeId) {
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
            for (Curriculum curr : list) {
                res = addCurriculum(curr);
                if ("200".equals(res.getCode())) {
                    successCount++;
                } else {
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
        Integer[] curriculumId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if (option == 3 || option == 2) {
            for (Integer id : curriculumId) {
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
    public Map<String, Object> curriculumInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String, Object> map = new HashMap<>();
        if (option == 3) {
            CurriculumExample curriculumExample = new CurriculumExample();
            //查询当前页面显示的课程列表
            List<Curriculum> list = curriculumMapper.selectPagination(page, count);
            map.put("list", list);
            map.put("total", curriculumMapper.countByExample(curriculumExample));
            return map;
        } else {
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
        Integer[] chapterId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if (option == 3) {
            for (Integer id : chapterId) {
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
     * @return java.util.Map<java.lang.String, java.lang.Object>
     */
    public Map<String, Object> chapterInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String, Object> map = new HashMap<>();
        if (option == 3) {
            ChapterExample chapterExample = new ChapterExample();
            //查询当前页面显示的章节列表
            List<Chapter> list = chapterMapper.selectPagination(page, count);
            map.put("list", list);
            map.put("total", chapterMapper.countByExample(chapterExample));
            return map;
        } else {
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
            if (questionInfoDto.getOptionA() != null) {
                question.setOptionA(questionInfoDto.getOptionA());
            } else {
                question.setOptionA("");
            }
            if (questionInfoDto.getOptionB() != null) {
                question.setOptionB(questionInfoDto.getOptionB());
            } else {
                question.setOptionB("");
            }
            if (questionInfoDto.getOptionC() != null) {
                question.setOptionC(questionInfoDto.getOptionC());
            } else {
                question.setOptionC("");
            }
            if (questionInfoDto.getOptionD() != null) {
                question.setOptionD(questionInfoDto.getOptionD());
            } else {
                question.setOptionD("");
            }
            question.setAnswer(questionInfoDto.getAnswer());
            if (questionInfoDto.getKeyword() != null) {
                question.setKeyword(questionInfoDto.getKeyword());
            } else {
                question.setKeyword("");
            }
            question.setCurriculumId(questionInfoDto.getCurriculumId());
            question.setChapterId(questionInfoDto.getChapterId());
            question.setDifficulty(questionInfoDto.getDifficulty());
            questionMapper.insertSelective(question);
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
        Integer[] questionId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if (option == 2) {
            for (Integer id : questionId) {
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
     * @return java.util.Map<java.lang.String, java.lang.Object>
     */
    public Map<String, Object> questionInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String, Object> map = new HashMap<>();
        List<Question> list = new ArrayList<>();
        List<QuestionInfoDto> questionList = new ArrayList<>();
        //当是管理员时
        if (option == 3) {
            QuestionExample questionExample = new QuestionExample();
            //查询当前页面显示的题库题目列表
            list = questionMapper.selectPagination(page, count);
            map.put("total", questionMapper.countByExample(questionExample));
        }
        //当时教师时
        else if (option == 2) {
            Teacher teacher = teacherMapper.selectByUserName(dataInfoDto.getUsername());
            Date date = new Date();
            //查询当前页面显示的自己任课信息的题库题目列表
            list = questionMapper.selectPaginByTeach(date, teacher.getId(), page, count);
            questionList = new ArrayList<>();
            map.put("total", questionMapper.countByTeacher(teacher.getId()));
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
        map.put("list", questionList);
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
            questionMapper.updateByInfo(questionInfoDto, questionInfoDto.getId());
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
     * @return java.util.Map<java.lang.Integer, com.zx.sys.model.QuestionType>
     */
    public Map<Integer, QuestionType> typeInfo() {
        Map<Integer, QuestionType> info = new HashMap<>();
        QuestionTypeExample questionTypeExample = new QuestionTypeExample();
        List<QuestionType> list = questionTypeMapper.selectByExample(questionTypeExample);
        for (QuestionType qu : list) {
            info.put(qu.getId(), qu);
        }
        return info;
    }

    @Override
    /**
     * Description 获取所有的题目章节信息
     * @Author ZX
     * @Date 17:04 2020/5/12
     * @param []
     * @return java.util.Map<java.lang.Integer, com.zx.sys.model.Chapter>
     */
    public Map<Integer, Chapter> chapterInfo() {
        Map<Integer, Chapter> info = new HashMap<>();
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> list = chapterMapper.selectByExample(chapterExample);
        for (Chapter ch : list) {
            info.put(ch.getId(), ch);
        }
        return info;
    }


    @Override
    /**
     * Description 获取自己任课的所有班级信息
     * @Author ZX
     * @Date 14:43 2020/5/13
     * @param [dataInfoDto]
     * @return java.util.Map<java.lang.Integer, com.zx.sys.model.Class>
     */
    public Map<Integer, Class> classInfo(DataInfoDto dataInfoDto) {
        Map<Integer, Class> info = new HashMap<>();
        List<Class> list = new ArrayList<>();
        //当是教师时，只能获取自己当前任课的班级
        if (dataInfoDto.getOption() == 2) {
            Date date = new Date();
            Teacher teacher = teacherMapper.selectByUserName(dataInfoDto.getUsername());
            if (dataInfoDto.getCurriculum() == null || "".equals(dataInfoDto.getCurriculum())) {
                list = classMapper.selectByTeacher(teacher.getId(), date);
            } else {
                list = classMapper.selectByCurriculum(teacher.getId(), date, dataInfoDto.getCurriculum());
            }
        } else if (dataInfoDto.getOption() == 1 || dataInfoDto.getOption() == 3) {
            ClassExample classExample = new ClassExample();
            list = classMapper.selectByExample(classExample);
        }
        for (Class li : list) {
            info.put(li.getId(), li);
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
            exam.setEndTime(examInfoDto.getExamTime().get(1));
            exam.setStartTime(examInfoDto.getExamTime().get(0));
            exam.setTotalScore(examInfoDto.getTotalScore());
            exam.setDifficulty(examInfoDto.getDifficulty());
            exam.setExamRange(examInfoDto.getExamRange());
            exam.setCurriculumId(examInfoDto.getCurriculumId());
            //当参加考试班级范围为 自己选择的班级
            if (examInfoDto.getExamRange() == 2) {
                StringBuilder classId = new StringBuilder();
                for (Integer id : examInfoDto.getClassIdRange()) {
                    classId.append(id);
                    classId.append(";");
                }
                exam.setClassRange(classId.toString());
            }
            //当参加考试班级范围为 全部任课学生
            else {
                Date date = new Date();
                Teacher teacher = teacherMapper.selectByUserName(examInfoDto.getUsername());
                List<Class> classList = classMapper.selectByCurriculum(teacher.getId(), date, examInfoDto.getCurriculumId());
                StringBuilder classId = new StringBuilder();
                Integer[] cla = new Integer[classList.size()];
                for (int i = 0;i < classList.size();i ++) {
                    Class value = classList.get(i);
                    cla[i] = value.getId();
                    classId.append(value.getId());
                    classId.append(";");
                }
                examInfoDto.setClassIdRange(cla);
                exam.setClassRange(classId.toString());
            }
            int count = examMapper.insertSelective(exam);
            // 获取到的即为新插入记录的ID
            examInfoDto.setId(exam.getId());
            // 创建试卷
            if ("200".equals(addPaper(examInfoDto).getCode())) {
                responseBean.setCode("200");
                responseBean.setMsg("增加成功");
            } else {
                responseBean.setCode("500");
                responseBean.setMsg("增加失败");
            }
        } catch (Exception e) {
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
        Integer[] examId = dataInfoDto.getId();
        ResponseBean responseBean = new ResponseBean();
        if (option == 2) {
            for (Integer id : examId) {
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
     * @return java.util.Map<java.lang.String, java.lang.Object>
     */
    public Map<String, Object> examInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        Map<String, Object> map = new HashMap<>();
        String regexClass = ";|；|\\s+";
        //当为教师时
        if (option == 2) {
            ExamExample examExample = new ExamExample();
            Teacher teacher = teacherMapper.selectByUserName(dataInfoDto.getUsername());
            Date date = new Date();
            //查询当前页面显示的考试列表
            List<Exam> list = examMapper.selectPaginByteach(date, teacher.getId(), page, count);
            List<ExamInfoDto> examList = new ArrayList<>();
            //对每个考试信息增加内容
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
                if (exam.getClassRange() != null && !"".equals(exam.getClassRange())) {
                    String[] strings = exam.getClassRange().split(regexClass);
                    Integer[] classId = new Integer[strings.length];
                    StringBuilder className = new StringBuilder();
                    for (int i = 0; i < strings.length; i++) {
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
            map.put("list", examList);
            map.put("total", examMapper.countByExample(examExample));
            return map;
        }
        else if(option == 1){
            ExamExample examExample = new ExamExample();
            Student student = studentMapper.selectByUserName(dataInfoDto.getUsername());
            Date date = new Date();
            List<Exam> list = new ArrayList<>();
            //当需要获取当前尚未考试信息时
            if(dataInfoDto.getKey() == 1){
                //查询当前页面显示的考试列表
                list = examMapper.unSelectPaginByStudent(date, student.getClassId(), page, count);
            }
            else if(dataInfoDto.getKey() == 2){
                list = examMapper.SelectPaginByStudent(date, student.getClassId(), page, count);
            }
            List<ExamInfoDto> examList = new ArrayList<>();
            //对每个考试信息增加内容
            for (Exam exam : list) {
                ExamInfoDto value = new ExamInfoDto();
                //判断该考试中是否包含自己所在的班级 ： false:不包含；true:包含
                boolean flag = false;
                value.setId(exam.getId());
                value.setName(exam.getName());
                value.setStartTime(exam.getStartTime());
                value.setEndTime(exam.getEndTime());
                value.setTotalScore(exam.getTotalScore());
                value.setDifficulty(exam.getDifficulty());
                value.setExamRange(exam.getExamRange());
                value.setClassRange(exam.getClassRange());
                //通过中英文；和空格进行分割 获取到班级的编号
                String[] strings = exam.getClassRange().split(regexClass);
                Integer[] classId = new Integer[strings.length];
                StringBuilder className = new StringBuilder();
                for (int i = 0; i < strings.length; i++) {
                    classId[i] = UtilInteger.parseInt(strings[i]);
                    //当包含自己所在班级时
                    if(classId[i].equals(student.getClassId())){
                        flag = true;
                    }
                    //获取该班级的名称并追加
                    className.append(classMapper.selectByPrimaryKey(classId[i]).getName());
                    className.append("；");
                }
                //当不包含自己所在班级的时候，不添加该考试
                if(!flag){
                    continue;
                }
                value.setClassIdRange(classId);
                value.setClassNameRange(className.toString());
                value.setCurriculumId(exam.getCurriculumId());
                value.setCurriculumName(curriculumMapper.selectByPrimaryKey(exam.getCurriculumId()).getName());
                if(dataInfoDto.getKey() == 2){
                    AchievementKey key = new AchievementKey();
                    key.setStudentId(student.getId());
                    key.setExamId(exam.getId());
                    Achievement achievement = achievementMapper.selectByPrimaryKey(key);
                    if(achievement != null){
                        value.setStuTotalScore(achievement.getScore());
                    }
                }
                examList.add(value);
            }
            map.put("list", examList);
            map.put("total", examMapper.countByExample(examExample));
            return map;
        }
        else {
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
        examInfoDto.setStartTime(examInfoDto.getExamTime().get(0));
        examInfoDto.setEndTime(examInfoDto.getExamTime().get(1));
        try {
            examMapper.updateByInfo(examInfoDto, examInfoDto.getId());
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
     * @return java.util.Map<java.lang.Integer, com.zx.sys.model.Class>
     */
    public Map<Integer, Integer> questionCountByType(DataInfoDto dataInfoDto) {
        Integer curriculumId = dataInfoDto.getCurriculum();
        Map<Integer, Integer> info = new HashMap<>();
        QuestionTypeExample questionTypeExample = new QuestionTypeExample();
        List<QuestionType> typeList = questionTypeMapper.selectByExample(questionTypeExample);
        //将每个题型遍历一遍
        for (QuestionType type : typeList) {
            info.put(type.getId(), questionMapper.countByCurriculum(curriculumId, type.getId()));
        }
        return info;
    }

    @Override
    /**
     * Description 增加试卷题目
     * @Author ZX
     * @Date 16:29 2020/5/17
     * @param [examInfoDto]
     * username 用户名
     * option 用户身份
     * difficulty 试卷难度
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean addPaper(ExamInfoDto examInfoDto) {
        String username = examInfoDto.getUsername();
        Integer option = examInfoDto.getOption();
        Float difficulty = examInfoDto.getDifficulty();
        ResponseBean responseBean = new ResponseBean();
        Date date = new Date();
        try {
            if (option == 2) {
                Teacher teacher = teacherMapper.selectByUserName(username);
                //教师编号
                Integer teacherId = teacher.getId();
                //获取需要参加考试的学生
                List<Integer> stuIdList = studentMapper.selectByClassList(examInfoDto.getClassIdRange());
                for (ExamTypeInfoDto type : examInfoDto.getTypeList()) {
                    //随机产生指定数量的题目
                    List<Integer> idList = questionMapper.selectAllByType(date, teacherId,
                            type.getTypeId(), difficulty, type.getCount());
                    for (Integer stuId : stuIdList) {
                        for (Integer quesId : idList) {
                            AnswerPaper answerPaper = new AnswerPaper();
                            answerPaper.setExamId(examInfoDto.getId());
                            answerPaper.setQuestionId(quesId);
                            answerPaper.setStuId(stuId);
                            answerPaper.setScore(type.getScore());
                            answerPaperMapper.insertSelective(answerPaper);
                        }
                    }
                }
                responseBean.setCode("200");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setCode("500");
        }
        return responseBean;
    }

    @Override
    /**
     * Description 加载试卷
     * @Author ZX
     * @Date 19:58 2020/5/18
     * @param [examInfoDto]
     * username 用户名
     * option 用户身份
     * examId 考试编号
     * regexAnswer 分割答案的正则表达式
     * list 试卷题目
     * @return java.util.List<com.zx.sys.dto.PaperInfoDto>
     */
    public List<PaperInfoDto> paperInit(ExamInfoDto examInfoDto) {
        String username = examInfoDto.getUsername();
        Integer option = examInfoDto.getOption();
        Integer examId = examInfoDto.getId();
        String regexAnswer = ";|；|\\s+";
        List<PaperInfoDto> list = new ArrayList<>();
        if(option == 1){
            Student student = studentMapper.selectByUserName(username);
            List<AnswerPaper> paperList = answerPaperMapper.selectPaperStu(student.getId(),examId);
            //加载 试卷信息
            for(AnswerPaper paper : paperList){
                PaperInfoDto info = new PaperInfoDto();
                Question question = questionMapper.selectByPrimaryKey(paper.getQuestionId());
                info.setScore(paper.getScore());
                info.setStuId(student.getId());
                info.setExamId(examId);
                info.setExamName(examMapper.selectByPrimaryKey(examId).getName());
                info.setName(student.getName());
                info.setStartTime(examMapper.selectByPrimaryKey(examId).getStartTime());
                info.setEndTime(examMapper.selectByPrimaryKey(examId).getEndTime());
                info.setOptionA(question.getOptionA());
                info.setOptionB(question.getOptionB());
                info.setOptionC(question.getOptionC());
                info.setOptionD(question.getOptionD());
                info.setQuestionId(question.getId());
                info.setStem(question.getStem());
                info.setAnswer(question.getAnswer());
                info.setAnswerList(Arrays.asList(info.getAnswer().split(regexAnswer)));
                info.setCheckList(Collections.singletonList(""));
                info.setTypeId(question.getTypeId());
                info.setTypeName(questionTypeMapper.selectByPrimaryKey(question.getTypeId()).getName());
                list.add(info);
            }
            return list;
        }
        else if(option == 2){
            Integer stuId = examInfoDto.getStuId();
            Student student = studentMapper.selectByPrimaryKey(stuId);
            List<AnswerPaper> paperList = answerPaperMapper.selectPaperStu(stuId,examId);
            AchievementKey key = new AchievementKey();
            key.setExamId(examId);
            key.setStudentId(stuId);
            Achievement achievement = achievementMapper.selectByPrimaryKey(key);
            //加载试卷信息
            for(AnswerPaper paper : paperList){
                PaperInfoDto info = new PaperInfoDto();
                Question question = questionMapper.selectByPrimaryKey(paper.getQuestionId());
                info.setScore(paper.getScore());
                info.setStuScore(paper.getStuScore());
                info.setStuAnswer(paper.getStuAnswer());
                if(paper.getStuAnswer() != null){
                    if(question.getTypeId() == 2 || question.getTypeId() == 7){
                        info.setCheckList(Arrays.asList(paper.getStuAnswer().split(regexAnswer)));
                    }
                    else if(question.getTypeId() == 5){
                        char[] ch = paper.getStuAnswer().toCharArray();
                        List<String> str = new ArrayList<>();
                        for(char value : ch){
                            str.add(String.valueOf(value));
                        }
                        info.setCheckList(str);
                    }
                    else{
                        info.setStuAnswerList(Arrays.asList(paper.getStuAnswer().split(regexAnswer)));
                    }
                }
                info.setStuId(stuId);
                info.setStudentId(student.getStuId());
                info.setClassName(classMapper.selectByPrimaryKey(student.getClassId()).getName());
                info.setExamId(examId);
                info.setExamName(examMapper.selectByPrimaryKey(examId).getName());
                info.setTotalScore(examMapper.selectByPrimaryKey(examId).getTotalScore());
                info.setName(student.getName());
                info.setOptionA(question.getOptionA());
                info.setOptionB(question.getOptionB());
                info.setOptionC(question.getOptionC());
                info.setOptionD(question.getOptionD());
                info.setQuestionId(question.getId());
                info.setStem(question.getStem());
                info.setAnswer(question.getAnswer());
                info.setAnswerList(Arrays.asList(info.getAnswer().split(regexAnswer)));
                info.setTypeId(question.getTypeId());
                info.setTypeName(questionTypeMapper.selectByPrimaryKey(question.getTypeId()).getName());
                if(paper.getStuScore() != null){
                    if(paper.getStuScore() == 0){
                        info.setResult(0);
                    }
                    else{
                        info.setResult(1);
                    }
                }
                info.setStuTotalScore(achievement.getScore());
                list.add(info);
            }
            return list;
        }
        return null;
    }

    @Override
    /**
     * Description 学生提交试卷
     * @Author ZX
     * @Date 22:48 2020/5/22
     * @param [list]
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean submitPaper(List<PaperInfoDto> list) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Achievement achievement = new Achievement();
            AchievementKey key = new AchievementKey();
            achievement.setExamId(list.get(0).getExamId());
            achievement.setStudentId(list.get(0).getStuId());
            key.setStudentId(list.get(0).getStuId());
            key.setExamId(list.get(0).getExamId());
            float score = 0;
            for(PaperInfoDto paper : list){
                AnswerPaper answerPaper = new AnswerPaper();
                answerPaper.setStuId(paper.getStuId());
                answerPaper.setExamId(paper.getExamId());
                answerPaper.setQuestionId(paper.getQuestionId());
                //当为多选题时，答案在checkList中
                if(paper.getTypeId() == 5){
                    StringBuilder answer = new StringBuilder();
                    for(String str : paper.getCheckList()){
                        if(!"".equals(str)){
                            answer.append(str);
                        }
                    }
                    paper.setStuAnswer(answer.toString());
                    answerPaper.setStuAnswer(answer.toString());
                }
                //当为填空题或者程序填空题时，答案在checkList中，对每个答案用;分割
                else if(paper.getTypeId() == 2 || paper.getTypeId() == 7){
                    StringBuilder answer = new StringBuilder();
                    for(String str : paper.getCheckList()){
                        answer.append(str);
                        answer.append(";");
                    }
                    answerPaper.setStuAnswer(answer.toString());
                }
                else if(paper.getStuAnswer() != null){
                    answerPaper.setStuAnswer(paper.getStuAnswer());
                }
                else{
                    answerPaper.setStuAnswer("");
                    answerPaper.setStuScore((float) 0);
                }
                if(!"".equals(answerPaper.getStuAnswer()) && answerPaper.getStuAnswer() != null){
                    //当是客观题时：单选、多选、填空、判断 则调用自动批改试卷接口
                    if(paper.getTypeId() == 1 || paper.getTypeId() == 2
                            ||paper.getTypeId() == 3 || paper.getTypeId() == 5
                            || paper.getTypeId() == 7){
                        answerPaper.setStuScore(autoCorrectPaper(paper));
                    }
                    else{
                        answerPaper.setStuScore((float) 0);
                    }
                }
                else{
                    answerPaper.setStuScore((float) 0);
                }
                score += answerPaper.getStuScore();
                answerPaperMapper.updateByPrimaryKeySelective(answerPaper);
            }
            achievement.setScore(score);
            if(achievementMapper.selectByPrimaryKey(key) != null){
                achievementMapper.updateByPrimaryKey(achievement);
            }
            else{
                achievementMapper.insert(achievement);
            }
            responseBean.setCode("200");
            responseBean.setMsg("提交试卷成功！");
        } catch (Exception e) {
            responseBean.setCode("500");
            responseBean.setMsg("提交试卷失败！");
            e.printStackTrace();
        }
        return responseBean;
    }
    // 字符转换成数字，相当于hashCode
    public static int[] getIntArray(String str) {
        int[] arrRet = new int[str.length()];
        int i = 0;
        for (char ch : str.toUpperCase().toCharArray()) {
            // 这本身没有必要-65，只不过想变成1234…更好理解
            arrRet[i++] = ch - 65;
        }
        return arrRet;
    }
    // 求和，原来也可以在循环转化成数字的时候做的，分开只是为了更容易理解。
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            // 相等于求hashCode
            sum += i * i * i + 100;
        }
        return sum;
    }

    @Override
    /**
     * Description 自动批改试卷（客观题）
     * @Author ZX
     * @Date 23:07 2020/5/22
     * @param [paperInfoDto]
     * @return java.lang.Float
     */
    public Float autoCorrectPaper(PaperInfoDto paperInfoDto) {
        //当是选择题或者判断题时
        if(paperInfoDto.getTypeId() == 1 || paperInfoDto.getTypeId() == 3){
            String answer = paperInfoDto.getAnswer();
            if(paperInfoDto.getStuAnswer().toUpperCase().equals(answer)){
                return paperInfoDto.getScore();
            }
            else{
                return (float) 0;
            }
        }
        //当时多选题时
        else if(paperInfoDto.getTypeId() == 5){
            int ansSum = sum(getIntArray(paperInfoDto.getAnswer()));
            int stuSum = sum(getIntArray(paperInfoDto.getStuAnswer()));
            if(ansSum == stuSum){
                return paperInfoDto.getScore();
            }
            else{
                return (float) 0;
            }
        }
        //当时填空题或者程序填空题时
        else if(paperInfoDto.getTypeId() == 2 || paperInfoDto.getTypeId() == 7){
            float sum = (float) 0;
            for(int i = 0;i < paperInfoDto.getAnswerList().size();i++){
                if(paperInfoDto.getAnswerList().get(i).equals(paperInfoDto.getCheckList().get(i))){
                    //计算每个空的分数
                    sum += paperInfoDto.getScore() / paperInfoDto.getAnswerList().size();
                }
            }
            return sum;
        }
        else{
            return (float) 0;
        }
    }

    @Override
    /**
     * Description 分页获取学生考试列表信息
     * @Author ZX
     * @Date 15:43 2020/5/25
     * @param [dataInfoDto]
     * option:用户身份
     * examId:考试编号
     * page:页码
     * count:每页数量
     * regexAnswer 分割班级的正则表达式
     * list:获取所选页面的学生成绩信息列表
     * map:学生考试列表信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> examStudentInit(DataInfoDto dataInfoDto) {
        Integer option = dataInfoDto.getOption();
        Integer examId = dataInfoDto.getKey();
        Integer page = dataInfoDto.getPage();
        Integer count = dataInfoDto.getCount();
        String regexAnswer = ";|；|\\s+";
        List<AchievementInfoDto> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (option == 2) {
            Exam exam = examMapper.selectByPrimaryKey(examId);
            String[] classRange = exam.getClassRange().split(regexAnswer);
            Integer[] classId = new Integer[classRange.length];
            Integer total = 0;
            //获取考试总人数与班级编号列表
            for(int i = 0;i < classRange.length;i++){
                classId[i] = UtilInteger.parseInt(classRange[i]);
                total += studentMapper.classCount(classId[i]);
            }
            //分页获取班级学生考试信息
            List<Integer> stuList = studentMapper.selectByClassPagin(classId,page,count);
            //配置成绩信息
            for(Integer value : stuList){
                AchievementInfoDto info = new AchievementInfoDto();
                AchievementKey key = new AchievementKey();
                key.setExamId(examId);
                key.setStudentId(value);
                Student student = studentMapper.selectByPrimaryKey(value);
                info.setStudentId(value);
                info.setExamId(examId);
                info.setClassId(student.getClassId());
                info.setClassName(classMapper.selectByPrimaryKey(student.getClassId()).getName());
                if(achievementMapper.selectByPrimaryKey(key)!= null){
                    info.setScore(achievementMapper.selectByPrimaryKey(key).getScore());
                }
                else{
                    info.setScore((float) 0);
                }
                info.setName(student.getName());
                info.setUsername(student.getUsername());
                info.setExamName(examMapper.selectByPrimaryKey(examId).getName());
                list.add(info);
            }
            //查询当前页面显示的课程列表
            map.put("list", list);
            map.put("total", total);
            return map;
        } else {
            return null;
        }
    }

    @Override
    /**
     * Description 教师提交阅卷
     * @Author ZX
     * @Date 20:21 2020/5/26
     * @param [list]
     * achievement 成绩信息
     * key 成绩主键
     * score 该学生试卷总成绩
     * @return com.zx.common.enums.ResponseBean
     */
    public ResponseBean submitCorrectPaper(List<PaperInfoDto> list) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Achievement achievement = new Achievement();
            AchievementKey key = new AchievementKey();
            achievement.setExamId(list.get(0).getExamId());
            achievement.setStudentId(list.get(0).getStuId());
            key.setStudentId(list.get(0).getStuId());
            key.setExamId(list.get(0).getExamId());
            float score = 0;
            for(PaperInfoDto paper : list){
                AnswerPaper answerPaper = new AnswerPaper();
                answerPaper.setStuId(paper.getStuId());
                answerPaper.setExamId(paper.getExamId());
                answerPaper.setQuestionId(paper.getQuestionId());
                answerPaper.setStuAnswer(paper.getStuAnswer());
                answerPaper.setScore(paper.getScore());
                answerPaper.setStuScore(paper.getStuScore());
                //将分数进行汇总
                score += paper.getStuScore();
                answerPaperMapper.updateByPrimaryKeySelective(answerPaper);
            }
            achievement.setScore(score);
            if(achievementMapper.selectByPrimaryKey(key) != null){
                achievementMapper.updateByPrimaryKey(achievement);
            }
            else{
                achievementMapper.insert(achievement);
            }
            responseBean.setCode("200");
            responseBean.setMsg("提交阅卷成功！");
        } catch (Exception e) {
            responseBean.setCode("500");
            responseBean.setMsg("提交阅卷失败！");
            e.printStackTrace();
        }
        return responseBean;
    }


}

