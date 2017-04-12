/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-02-21 20:47:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `series` varchar(64) COLLATE utf8_bin NOT NULL,
  `token` varchar(64) COLLATE utf8_bin NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('admin', 'aLAjZ4MqChVbZzSFD2wxNQ==', '05mz79RtK2UB5ef1PyIhEw==', '2017-02-20 21:46:27');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_TYPE` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'USER');
INSERT INTO `role` VALUES ('2', 'DBA');
INSERT INTO `role` VALUES ('3', 'ADMIN');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SSO_ID` varchar(20) COLLATE utf8_bin NOT NULL,
  `PASSWORD` varchar(100) COLLATE utf8_bin NOT NULL,
  `FIRST_NAME` varchar(20) COLLATE utf8_bin NOT NULL,
  `LAST_NAME` varchar(20) COLLATE utf8_bin NOT NULL,
  `EMAIL` varchar(20) COLLATE utf8_bin NOT NULL,
  `STATE` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jack', 'Jz0XxZh3K2MJtAEvDhL3zA==', 'jack', 'nie', 'jack@qq.com', 'Active');
INSERT INTO `user` VALUES ('2', 'admin', 'Ucpd/waMOTiZIzJRRQ2V4g==', 'admin', 'nie', 'admin@qq.com', 'Active');
INSERT INTO `user` VALUES ('3', 'dba', 'xgRU1Vr3ekiTkPTDgMFu9g==', 'dba', 'nie', 'dba@qq.com', 'Active');

-- ----------------------------
-- Table structure for `user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_rel`;
CREATE TABLE `user_role_rel` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `roleIdFer` (`ROLE_ID`),
  CONSTRAINT `roleIdFer` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`),
  CONSTRAINT `userIdFer` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_role_rel
-- ----------------------------
INSERT INTO `user_role_rel` VALUES ('1', '1');
INSERT INTO `user_role_rel` VALUES ('3', '2');
INSERT INTO `user_role_rel` VALUES ('2', '3');
INSERT INTO `user_role_rel` VALUES ('3', '3');
