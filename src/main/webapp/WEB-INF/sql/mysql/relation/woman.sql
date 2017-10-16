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
DROP TABLE IF EXISTS `woman`;
CREATE TABLE `woman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '老婆名称',
  `husband`  int(11) UNIQUE,
--    `man_fk` FOREIGN KEY(`husband`) REFERENCES man(`id`),
  CONSTRAINT man_fk FOREIGN KEY(husband) REFERENCES man(id),
-- CONSTRAINT
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;


-- ALTER TABLE student modify id int(11) unsigned NOT NULL AUTO_INCREMENT;
-- -- ----------------------------
-- -- Records of student
-- -- ----------------------------
INSERT INTO `woman` VALUES (null,'gaocai',1);
INSERT INTO woman VALUES('1','小花','2');
INSERT INTO woman VALUES('2','小静','1');
-- Error:违反1对1
INSERT INTO woman VALUES('3','小红','1');
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




