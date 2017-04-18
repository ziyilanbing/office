/*
Navicat MySQL Data Transfer

Date: 2017-04-18
Author: zhongqs
*/

-- ----------------------------
-- Table structure for `sys_user_role_rel
-- Date: 2017-04-18`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_rel`;
CREATE TABLE `sys_user_role_rel` (
  `USER_ID` int(11) NOT NULL COMMENT '用戶ID',
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `roleIdFer` (`ROLE_ID`),
  CONSTRAINT `roleIdFer` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`),
  CONSTRAINT `userIdFer` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 