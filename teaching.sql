/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : teaching

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 15/12/2020 22:39:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`, `username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for choose_class
-- ----------------------------
DROP TABLE IF EXISTS `choose_class`;
CREATE TABLE `choose_class`  (
  `choose_class_id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`choose_class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of choose_class
-- ----------------------------
INSERT INTO `choose_class` VALUES (2, '1', '0003');
INSERT INTO `choose_class` VALUES (3, '2', '0001');
INSERT INTO `choose_class` VALUES (4, '2', '0002');
INSERT INTO `choose_class` VALUES (6, '1', '005');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `term` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `teacher_id` int(255) NOT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'C语言', '1', '2020-12-14 23:05:06', '2021-03-01 23:05:11', '11栋101', 100, 1);
INSERT INTO `course` VALUES (2, '数据结构', '1', '2020-12-14 23:06:00', '2021-01-01 23:06:03', '11栋202', 50, 1);
INSERT INTO `course` VALUES (3, 'JAVA', '1', '2020-12-14 23:06:29', '2021-02-01 23:06:32', '18栋301', 150, 1);
INSERT INTO `course` VALUES (4, '算法', '1', '2020-12-14 23:06:59', '2021-01-21 23:07:02', '11栋601', 60, 2);
INSERT INTO `course` VALUES (5, '数据库系统', '1', '2020-12-14 23:07:29', '2021-02-12 23:07:32', '18栋302', 80, 2);

-- ----------------------------
-- Table structure for stu_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `stu_evaluation`;
CREATE TABLE `stu_evaluation`  (
  `stu_evaluation_id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` int(255) NULL DEFAULT NULL,
  `teacher_id` int(255) NULL DEFAULT NULL,
  `str1` int(255) NULL DEFAULT NULL,
  `str2` int(255) NULL DEFAULT NULL,
  `str3` int(255) NULL DEFAULT NULL,
  `str4` int(255) NULL DEFAULT NULL,
  `str5` int(255) NULL DEFAULT NULL,
  `str6` int(255) NULL DEFAULT NULL,
  `sum` int(255) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stu_evaluation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stu_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'zs001', '123456', '张三', '1107001', '男', '信科', '软工1701');
INSERT INTO `student` VALUES (2, 'ls001', '123456', '李四', '1107002', '男', '信科', '软工1701');
INSERT INTO `student` VALUES (3, 'ww001', '123456', '王五', NULL, NULL, '机电', NULL);

-- ----------------------------
-- Table structure for t_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluation`;
CREATE TABLE `t_evaluation`  (
  `t_evaluation_id` int(8) NOT NULL AUTO_INCREMENT,
  `teacher_id1` int(255) NULL DEFAULT NULL,
  `teacher_id2` int(255) NULL DEFAULT NULL,
  `str1` int(255) NULL DEFAULT NULL,
  `str2` int(255) NULL DEFAULT NULL,
  `str3` int(255) NULL DEFAULT NULL,
  `str4` int(255) NULL DEFAULT NULL,
  `str5` int(255) NULL DEFAULT NULL,
  `str6` int(255) NULL DEFAULT NULL,
  `sum` int(255) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`t_evaluation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`, `username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 't1', '123123', '张老师', '1001', '男', '信科');
INSERT INTO `teacher` VALUES (2, 't2', '111222', '李老师', '1002', '女', '机电');

SET FOREIGN_KEY_CHECKS = 1;
