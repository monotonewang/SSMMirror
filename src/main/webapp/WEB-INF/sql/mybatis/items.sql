/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-02-23 09:42:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '商品名称',
  `price` float(10,1) NOT NULL COMMENT '商品定价',
  `detail` text COMMENT '商品描述',
  `pic` varchar(64) DEFAULT NULL COMMENT '商品图片',
  `createtime` datetime NOT NULL COMMENT '生产日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '台式机', '3000.0', '该电脑质量非常好！！！！', null, '1997-02-05 20:01:00');
INSERT INTO `items` VALUES ('2', '笔记本', '6000.0', '笔记本性能好，质量好！！！x！！', '511fe69b-efb7-4343-99fb-2b0272f0efc5.png', '2015-02-09 13:22:57');
INSERT INTO `items` VALUES ('3', '背包', '200.0', '名牌背包，容量大质量好！！！！', null, '1998-02-26 20:11:00');
INSERT INTO `items` VALUES ('4', 'fdsf', '12.1', 'eet', null, '2012-12-01 19:12:12');
INSERT INTO `items` VALUES ('5', 'tete', '12.1', 'placeholder=\"请在这里输入商品详情\"', null, '2012-12-01 19:12:12');
INSERT INTO `items` VALUES ('6', 'fdsf', '12.1', 'placeholder=\"请在这里输入商品详情\"12', '59f02a79-feaa-4bbe-860c-de07ba60ca6f.png', '2012-12-01 19:12:12');
INSERT INTO `items` VALUES ('7', '121212', '12.1', 'placeholder=\"请在这里输入商品详情\"', 'a1da3477-a4c6-471d-beb5-a28095bae9b2.png', '2017-02-02 00:00:00');
INSERT INTO `items` VALUES ('8', '11111', '12.1', 'placeholder=\"请在这里输入商品详情\"', 'd248400c-c61b-4064-8213-d80c147c2ec5.png', '2017-02-20 00:00:00');
SET FOREIGN_KEY_CHECKS=1;
