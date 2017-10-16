/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-16 16:40:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `man`;
CREATE TABLE `man` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '老婆名称',


  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;


-- ALTER TABLE student modify id int(11) unsigned NOT NULL AUTO_INCREMENT;
-- -- ----------------------------
-- -- Records of student
-- -- ----------------------------
INSERT INTO man VALUES('1','小明');
INSERT INTO man VALUES('2','小聪');
INSERT INTO man VALUES('3','老王');
INSERT INTO `man` VALUES (null,'awang');

-- INSERT INTO `student` VALUES ('1','awang','1',  '2014-07-10 07:08:28', '2', '河北寺家庄');
-- INSERT INTO `student` VALUES ('2','找高才','25',  '2014-07-10 07:08:28', '2', '河南濮阳');
-- INSERT INTO `student` VALUES ('10','应好像','28',  '2014-07-10 07:08:28', '2', '浙江丽水');
-- INSERT INTO `student` VALUES (null,'须知草','28',  '2014-07-10 07:08:28', '2', '浙江丽水');
-- INSERT INTO `student` VALUES (null,'须知草','28',  '2014-07-10 07:08:28', '2', '浙江丽水');
--
-- DELETE FROM student where id=28;
-- -- SET FOREIGN_KEY_CHECKS=1;
--
-- UPDATE student set address='河南商丘' where id=27;
--
-- SELECT * FROM student where age>10;
--
--  -- 修改表名
-- ALTER  TABLE student rename teacher;
--
--  -- 删除整张表
-- drop table teacher;
--
-- --  删除整个数据库
-- drop database test;




