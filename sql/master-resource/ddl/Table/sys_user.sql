/*
Navicat MySQL Data Transfer

Date: 2017-04-18
Author: zhongqs
*/

-- ----------------------------
-- Table structure for `user`
-- Date: 2017-04-18
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SSO_ID` varchar(20) COLLATE utf8_bin NOT NULL,
  `PASSWORD` varchar(100) COLLATE utf8_bin NOT NULL,
  `FIRST_NAME` varchar(20) COLLATE utf8_bin NOT NULL,
  `LAST_NAME` varchar(20) COLLATE utf8_bin NOT NULL,
  `EMAIL` varchar(20) COLLATE utf8_bin NOT NULL,
  `STATE` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
