/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_3306
 Source Server Type    : MySQL
 Source Server Version : 50142
 Source Host           : 127.0.0.1:3306
 Source Schema         : youbo

 Target Server Type    : MySQL
 Target Server Version : 50142
 File Encoding         : 65001

 Date: 02/09/2021 17:26:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_category
-- ----------------------------
DROP TABLE IF EXISTS `m_category`;
CREATE TABLE `m_category`  (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容描述',
  `summary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `post_count` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '该分类的内容数量',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序编码',
  `parent_id` bigint(32) UNSIGNED NULL DEFAULT NULL COMMENT '父级分类的ID',
  `meta_keywords` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SEO关键字',
  `meta_description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SEO描述内容',
  `created` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `modified` datetime NULL DEFAULT NULL,
  `status` tinyint(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of m_category
-- ----------------------------
INSERT INTO `m_category` VALUES (1, '提问', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '2020-04-28 22:36:48', NULL, 0);
INSERT INTO `m_category` VALUES (2, '分享', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '2020-04-28 22:36:48', NULL, 0);
INSERT INTO `m_category` VALUES (3, '讨论', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '2020-04-28 22:36:48', NULL, 0);
INSERT INTO `m_category` VALUES (4, '建议', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, '2020-04-28 22:36:48', NULL, 0);

-- ----------------------------
-- Table structure for m_comment
-- ----------------------------
DROP TABLE IF EXISTS `m_comment`;
CREATE TABLE `m_comment`  (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论的内容',
  `parent_id` bigint(32) NULL DEFAULT NULL COMMENT '回复的评论ID',
  `post_id` bigint(32) NOT NULL COMMENT '评论的内容ID',
  `user_id` bigint(32) NOT NULL COMMENT '评论的用户ID',
  `vote_up` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '“顶”的数量',
  `vote_down` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '“踩”的数量',
  `level` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '置顶等级',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '评论的状态',
  `created` datetime NOT NULL COMMENT '评论的时间',
  `modified` datetime NULL DEFAULT NULL COMMENT '评论的更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for m_post
-- ----------------------------
DROP TABLE IF EXISTS `m_post`;
CREATE TABLE `m_post`  (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `edit_mode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '编辑模式：html可视化，markdown ..',
  `category_id` bigint(32) NULL DEFAULT NULL,
  `user_id` bigint(32) NULL DEFAULT NULL COMMENT '用户ID',
  `vote_up` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '支持人数',
  `vote_down` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '反对人数',
  `view_count` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '访问量',
  `comment_count` int(11) NOT NULL DEFAULT 0 COMMENT '评论数量',
  `recommend` tinyint(1) NULL DEFAULT NULL COMMENT '是否为精华',
  `level` tinyint(2) NOT NULL DEFAULT 0 COMMENT '置顶等级',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '状态',
  `created` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `modified` datetime NULL DEFAULT NULL COMMENT '最后更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of m_post
-- ----------------------------
INSERT INTO `m_post` VALUES (1, 'Github上最值得学习的100个Java开源项目，涵盖各种技术栈！', ' 你有多久没好好学习一个开源项目了？\n\n你是否经常为找不到好的开源项目而烦恼？\n\n你是否为不知道怎么入手去看一个开源项目？\n\n你是否想看别人的项目学习笔记？\n\n你是否想跟着别人的项目搭建过程一步一步跟着做项目？\n\n为了让更多Java的开发者能更容易找到值得学习的开源项目，我搭建了这个Java开源学习网站，宗旨梳理Java知识，共享开源项目笔记。来瞧一瞧：\n\nimg[//image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/20200414/473f73a3eb6f471e8154620a9c1d5306.png] \n\n网站截图中可以看出，点击筛选条件组合之后，再点击搜索就会搜索出对应的开源项目。\n\n比如打开renren-fast项目，可以看到具体项目的信息，以及模块解析。\n\nimg[//image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/20200414/f74740692dab4d9c937cd56336ead1b4.png]\n\n这样，学习一个开源项目就不再费劲，每天学习一个开源项目，在不知不觉中提升技术水平！目前网站已经收录了近100个开源项目，让Java不再难懂！\n\n直接扫公众号下方的二维码，回复关键字【网站】即可获得网站的域名地址！\n\nimg[//image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/20200414/f58f7c6d038c4dfb99bd9cf40935392e.png]\n\n关注上方的公众号二维码\n\n回复【网站】即可获取项目域名地址。\n', '0', 1, 1, 0, 0, 5, 0, 1, 1, NULL, '2020-04-28 14:41:41', '2020-04-28 14:41:41');
INSERT INTO `m_post` VALUES (2, '关注公众号：MarkerHub，一起学习Java', '关注学习：\n\nimg[//image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/20200414/f58f7c6d038c4dfb99bd9cf40935392e.png] ', '0', 1, 1, 0, 0, 3, 0, 1, 1, NULL, '2020-04-28 14:55:16', '2020-04-28 14:55:16');
INSERT INTO `m_post` VALUES (3, '111111111111', '1222222222222222', '0', 1, 1, 0, 0, 1, 0, 0, 0, NULL, '2020-04-28 14:55:48', '2020-04-28 14:55:48');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user`  (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件',
  `mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机电话',
  `point` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '积分',
  `sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `gender` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `wechat` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `vip_level` int(32) NULL DEFAULT NULL COMMENT 'vip等级',
  `birthday` datetime NULL DEFAULT NULL COMMENT '生日',
  `avatar` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `post_count` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '内容数量',
  `comment_count` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论数量',
  `status` tinyint(2) NOT NULL DEFAULT 0 COMMENT '状态',
  `lasted` datetime NULL DEFAULT NULL COMMENT '最后的登陆时间',
  `created` datetime NOT NULL COMMENT '创建日期',
  `modified` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for m_user_action
-- ----------------------------
DROP TABLE IF EXISTS `m_user_action`;
CREATE TABLE `m_user_action`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `action` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '动作类型',
  `point` int(11) NULL DEFAULT NULL COMMENT '得分',
  `post_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联的帖子ID',
  `comment_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联的评论ID',
  `created` datetime NULL DEFAULT NULL,
  `modified` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for m_user_collection
-- ----------------------------
DROP TABLE IF EXISTS `m_user_collection`;
CREATE TABLE `m_user_collection`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `post_user_id` bigint(20) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for m_user_message
-- ----------------------------
DROP TABLE IF EXISTS `m_user_message`;
CREATE TABLE `m_user_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_user_id` bigint(20) NOT NULL COMMENT '发送消息的用户ID',
  `to_user_id` bigint(20) NOT NULL COMMENT '接收消息的用户ID',
  `post_id` bigint(20) NULL DEFAULT NULL COMMENT '消息可能关联的帖子',
  `comment_id` bigint(20) NULL DEFAULT NULL COMMENT '消息可能关联的评论',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '消息类型',
  `created` datetime NOT NULL,
  `modified` datetime NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
