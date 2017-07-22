/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : test_web

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-07-20 18:15:51
*/


-- ----------------------------
-- Table structure for arti_article
-- ----------------------------
DROP TABLE IF EXISTS `arti_article`;
CREATE TABLE `arti_article` (
  `id` int(11) NOT NULL,
  `title` varchar(40) DEFAULT NULL COMMENT '标题',
  `keywords` varchar(100) DEFAULT NULL COMMENT '关键字',
  `insert_user` varchar(20) DEFAULT NULL COMMENT '发布人',
  `insert_time` datetime DEFAULT NULL COMMENT '插入日期',
  `type_id` int(11) DEFAULT NULL COMMENT '所属栏目',
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for arti_co_type
-- ----------------------------
DROP TABLE IF EXISTS `arti_co_type`;
CREATE TABLE `arti_co_type` (
  `id` int(11) NOT NULL COMMENT '栏目分类字典表',
  `title` varchar(100) DEFAULT NULL COMMENT '栏目标题',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ;
INSERT INTO `arti_co_type` VALUES ('1', '最新资讯', '最新资讯');
INSERT INTO `arti_co_type` VALUES ('2', '公告', null);
INSERT INTO `arti_co_type` VALUES ('3', '关于我们', null);
-- ----------------------------
-- Table structure for art_article_content
-- ----------------------------
DROP TABLE IF EXISTS `art_article_content`;
CREATE TABLE `art_article_content` (
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `content` varchar(1000) DEFAULT NULL COMMENT '文章内容',
  PRIMARY KEY (`article_id`)
) ;

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` int(11) NOT NULL COMMENT '登录日志表',
  `insert_user` varchar(10) DEFAULT NULL COMMENT '操作人',
  `insert_time` datetime DEFAULT NULL COMMENT '操作时间',
  `content` varchar(255) DEFAULT NULL COMMENT '操作内容',
  PRIMARY KEY (`id`)
) 

-- ----------------------------
-- Table structure for sys_operateor_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operateor_log`;
CREATE TABLE `sys_operateor_log` (
  `id` int(11) NOT NULL COMMENT '操作日志表',
  `insert_user` varchar(10) DEFAULT NULL COMMENT '操作人',
  `insert_time` datetime DEFAULT NULL COMMENT '操作时间',
  `content` varchar(255) DEFAULT NULL COMMENT '操作内容',
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `login_id` varchar(20) NOT NULL COMMENT '用户表',
  `passward` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `telphone` varchar(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
);
