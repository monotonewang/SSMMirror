/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-02-23 09:40:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `pic` varchar(64) DEFAULT NULL,
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王五', null, '2014-07-10', '2', null);
INSERT INTO `user` VALUES ('10', '张三', null, '2014-07-10', '1', '北京市');
INSERT INTO `user` VALUES ('16', '张小明', null, '2014-07-10', '1', '河南郑州');
INSERT INTO `user` VALUES ('22', '陈小明', null, '2014-07-10', '1', '河南郑州');
INSERT INTO `user` VALUES ('24', '张三丰', null, '2014-07-10', '1', '河南郑州');
INSERT INTO `user` VALUES ('26', '王五', null, '2014-07-10', null, null);
SET FOREIGN_KEY_CHECKS=1;
