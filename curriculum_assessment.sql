/*
 Navicat Premium Data Transfer

 Source Server         : 49.232.139.221
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 49.232.139.221:3306
 Source Schema         : curriculum_assessment

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 10/05/2020 15:17:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `student_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `exam_id` int(0) NOT NULL COMMENT '考试编号',
  `score` float NULL DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`student_id`, `exam_id`) USING BTREE,
  INDEX `achievement_exam`(`exam_id`) USING BTREE,
  CONSTRAINT `achievement_exam` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `achievement_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for answer_paper
-- ----------------------------
DROP TABLE IF EXISTS `answer_paper`;
CREATE TABLE `answer_paper`  (
  `exam_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '试卷编号',
  `question_id` int(0) NOT NULL COMMENT '题目编号',
  `stu_id` int(0) NOT NULL COMMENT '学生编号',
  `stu_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生答案',
  `score` float NULL DEFAULT NULL COMMENT '分值',
  `stu_score` float NULL DEFAULT NULL COMMENT '得分',
  PRIMARY KEY (`exam_id`, `question_id`, `stu_id`) USING BTREE,
  INDEX `paper_question`(`question_id`) USING BTREE,
  INDEX `paper_student`(`stu_id`) USING BTREE,
  CONSTRAINT `paper_exam` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paper_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paper_student` FOREIGN KEY (`stu_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '章节编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '班级编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `count` int(0) NULL DEFAULT NULL COMMENT '班级人数',
  `college_id` int(0) NULL DEFAULT NULL COMMENT '所属学院编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `class_college`(`college_id`) USING BTREE,
  CONSTRAINT `class_college` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学院编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for curriculum
-- ----------------------------
DROP TABLE IF EXISTS `curriculum`;
CREATE TABLE `curriculum`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `chapter_count` int(0) NULL DEFAULT NULL COMMENT '课程章节数',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程信息简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 266 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '考试编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试名称',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '考试开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '考试结束时间',
  `total_score` int(0) NULL DEFAULT NULL COMMENT '考试总分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge`  (
  `id` int(0) NOT NULL COMMENT '知识点编号',
  `curriculum_id` int(0) NULL DEFAULT NULL COMMENT '课程编号',
  `chapter_id` int(0) NULL DEFAULT NULL COMMENT '章节编号',
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '知识点内容',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '知识点标题',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `study_curriculum`(`curriculum_id`) USING BTREE,
  INDEX `study_chapter`(`chapter_id`) USING BTREE,
  CONSTRAINT `study_chapter` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `study_curriculum` FOREIGN KEY (`curriculum_id`) REFERENCES `curriculum` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `issue_range` int(0) NULL DEFAULT NULL COMMENT '谁可以看到：0:全部用户；1:学生；2:教师；3:管理员；',
  `identity` int(0) NULL DEFAULT NULL COMMENT '发布人身份：1:管理员；2:教师',
  `identity_id` int(0) NULL DEFAULT NULL COMMENT '发布人编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice_log
-- ----------------------------
DROP TABLE IF EXISTS `notice_log`;
CREATE TABLE `notice_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `notice_id` int(0) NULL DEFAULT NULL COMMENT '公告编号',
  `stu_id` int(0) NULL DEFAULT NULL COMMENT '学生编号',
  `teacher_id` int(0) NULL DEFAULT NULL COMMENT '教师编号',
  `admin_id` int(0) NULL DEFAULT NULL COMMENT '管理员编号',
  `state` int(0) NULL DEFAULT NULL COMMENT '当前公告状态：1：已阅读；2：删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `log_student`(`stu_id`) USING BTREE,
  INDEX `log_teacher`(`teacher_id`) USING BTREE,
  INDEX `log_admin`(`admin_id`) USING BTREE,
  INDEX `log_notice`(`notice_id`) USING BTREE,
  CONSTRAINT `log_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `log_notice` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `log_student` FOREIGN KEY (`stu_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `log_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '题目编号',
  `type_id` int(0) NULL DEFAULT NULL COMMENT '题型编号',
  `stem` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题干',
  `option_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项A',
  `option_b` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项B',
  `option_c` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项C',
  `option_d` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项D',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案',
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键词：每个关键词之间用；隔开',
  `curriculum_id` int(0) NULL DEFAULT NULL COMMENT '课程编号',
  `chapter_id` int(0) NULL DEFAULT NULL COMMENT '章节编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `question_type`(`type_id`) USING BTREE,
  INDEX `question_curriculum`(`curriculum_id`) USING BTREE,
  INDEX `question_chapter`(`chapter_id`) USING BTREE,
  CONSTRAINT `question_chapter` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `question_curriculum` FOREIGN KEY (`curriculum_id`) REFERENCES `curriculum` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `question_type` FOREIGN KEY (`type_id`) REFERENCES `question_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '题型编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for registration_key
-- ----------------------------
DROP TABLE IF EXISTS `registration_key`;
CREATE TABLE `registration_key`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '注册码编号',
  `key_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册码名称',
  `register_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册码内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `stu_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `class_id` int(0) NULL DEFAULT NULL COMMENT '班级编号',
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `gender` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_class`(`class_id`) USING BTREE,
  CONSTRAINT `student_class` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for study
-- ----------------------------
DROP TABLE IF EXISTS `study`;
CREATE TABLE `study`  (
  `stu_id` int(0) NOT NULL COMMENT '学生编号',
  `knows_id` int(0) NOT NULL COMMENT '知识点编号',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '学习知识点开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '学习知识点结束时间',
  `state` int(0) NULL DEFAULT NULL COMMENT '1:理解；2:不理解、有疑问',
  `questions` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对该知识点的疑问或想法',
  PRIMARY KEY (`stu_id`, `knows_id`) USING BTREE,
  INDEX `study_knowledge`(`knows_id`) USING BTREE,
  CONSTRAINT `study_knowledge` FOREIGN KEY (`knows_id`) REFERENCES `knowledge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `study_student` FOREIGN KEY (`stu_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '教师编号',
  `teacher_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教职工编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `college_id` int(0) NULL DEFAULT NULL COMMENT '所属学院',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `teacher_college`(`college_id`) USING BTREE,
  CONSTRAINT `teacher_college` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teaching
-- ----------------------------
DROP TABLE IF EXISTS `teaching`;
CREATE TABLE `teaching`  (
  `teacher_id` int(0) NOT NULL COMMENT '教师编号',
  `curriculum_id` int(0) NOT NULL COMMENT '课程编号',
  `class_id` int(0) NOT NULL COMMENT '班级编号',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '授课开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '授课结束时间',
  PRIMARY KEY (`teacher_id`, `curriculum_id`, `class_id`) USING BTREE,
  INDEX `teaching_curriculum`(`curriculum_id`) USING BTREE,
  INDEX `teaching_class`(`class_id`) USING BTREE,
  CONSTRAINT `teaching_class` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teaching_curriculum` FOREIGN KEY (`curriculum_id`) REFERENCES `curriculum` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teaching_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
